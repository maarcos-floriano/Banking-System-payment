package com.example.payment.service;

import com.example.payment.client.ClientNotificacao;
import com.example.payment.exception.PaymentException;

public class ServiceNotificacao {

    private final ClientNotificacao clientNotificacao;

    public ServiceNotificacao(ClientNotificacao clientNotificacao) {
        this.clientNotificacao = clientNotificacao;
    }

    public boolean isNotificar() {
        var resp = clientNotificacao.isNotificar();

        if (resp.getStatusCode().isError()){
            throw new PaymentException();
        }

        return resp.getBody().notificar();
    }
}
