package com.example.payment.service;

import com.example.payment.client.ClientNotificacao;
import com.example.payment.entity.Transferencia;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class ServiceNotificacao {

    private static final Logger logger = LoggerFactory.getLogger(ServiceNotificacao.class);

    private final ClientNotificacao clientNotificacao;

    public ServiceNotificacao(ClientNotificacao clientNotificacao) {
        this.clientNotificacao = clientNotificacao;
    }

    public void notificar(Transferencia transferencia) {
        try {
            logger.info("Notificando transferência");
            var resp = clientNotificacao.notificar(transferencia);

            if (resp.getStatusCode().isError()){
                logger.error("Erro ao notificar transferência");
            }
        } catch (Exception e) {
            logger.error("Erro ao notificar transferência", e);
        }
    }
}
