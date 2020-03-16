package ru.iopent.parking.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class ApiTestBase {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper om;

    @Autowired
    private Flyway flyway;

    @BeforeEach
    private void beforeEach() {
        cleanTables();
    }

    private void cleanTables() {
        flyway.clean();
        flyway.migrate();
    }

    MockMvc getMvc() {
        return mvc;
    }

    ObjectMapper getObjectMapper() {
        return om;
    }
}

