package com.example.payment.controller;

import com.example.payment.controller.dto.TranferenciaDto;
import com.example.payment.entity.Transferencia;
import com.example.payment.service.ServiceTransferencia;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerTransferencia {

    private final ServiceTransferencia serviceTransferencia;

    public ControllerTransferencia(ServiceTransferencia serviceTransferencia) {
        this.serviceTransferencia = serviceTransferencia;
    }

    @PostMapping("/transferir")
    public ResponseEntity<Transferencia> transferir(@RequestBody TranferenciaDto dto) {

        var resp = serviceTransferencia.transferir(dto);

        return ResponseEntity.ok(resp);

    }
}
