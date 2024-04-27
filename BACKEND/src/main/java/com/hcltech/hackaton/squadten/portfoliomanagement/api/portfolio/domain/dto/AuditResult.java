package com.hcltech.hackaton.squadten.portfoliomanagement.api.portfolio.domain.dto;

import com.hcltech.hackaton.squadten.portfoliomanagement.api.portfolio.common.TradeType;
import java.time.LocalDateTime;

public interface AuditResult {
    String getTransactionRef();
    String getInstrumentId();
    String getInstrumentName();
    TradeType getTradeType();
    LocalDateTime getAuditDate();
}
