package com.example.payment.client;

import com.example.payment.client.dto.ResponseAutorizado;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(
        name = "cliente-autorizado",
        url = "${client.servico-autorizacao.url}"
)

public interface ClientAutorizado {
    @GetMapping
    ResponseEntity<ResponseAutorizado> isAutorizado();
}
