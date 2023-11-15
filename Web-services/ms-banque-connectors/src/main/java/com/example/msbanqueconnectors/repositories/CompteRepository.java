package com.example.msbanqueconnectors.repositories;
import com.example.msbanqueconnectors.entities.Compte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompteRepository extends JpaRepository<Compte,Long> {
}
