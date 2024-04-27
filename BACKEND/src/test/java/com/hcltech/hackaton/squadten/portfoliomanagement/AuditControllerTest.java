package com.hcltech.hackaton.squadten.portfoliomanagement;

import com.hcltech.hackaton.squadten.portfoliomanagement.api.portfolio.PortfolioController;
import com.hcltech.hackaton.squadten.portfoliomanagement.api.portfolio.common.TradeType;
import com.hcltech.hackaton.squadten.portfoliomanagement.api.portfolio.domain.dto.AuditRequest;
import com.hcltech.hackaton.squadten.portfoliomanagement.api.portfolio.domain.dto.AuditResponse;
import com.hcltech.hackaton.squadten.portfoliomanagement.api.portfolio.domain.service.AuditService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@WebMvcTest(PortfolioController.class)
public class AuditControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Mock
    private Clock fixedClock;

    @Mock
    private Clock clock;

    @MockBean
    AuditService auditService;

    private final static LocalDateTime LOCAL_DATE = LocalDateTime.of(1989, 1, 13, 12, 12);

    @BeforeEach
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
        fixedClock = Clock.fixed(LOCAL_DATE.atZone(ZoneId.systemDefault()).toInstant(), ZoneId.systemDefault());
    }

    @DisplayName("givenPortfolioId"
            + "_whenCallingToAuditApi"
            + "_thenReturnAuditResponse")
    @Test
    public void givenPortfolioId_whenCallingToAuditApi_thenReturnAuditResponse() throws Exception {
        Mockito.when(auditService.getAudits(any(AuditRequest.class))).thenReturn(List.of(AuditResponse.builder()
                .transactionRef("trans ref")
                .instrumentId("123")
                .instrumentName("instrument name")
                .tradeType(TradeType.Sell)
                .auditDate(LocalDateTime.now())
                .build()));

        mockMvc.perform(MockMvcRequestBuilders.get("/portfolios/{portfolioId}/audit", "portfolioIdTest"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].transactionRef").value("trans ref"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].instrumentId").value("123"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].instrumentName").value("instrument name"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].tradeType").value("Sell"));
    }
}
