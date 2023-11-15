package com.example.msbanqueconnectors.service;

import com.example.msbanqueconnectors.dtos.CompteRequestDTO;
import com.example.msbanqueconnectors.dtos.CompteResponseDTO;
import com.example.msbanqueconnectors.entities.Compte;
import com.example.msbanqueconnectors.mappers.CompteMapper;
import com.example.msbanqueconnectors.repositories.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CompteServiceImpl implements CompteService {

    @Autowired
    private CompteRepository compteRepository;

    @Autowired
    private CompteMapper compteMapper;

    @Override
    public CompteResponseDTO saveCompte(CompteRequestDTO compteRequestDTO) {
        Compte compte = compteMapper.fromompteRequestDTO(compteRequestDTO);
        Compte savedCompte = compteRepository.save(compte);
        return compteMapper.fromCompte(savedCompte);
    }

    @Override
    public CompteResponseDTO updateCompte(CompteRequestDTO compteRequestDTO) {
        Compte compte = compteMapper.fromompteRequestDTO(compteRequestDTO);
        Compte savedCompte = compteRepository.save(compte);
        return compteMapper.fromCompte(savedCompte);
    }

    @Override
    public void deleteCompte(Long id) {
        compteRepository.deleteById(id);
    }

    @Override
    public CompteResponseDTO getCompte(Long id) {
        Compte customer=compteRepository.findById(id).get();
        return compteMapper.fromCompte(customer);
    }

    @Override
    public List<CompteResponseDTO> getComptes() {
        List<Compte> customers=compteRepository.findAll();
        return customers
                .stream()
                .map((compte)->compteMapper.fromCompte(compte)).collect(Collectors.toList());
    }
}
