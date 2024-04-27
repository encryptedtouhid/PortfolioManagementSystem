package com.hcltech.hackaton.squadten.portfoliomanagement.api.portfolio;

import com.hcltech.hackaton.squadten.portfoliomanagement.api.portfolio.common.TradeType;
import com.hcltech.hackaton.squadten.portfoliomanagement.api.portfolio.domain.dto.AuditRequest;
import com.hcltech.hackaton.squadten.portfoliomanagement.api.portfolio.domain.dto.AuditResponse;
import com.hcltech.hackaton.squadten.portfoliomanagement.api.portfolio.domain.service.AuditService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import com.hcltech.hackaton.squadten.portfoliomanagement.api.portfolio.domain.Position;
import com.hcltech.hackaton.squadten.portfoliomanagement.trades.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.time.Clock;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/portfolios")
@RequiredArgsConstructor
@Slf4j
public class PortfolioController {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private final TradeService tradeService;
    private final AuditService auditService;

    @PostMapping("/{portfolioId}/addTrade")
    @ResponseBody
    public AddTradeResponse addTrade(@PathVariable String portfolioId, @RequestBody AddTradeRequest addTradeRequest) {

        tradeService.addTrade(addTradeRequest);

        return AddTradeResponse.builder()
                .portfolioId(portfolioId)
                .tradeInstrumentId(addTradeRequest.getInstrumentId())
                .build();
    }

    @GetMapping("/{portfolioId}/audit")
    @ResponseBody
    public List<AuditResponse> getAudit(@PathVariable String portfolioId,
                                        @RequestParam Integer pageNumber,
                                        @RequestParam Integer pageSize) {
        log.atInfo().log("Controller get audits by portfolioId: " + portfolioId);
        AuditRequest auditRequest = new  AuditRequest(portfolioId, pageNumber, pageSize);
        return auditService.getAudits(auditRequest);
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
