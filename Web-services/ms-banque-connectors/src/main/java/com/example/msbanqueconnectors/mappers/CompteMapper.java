package com.example.msbanqueconnectors.mappers;


import com.example.msbanqueconnectors.dtos.CompteRequestDTO;
import com.example.msbanqueconnectors.dtos.CompteResponseDTO;
import com.example.msbanqueconnectors.entities.Compte;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CompteMapper {
    Compte fromompteRequestDTO(CompteRequestDTO compteRequestDTO);
    CompteResponseDTO fromCompte(Compte compte);
}
