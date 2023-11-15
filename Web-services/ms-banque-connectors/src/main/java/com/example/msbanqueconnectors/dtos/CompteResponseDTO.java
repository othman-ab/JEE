package com.example.msbanqueconnectors.dtos;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor @NoArgsConstructor @Builder
public class CompteResponseDTO {
    private Date createdAt;
    private Double balance;
    private String currency;
}
