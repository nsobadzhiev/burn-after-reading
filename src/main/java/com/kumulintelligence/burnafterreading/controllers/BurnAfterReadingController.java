package com.kumulintelligence.burnafterreading.controllers;

import com.kumulintelligence.burnafterreading.model.SecretEntity;
import com.kumulintelligence.burnafterreading.repositories.SecretRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
public class BurnAfterReadingController {

    @Autowired
    private SecretRepository secretRepository;

    @GetMapping("/secrets")
    public SecretEntity getSecrets() {
        throw new ResponseStatusException(HttpStatusCode.valueOf(404));
    }

    @GetMapping("/secrets/{secretId}")
    public SecretEntity getSecret(@PathVariable String secretId) {
        Optional<SecretEntity> secret = secretRepository.findById(secretId);
        if (secret.isPresent()) {
            return secret.get();
        }
        throw new ResponseStatusException(HttpStatusCode.valueOf(404));
    }

    @PostMapping("/secrets")
    public SecretEntity postSecret(
            @RequestParam(name = "name") String name,
            @RequestParam(name = "secret") String secret
            ) {
        Optional<SecretEntity> existingSecret = this.secretRepository.findByName(name);
        if (existingSecret.isPresent()) {
            // questionable - we should allow secrets with the same name to exist
            throw new ResponseStatusException(HttpStatusCode.valueOf(400));
        } else {
            SecretEntity newSecret = new SecretEntity(name, secret);
            return secretRepository.save(newSecret);
        }
    }
}
