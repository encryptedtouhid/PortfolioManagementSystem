package com.hcltech.hackaton.squadten.portfoliomanagement.api.portfolio;

import com.hcltech.hackaton.squadten.portfoliomanagement.trades.TradeService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/portfolios")
public class PortfolioController {

    private final TradeService tradeService;

    public PortfolioController(TradeService tradeService) {
        this.tradeService = tradeService;
    }

    @PostMapping("/{portfolioId}/addTrade")
    @ResponseBody
    public AddTradeResponse addTrade(@PathVariable String portfolioId) {
        tradeService.addTrade(AddTradeRequest.builder().portfolioId(portfolioId).build());
        return AddTradeResponse.builder()
                .portfolioId(portfolioId)
                .tradeId("123")
                .build();
    }
}
