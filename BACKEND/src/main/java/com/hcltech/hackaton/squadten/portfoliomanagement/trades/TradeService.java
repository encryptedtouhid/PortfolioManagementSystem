package com.hcltech.hackaton.squadten.portfoliomanagement.trades;

import com.hcltech.hackaton.squadten.portfoliomanagement.api.portfolio.AddTradeRequest;
import com.hcltech.hackaton.squadten.portfoliomanagement.connectors.kafka.AuditMessage;
import com.hcltech.hackaton.squadten.portfoliomanagement.connectors.kafka.KafkaAuditProducer;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class TradeService {

    private final KafkaAuditProducer auditProducer;

    public TradeService(KafkaAuditProducer auditProducer) {
        this.auditProducer = auditProducer;
    }

    public void addTrade(AddTradeRequest addTradeRequest) {
        AuditMessage message = AuditMessage.builder().tradeType(addTradeRequest.getTradeType())
                .instrumentId(addTradeRequest.getInstrumentId())
                .portfolioId(addTradeRequest.getPortfolioId())
                .tradeValue(addTradeRequest.getTradeValue())
                .units(addTradeRequest.getUnits())
                .auditDate(ZonedDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME))
                .build();
        auditProducer.sendMessage(message);
    }


}
