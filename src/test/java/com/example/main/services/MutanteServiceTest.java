package com.example.main.services;

import com.example.main.entities.Mutante;
import com.example.main.repositories.MutanteRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MutanteServiceTest {


    @Test
    public void testFilas() {
        String[] dna = {
                "ATGCGA",
                "CAGTGC",
                "TTATGT",
                "AGAAGG",
                "CCCCTA",
                "TCACTG"
        };
        assertTrue(MutanteService.esMutante(dna));
    }

    @Test
    public void testColumnas() {
        String[] dna = {
                "ATGCGA",
                "AAGTGC",
                "ATTAGT",
                "AGAAGG",
                "TCCCTA",
                "TCACTG"
        };
        assertTrue(MutanteService.esMutante(dna));
    }

    @Test
    public void testDiagonales() {
        String[] dna = {
                "ATGCGA",
                "CAGTAC",
                "TTGTGT",
                "AGATAG",
                "CCCTTA",
                "TCACTG"
        };
        assertTrue(MutanteService.esMutante(dna));
    }

    @Test
    public void testNoMutante() {
        String[] dna = {
                "ATGCGA",
                "CAGTGC",
                "TTATGT",
                "AGACGG",
                "GCGTCA",
                "TCACTG"
        };
        assertFalse(MutanteService.esMutante(dna));
    }

    @Test
    public void testAnalizarDnaMutante() {
        String[] dna = {
                "ATGCGA",
                "CAGTGC",
                "TTATGT",
                "AGAAGG",
                "CCCCTA",
                "TCACTG"
        };
        assertTrue(MutanteService.esMutante(dna));
    }

    @Test
    public void testAnalizarDnaNoMutante() {
        String[] dna = {
                "ATGCGA",
                "CAGTGC",
                "TTATGT",
                "AGACGG",
                "GCGTCA",
                "TCACTG"
        };
        assertFalse(MutanteService.esMutante(dna));
    }
}
