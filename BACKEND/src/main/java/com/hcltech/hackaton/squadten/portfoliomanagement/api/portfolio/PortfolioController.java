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
    public AddTradeResponse addTrade(@PathVariable String portfolioId, @RequestBody AddTradeRequest addTradeRequest) {

        tradeService.addTrade(addTradeRequest);

        return AddTradeResponse.builder()
                .portfolioId(portfolioId)
                .tradeInstrumentId(addTradeRequest.getInstrumentId())
                .build();
    }

    @PostMapping("/{portfolioId}/audit")
    @ResponseBody
    public AddTradeResponse getAudit(@PathVariable String portfolioId) {
        return AddTradeResponse.builder()
                .portfolioId(portfolioId)
                .tradeInstrumentId("123")
                .build();
    }
}
