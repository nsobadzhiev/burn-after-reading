package com.kumulintelligence.burnafterreading.model;


import jakarta.persistence.*;

@Entity(name = "secret")
public class SecretEntity {

    @Column @Id @GeneratedValue(strategy = GenerationType.UUID) String secretId = null;
    @Column(nullable = false) String name;
    @Column(nullable = false) String secret;

    public SecretEntity(String name, String secret) {
        this.name = name;
        this.secret = secret;
    }
}
