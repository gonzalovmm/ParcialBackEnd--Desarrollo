package com.example.main.repositories;


import com.example.main.entities.Mutante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;


@Repository
public interface MutanteRepository extends JpaRepository<Mutante, Long> {
    Optional<Mutante> findByDna(String dnaSequence);  // Metodo de busqueda

    long countByIsMutant(boolean isMutant);  // Metodo de conteo
}