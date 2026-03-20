package com.hcltech.hackaton.squadten.portfoliomanagement.api.portfolio;

import com.hcltech.hackaton.squadten.portfoliomanagement.api.portfolio.domain.Position;
import com.hcltech.hackaton.squadten.portfoliomanagement.trades.TradeService;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/portfolios")
@CrossOrigin(origins = "${app.cors.allowed-origins:http://localhost:3000}")
@Validated
public class PortfolioController {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private final TradeService tradeService;

    public PortfolioController(TradeService tradeService) {
        this.tradeService = tradeService;
    }

    @PostMapping("/{portfolioId}/addTrade")
    @ResponseBody
    public AddTradeResponse addTrade(@PathVariable @NotBlank String portfolioId) {
        tradeService.addTrade(AddTradeRequest.builder().portfolioId(portfolioId).build());
        return AddTradeResponse.builder()
                .portfolioId(portfolioId)
                .tradeId("123")
                .build();
    }

    @PostMapping("/{portfolioId}/audit")
    @ResponseBody
    public AddTradeResponse getAudit(@PathVariable @NotBlank String portfolioId) {
        return AddTradeResponse.builder()
                .portfolioId(portfolioId)
                .tradeId("123")
                .build();
    }

    @GetMapping("/portfolios/{portfolioId}/currentPositions/")
    @ResponseBody
    public ResponseEntity<Position> currentPositions(
            @PathVariable @Positive int portfolioId
    ){
        Position p = new Position();
        jdbcTemplate.query(
            "select * from position where porfolio_id=?",
            new org.springframework.jdbc.core.PreparedStatementSetter() {
                @Override
                public void setValues(java.sql.PreparedStatement ps) throws java.sql.SQLException {
                    ps.setInt(1, portfolioId);
                }
            },
            (resultSet, rowNum) -> {
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
