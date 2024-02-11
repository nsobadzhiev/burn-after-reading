package com.kumulintelligence.burnafterreading.repositories;

import com.kumulintelligence.burnafterreading.model.SecretEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SecretRepository extends JpaRepository<SecretEntity, String> {

    Optional<SecretEntity> findByName(String name);
}
