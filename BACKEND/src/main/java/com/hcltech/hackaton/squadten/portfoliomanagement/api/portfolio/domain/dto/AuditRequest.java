package com.hcltech.hackaton.squadten.portfoliomanagement.api.portfolio.domain.dto;

public record AuditRequest(
        String portfolioId,
        Integer pageNumber,
        Integer pageSize
) {
}
