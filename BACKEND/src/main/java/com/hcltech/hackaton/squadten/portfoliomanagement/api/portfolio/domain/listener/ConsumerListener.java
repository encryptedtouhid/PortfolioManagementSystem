package com.hcltech.hackaton.squadten.portfoliomanagement.api.portfolio.domain.listener;

import com.hcltech.hackaton.squadten.portfoliomanagement.api.portfolio.domain.entity.Audit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ConsumerListener {

    @KafkaListener(topics = "viettq_kafka", groupId = "${kafka-consumer-group-id-user}",
            containerFactory = "kafkaListenerContainerObjectFactory")
    public void comsumerJson(Audit user) {
        log.info("Consumer Json: " + user);
    }
}
