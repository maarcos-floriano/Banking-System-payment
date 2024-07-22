package com.example.payment.controller;

import com.example.payment.controller.dto.CriarCarteiraDto;
import com.example.payment.entity.Carteira;
import com.example.payment.service.ServiceCarteira;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerCarteira {
    private final ServiceCarteira serviceCarteira;

    public ControllerCarteira(ServiceCarteira serviceCarteira) {
        this.serviceCarteira = serviceCarteira;
    }

    @PostMapping("/carteira")
    public ResponseEntity<Carteira> criarCarteira(@RequestBody @Valid CriarCarteiraDto dto) {

        var carteira = serviceCarteira.criarCarteira(dto);

        return ResponseEntity.ok(carteira);
    }
}
