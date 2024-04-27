package com.hcltech.hackaton.squadten.portfoliomanagement;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AuditControllerTest {

    @Autowired
    WebTestClient webTestClient;

    @DisplayName("givenPortfolioId"
            + "_whenCallingToAuditApi"
            + "_thenReturnAuditResponse")
    @Test
    public void givenPortfolioId_whenCallingToAuditApi_thenReturnAuditResponse() {
        Assertions.fail();
    }
}
