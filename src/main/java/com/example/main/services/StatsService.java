package com.example.main.services;


import com.example.main.dto.StatsResponse;
import com.example.main.repositories.MutanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatsService {

    private final MutanteRepository repository;

    @Autowired
    public StatsService(MutanteRepository repository) {
        this.repository = repository;
    }

    public StatsResponse getStats() {

        long CantidadMutantes = repository.countByIsMutant(true); // desde el repository contamos los mutantes
        long CantidadHumanos = repository.countByIsMutant(false); // desde el repository contamos los humanos
        double ratio = CantidadHumanos == 0 ? 0 : (double) CantidadMutantes / CantidadHumanos; //Obtenemos el ratio
        return new StatsResponse(CantidadMutantes, CantidadHumanos, ratio); // retornamos un response
    }
}

