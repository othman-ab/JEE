package com.example.msbanqueconnectors.SOAP;

import com.example.msbanqueconnectors.dtos.CompteRequestDTO;
import com.example.msbanqueconnectors.dtos.CompteResponseDTO;
import com.example.msbanqueconnectors.service.CompteService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@WebService(serviceName = "BanqueWS")
public class BanqueService {
    @Autowired
    private CompteService compteService;

    @WebMethod(operationName = "addCompte")
    public CompteResponseDTO addCompte(@WebParam(name = "compte") CompteRequestDTO compteRequestDTO){
        return compteService.saveCompte(compteRequestDTO);
    }

    @WebMethod
    public CompteResponseDTO getCompte(@WebParam(name = "id") Long id){
        return compteService.getCompte(id);
    }

    @WebMethod
    public List<CompteResponseDTO> comptes(){
        return compteService.getComptes();
    }
}
