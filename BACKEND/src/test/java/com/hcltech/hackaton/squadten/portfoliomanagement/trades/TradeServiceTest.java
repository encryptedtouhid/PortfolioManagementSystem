package com.hcltech.hackaton.squadten.portfoliomanagement.trades;

import com.hcltech.hackaton.squadten.portfoliomanagement.api.portfolio.AddTradeRequest;
import com.hcltech.hackaton.squadten.portfoliomanagement.api.portfolio.TradeType;
import com.hcltech.hackaton.squadten.portfoliomanagement.connectors.kafka.AuditMessage;
import com.hcltech.hackaton.squadten.portfoliomanagement.connectors.kafka.KafkaAuditProducer;
import com.hcltech.hackaton.squadten.portfoliomanagement.trades.TradeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;

import static org.mockito.Mockito.verify;

public class TradeServiceTest {

    @Mock
    private KafkaAuditProducer auditProducer;

    private TradeService tradeService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        tradeService = new TradeService(auditProducer);
    }

    @Test
    public void addTradeSendsCorrectAuditMessage() {
        AddTradeRequest addTradeRequest = AddTradeRequest.builder()
                .portfolioId("portfolio1")
                .tradeType(TradeType.BUY)
                .tradeValue(new BigDecimal("100.00"))
                .units(10)
                .instrumentId("instrument1")
                .build();

        AuditMessage expectedMessage = AuditMessage.builder()
                .tradeType(addTradeRequest.getTradeType())
                .instrumentId(addTradeRequest.getInstrumentId())
                .portfolioId(addTradeRequest.getPortfolioId())
                .tradeValue(addTradeRequest.getTradeValue())
                .units(addTradeRequest.getUnits())
                .build();

        tradeService.addTrade(addTradeRequest);

        verify(auditProducer).sendMessage(expectedMessage);
    }
}