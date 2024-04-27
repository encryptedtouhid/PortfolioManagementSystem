package com.hcltech.hackaton.squadten.portfoliomanagement.api.portfolio;

import com.hcltech.hackaton.squadten.portfoliomanagement.api.portfolio.common.TradeType;
import com.hcltech.hackaton.squadten.portfoliomanagement.api.portfolio.domain.dto.AuditRequest;
import com.hcltech.hackaton.squadten.portfoliomanagement.api.portfolio.domain.dto.AuditResponse;
import com.hcltech.hackaton.squadten.portfoliomanagement.api.portfolio.domain.service.AuditService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import java.time.Clock;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/portfolios")
@RequiredArgsConstructor
@Slf4j
public class PortfolioController {

    private final AuditService auditService;

    @PostMapping("/{portfolioId}/addTrade")
    @ResponseBody
    public AddTradeResponse addTrade(@PathVariable String portfolioId) {
        return AddTradeResponse.builder()
                .portfolioId(portfolioId)
                .tradeId("123")
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
}
