package io.github.parkwoong.gateway;

import io.github.parkwoong.gateway.backend.Backend;
import io.github.parkwoong.gateway.backend.BackendRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BackendController {
    private final BackendRepository repository;

    public BackendController(BackendRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/api/backends")
    public Backend save(@RequestBody Backend backend) {
        return repository.save(backend);
    }

    @GetMapping("/api/backends/{pattern}")
    public ResponseEntity<Backend> get(@PathVariable String pattern) {
        return repository
                .findById(pattern)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
