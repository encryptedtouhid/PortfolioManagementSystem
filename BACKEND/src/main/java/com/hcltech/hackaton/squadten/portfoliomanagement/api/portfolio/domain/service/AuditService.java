package com.hcltech.hackaton.squadten.portfoliomanagement.api.portfolio.domain.service;

import com.hcltech.hackaton.squadten.portfoliomanagement.api.portfolio.domain.dto.AuditRequest;
import com.hcltech.hackaton.squadten.portfoliomanagement.api.portfolio.domain.dto.AuditResponse;
import com.hcltech.hackaton.squadten.portfoliomanagement.api.portfolio.domain.entity.Audit;

import java.util.List;

public interface AuditService {
    List<AuditResponse> getAudits(AuditRequest auditRequest);

    void saveAudit(Audit audit);
}
