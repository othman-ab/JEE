package com.example.msbanqueconnectors.web;

import com.example.msbanqueconnectors.dtos.CompteRequestDTO;
import com.example.msbanqueconnectors.dtos.CompteResponseDTO;
import com.example.msbanqueconnectors.service.CompteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class CompteRestClient {
    @Autowired
    private CompteService compteService;

    @GetMapping(path = "/comptes/{id}")
    public CompteResponseDTO getCompte(@PathVariable Long id){
        return compteService.getCompte(id);
    }


    @GetMapping(path = "/comptes")
    public List<CompteResponseDTO> getComptes(){
        return compteService.getComptes();
    }

    @PostMapping(path = "/comptes")
    public CompteResponseDTO save(@RequestBody CompteRequestDTO compteRequestDTO){
        return compteService.saveCompte(compteRequestDTO);
    }

    @PutMapping(path = "/comptes/{id}")
    public CompteResponseDTO update(@RequestBody CompteRequestDTO compteRequestDTO, @PathVariable Long id){
        compteRequestDTO.setId(id);
        return compteService.saveCompte(compteRequestDTO);
    }


    @DeleteMapping(path = "/comptes/{id}")
    public void delete(@PathVariable Long id){
        compteService.deleteCompte(id);
    }

}
