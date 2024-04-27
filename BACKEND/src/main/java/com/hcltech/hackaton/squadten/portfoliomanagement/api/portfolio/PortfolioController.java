package com.hcltech.hackaton.squadten.portfoliomanagement.api.portfolio;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/portfolios")
public class PortfolioController {

    @PostMapping("/{portfolioId}/addTrade")
    @ResponseBody
    public AddTradeResponse addTrade(@PathVariable String portfolioId) {
        return AddTradeResponse.builder()
                .portfolioId(portfolioId)
                .tradeId("123")
                .build();
    }

    @PostMapping("/{portfolioId}/audit")
    @ResponseBody
    public AddTradeResponse getAudit(@PathVariable String portfolioId) {
        return AddTradeResponse.builder()
                .portfolioId(portfolioId)
                .tradeId("123")
                .build();
    }
}
