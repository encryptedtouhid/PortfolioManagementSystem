package com.hcltech.hackaton.squadten.portfoliomanagement.api.portfolio;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AddTradeRequest {

    private int id = 1;
    private String portfolioId;
}
