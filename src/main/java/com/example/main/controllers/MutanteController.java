package com.example.main.controllers;

import com.example.main.dto.MutanteRequest;
import com.example.main.dto.MutanteResponse;
import com.example.main.services.MutanteService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mutant")
public class MutanteController {

    private final MutanteService mutanteService;

    public MutanteController(MutanteService mutanteService) {
        this.mutanteService = mutanteService;
    }

    @PostMapping
    public ResponseEntity<MutanteResponse> analizarMutante(@Valid @RequestBody MutanteRequest mutanteRequest) {
        boolean isMutant = mutanteService.analizarDna(mutanteRequest.getDna());
        MutanteResponse mutanteResponse = new MutanteResponse(isMutant);
        if (isMutant) {
            return ResponseEntity.ok(mutanteResponse);
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(mutanteResponse);
        }
    }
}
