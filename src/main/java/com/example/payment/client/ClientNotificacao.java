package com.example.payment.client;

import com.example.payment.client.dto.ResponseNotificacao;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(
        name = "cliente-notificacao",
        url = "${client.servico-notificacao.url}"
)

public interface ClientNotificacao {

    @GetMapping
    ResponseEntity<ResponseNotificacao> isNotificar();
}
