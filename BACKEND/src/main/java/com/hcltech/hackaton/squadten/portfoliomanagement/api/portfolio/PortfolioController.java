package com.hcltech.hackaton.squadten.portfoliomanagement.api.portfolio;

import com.hcltech.hackaton.squadten.portfoliomanagement.api.portfolio.domain.Position;
import com.hcltech.hackaton.squadten.portfoliomanagement.trades.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/portfolios")
public class PortfolioController {
    @Autowired
    private JdbcTemplate jdbcTemplate;
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

    @PostMapping("/{portfolioId}/audit")
    @ResponseBody
    public AddTradeResponse getAudit(@PathVariable String portfolioId) {
        return AddTradeResponse.builder()
                .portfolioId(portfolioId)
                .tradeId("123")
                .build();
    }

    @GetMapping("/portfolios/{portfolioId}/currentPositions/") //http://localhost:8080/portfolios/1/currentPositions/
    @ResponseBody
    public ResponseEntity currentPositions(
            @PathVariable int portfolioId
    ){
        Position p = new Position();
        jdbcTemplate.query("select * from position where porfolio_id="+portfolioId, (resultSet, rowNum) -> {
            int Id = Integer.parseInt(resultSet.getString("Id"));
            int porfolio_id = Integer.parseInt(resultSet.getString("porfolio_id"));
            int instrument_id = Integer.parseInt(resultSet.getString("instrument_id"));
            p.setId(Id);
            p.setPorfolio_id(porfolio_id);
            p.setInstrument_id(instrument_id);
            return null;
        });

        return ResponseEntity.ok(p);
    }
}
