package com.hcltech.hackaton.squadten.portfoliomanagement.api.portfolio.domain.repository;

import com.hcltech.hackaton.squadten.portfoliomanagement.api.portfolio.domain.dto.AuditResult;
import com.hcltech.hackaton.squadten.portfoliomanagement.api.portfolio.domain.entity.Audit;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuditRepository extends JpaRepository<Audit , String> {

    @Query(value = auditQuery, countQuery = countAuditQuery, nativeQuery = true)
    List<AuditResult> findAllByPortfolioId(String portfolioId, Pageable pageable);

    String auditQuery = "select a.*, i.instrument_name from audit a, instrument i where a.portfolio_id = ?1 and a.instrument_id = i.id";
    String countAuditQuery = "select count(*) from audit a where a.portfolio_id = ?1";
}
