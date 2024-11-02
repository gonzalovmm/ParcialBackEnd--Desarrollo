package com.example.main.dto;


import lombok.Getter;
import lombok.Setter;
import com.example.main.validators.ValidMutante;

@Getter
@Setter
public class MutanteRequest {
    @ValidMutante
    private String[] dna;
}
