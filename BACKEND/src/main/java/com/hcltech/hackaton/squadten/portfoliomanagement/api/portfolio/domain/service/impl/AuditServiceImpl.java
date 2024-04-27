package com.hcltech.hackaton.squadten.portfoliomanagement.api.portfolio.domain.service.impl;

import com.hcltech.hackaton.squadten.portfoliomanagement.api.portfolio.domain.dto.AuditRequest;
import com.hcltech.hackaton.squadten.portfoliomanagement.api.portfolio.domain.dto.AuditResponse;
import com.hcltech.hackaton.squadten.portfoliomanagement.api.portfolio.domain.dto.AuditResult;
import com.hcltech.hackaton.squadten.portfoliomanagement.api.portfolio.domain.entity.Audit;
import com.hcltech.hackaton.squadten.portfoliomanagement.api.portfolio.domain.repository.AuditRepository;
import com.hcltech.hackaton.squadten.portfoliomanagement.api.portfolio.domain.service.AuditService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class AuditServiceImpl implements AuditService {

    private final AuditRepository auditRepository;

    @Override
    public List<AuditResponse> getAudits(AuditRequest auditRequest) {
        log.atInfo().log("Get audits by portfolioId: " + auditRequest.portfolioId());
        Pageable pageable = PageRequest.of(auditRequest.pageNumber(), auditRequest.pageSize());

        log.atInfo().log("Retrieve data from db by portfolioId: " + auditRequest.portfolioId());
        List<AuditResult> auditResults = auditRepository.findAllByPortfolioId(auditRequest.portfolioId(), pageable);
        return auditResults.stream().map(auditResult -> AuditResponse
                .builder()
                .transactionRef(auditResult.getTransactionRef())
                .instrumentId(auditResult.getInstrumentId())
                .instrumentName(auditResult.getInstrumentName())
                .tradeType(auditResult.getTradeType())
                .auditDate(auditResult.getAuditDate())
                .build()).collect(Collectors.toList());
    }

    @Override
    public void saveAudit(Audit audit) {
        log.atInfo().log("Get audits with id: " + audit.getId());
    }
}
