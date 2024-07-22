package com.example.payment.client;

import com.example.payment.client.dto.ResponseNotificacao;
import com.example.payment.entity.Transferencia;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.xml.crypto.dsig.TransformService;

@FeignClient(
        name = "cliente-notificacao",
        url = "${client.servico-notificacao.url}"
)

public interface ClientNotificacao {

    @GetMapping
    ResponseEntity<ResponseNotificacao> notificar(@RequestBody Transferencia transferencia);
}
