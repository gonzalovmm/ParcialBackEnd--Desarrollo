package com.example.main.dto;


import lombok.AllArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Setter
public class MutanteResponse {
    private boolean isMutant;

    public boolean isMutant() {
        return isMutant;
    }
}
