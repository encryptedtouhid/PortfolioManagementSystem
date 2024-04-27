package com.hcltech.hackaton.squadten.portfoliomanagement.api.portfolio;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Builder
public class AddTradeRequest {

    private int id = 1;
    private String portfolioId;
    private TradeType tradeType;
    private BigDecimal tradeValue;
    private int units;
    private String instrumentId;
}