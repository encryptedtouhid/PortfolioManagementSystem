package com.hcltech.hackaton.squadten.portfoliomanagement.connectors.kafka;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class AuditMessage {
    private int id = 1;
    private String portfolioId;
}
