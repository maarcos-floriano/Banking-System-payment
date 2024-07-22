package com.example.payment.service;

import com.example.payment.controller.dto.TranferenciaDto;
import com.example.payment.entity.Transferencia;
import com.example.payment.exception.PaymentException;
import org.springframework.stereotype.Service;
import com.example.payment.client.ClientAutorizado;

@Service
public class ServiceAutorizado {

    private final ClientAutorizado clientAutorizado;

    public ServiceAutorizado(ClientAutorizado clientAutorizado) {
        this.clientAutorizado = clientAutorizado;
    }

    public boolean isAutorizado(TranferenciaDto dto) {
        var resp = clientAutorizado.isAutorizado();

        if (resp.getStatusCode().isError()){
            throw new PaymentException();
        }

        return resp.getBody().autorizado();
    }
}
