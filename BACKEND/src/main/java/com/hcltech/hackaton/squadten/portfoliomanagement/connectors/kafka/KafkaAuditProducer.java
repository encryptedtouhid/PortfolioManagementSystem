package com.hcltech.hackaton.squadten.portfoliomanagement.connectors.kafka;

import com.hcltech.hackaton.squadten.portfoliomanagement.api.portfolio.AddTradeRequest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class KafkaAuditProducer {
    private static final String TOPIC = "audit";

    private final KafkaTemplate<String, AuditMessage> kafkaTemplate;

    public KafkaAuditProducer(KafkaTemplate<String, AuditMessage> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(AddTradeRequest tradeRequest) {
        this.kafkaTemplate.send(TOPIC, AuditMessage.builder().id(123).portfolioId(UUID.randomUUID().toString()).build());
    }
}
