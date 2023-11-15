package com.example.msbanqueconnectors.service;

import com.example.msbanqueconnectors.dtos.CompteRequestDTO;
import com.example.msbanqueconnectors.dtos.CompteResponseDTO;

import java.util.List;

public interface CompteService {
    CompteResponseDTO saveCompte(CompteRequestDTO compteRequestDTO);
    CompteResponseDTO updateCompte(CompteRequestDTO compteRequestDTO);
    void deleteCompte(Long id);
    CompteResponseDTO getCompte(Long id);
    List<CompteResponseDTO> getComptes();
}
