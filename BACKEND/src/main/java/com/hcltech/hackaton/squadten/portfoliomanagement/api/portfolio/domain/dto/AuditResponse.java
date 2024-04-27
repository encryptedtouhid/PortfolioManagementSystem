package com.hcltech.hackaton.squadten.portfoliomanagement.api.portfolio.domain.dto;

import com.hcltech.hackaton.squadten.portfoliomanagement.api.portfolio.common.TradeType;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record AuditResponse(
        String transactionRef,
        String instrumentId,
        String instrumentName,
        TradeType tradeType,
        LocalDateTime auditDate
) {
}
