package com.hcltech.hackaton.squadten.portfoliomanagement.api.portfolio;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AddTradeResponse {

    private String portfolioId;
    private String tradeInstrumentId;
}
