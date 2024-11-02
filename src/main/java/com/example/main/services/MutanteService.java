package com.example.main.services;

import com.example.main.entities.Mutante;
import com.example.main.repositories.MutanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MutanteService {

    private static final int SEQUENCE_LENGTH = 4;
    private final MutanteRepository mutanteRepository;

    @Autowired
    public MutanteService(MutanteRepository mutanteRepository) {
        this.mutanteRepository = mutanteRepository;
    }

    // Analiza el ADN y determina si es mutante o no
    public boolean analizarDna(String[] dna) {
        String dnaSequence = String.join(",", dna);

        // Verificamos si el ADN ya existe en la base de datos
        Optional<Mutante> existingDna = mutanteRepository.findByDna(dnaSequence);
        if (existingDna.isPresent()) {
            return existingDna.get().isMutant();
        }

        // Determinamos si el ADN es mutante y lo guardamos en la base de datos
        boolean isMutant = esMutante(dna);

        Mutante mutanteEntity = Mutante.builder()
                .dna(dnaSequence)
                .isMutant(isMutant)
                .build();
        mutanteRepository.save(mutanteEntity);

        return isMutant;
    }

    public static boolean esMutante(String[] dna) {
        int n = dna.length;
        int sequencesFound = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ((checkDirection(dna, i, j, 0, 1) || // Horizontal
                        checkDirection(dna, i, j, 1, 0) || // Vertical
                        checkDirection(dna, i, j, 1, 1) || // Diagonal Principal
                        checkDirection(dna, i, j, 1, -1)) // Diagonal Secundaria
                        && ++sequencesFound > 1) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean checkDirection(String[] dna, int x, int y, int dx, int dy) {
        char firstChar = dna[x].charAt(y);
        int n = dna.length;

        for (int k = 1; k < SEQUENCE_LENGTH; k++) {
            int nx = x + k * dx;
            int ny = y + k * dy;

            // Si se sale de los límites o no coincide la secuencia, termina
            if (nx < 0 || ny < 0 || nx >= n || ny >= n || dna[nx].charAt(ny) != firstChar) {
                return false;
            }
        }
        return true;
    }
}
