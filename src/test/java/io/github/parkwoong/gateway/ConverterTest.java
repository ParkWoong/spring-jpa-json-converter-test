package io.github.parkwoong.gateway;

import static org.junit.jupiter.api.Assertions.*;

import io.github.parkwoong.gateway.backend.Backend;
import io.github.parkwoong.gateway.backend.BackendRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;

@SpringBootTest
class ConverterTest {
    @Autowired BackendRepository repository;

    @Test
    void savesAndReadsJsonMap() {
        Backend row = Backend.with("http://localhost:9090");
        row.setPattern("/sample");
        row.setDefaultHeaders(Collections.<String, Object>singletonMap("X-Sample", "value"));
        repository.saveAndFlush(row);
        repository
                .findById("/sample")
                .ifPresent(
                        found -> assertEquals("value", found.getDefaultHeaders().get("X-Sample")));
    }
}
