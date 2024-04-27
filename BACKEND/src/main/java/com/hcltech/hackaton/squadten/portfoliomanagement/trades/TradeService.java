package com.hcltech.hackaton.squadten.portfoliomanagement.trades;

import com.hcltech.hackaton.squadten.portfoliomanagement.api.portfolio.AddTradeRequest;
import com.hcltech.hackaton.squadten.portfoliomanagement.connectors.kafka.KafkaAuditProducer;
import org.springframework.stereotype.Service;

@Service
public class TradeService {

    private final KafkaAuditProducer auditProducer;

    public TradeService(KafkaAuditProducer auditProducer) {
        this.auditProducer = auditProducer;
    }

    public void addTrade(AddTradeRequest addTradeRequest) {
        auditProducer.sendMessage(addTradeRequest);
    }
}
