package com.hcltech.hackaton.squadten.portfoliomanagement.api.portfolio.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Audit {
    @Id
    private String id;

    @Column(name = "transaction_ref")
    private String transactionRef;

    @Column(name = "portfolio_id")
    private String portfolioId;
    @Column(name = "instrument_id")
    private String instrumentId;

    @Column(name = "unit")
    private String unit;

    @Column(name = "trade_type")
    private String tradeType;

    @Column(name = "audit_date")
    private LocalDateTime auditDate;
}
