package com.hcltech.hackaton.squadten.portfoliomanagement.connectors.kafka;

import com.hcltech.hackaton.squadten.portfoliomanagement.api.portfolio.TradeType;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

@Builder
@Getter
public class AuditMessage {
    private int id = 1;
    private String portfolioId;
    private TradeType tradeType;
    private BigDecimal tradeValue;
    private int units;
    private String instrumentId;
    private String auditDate;

}
