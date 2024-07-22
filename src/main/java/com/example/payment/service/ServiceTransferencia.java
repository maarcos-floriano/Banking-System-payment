package com.example.payment.service;

import com.example.payment.controller.dto.TranferenciaDto;
import com.example.payment.entity.Carteira;
import com.example.payment.entity.Transferencia;
import com.example.payment.exception.CarteiraInexistenteException;
import com.example.payment.exception.NaoEstaAutorizadoException;
import com.example.payment.exception.SaldoInsuficienteException;
import com.example.payment.exception.TipoCarteiraException;
import com.example.payment.repository.RepositorioCarteira;
import com.example.payment.repository.RepositorioTransferencia;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class ServiceTransferencia {

    private final RepositorioTransferencia repositorioTransferencia;
    private final ServiceAutorizado serviceAutorizado;
    private final ServiceNotificacao serviceNotificacao;
    private final RepositorioCarteira repositorioCarteira;

    public ServiceTransferencia(RepositorioTransferencia repositorioTransferencia,
                                ServiceAutorizado serviceAutorizado,
                                ServiceNotificacao serviceNotificacao, RepositorioCarteira repositorioCarteira) {
        this.repositorioTransferencia = repositorioTransferencia;
        this.serviceAutorizado = serviceAutorizado;
        this.serviceNotificacao = serviceNotificacao;
        this.repositorioCarteira = repositorioCarteira;
    }

    @Transactional
    public Transferencia transferir(TranferenciaDto dto) {

        var envia = repositorioCarteira.findById(dto.contaOrigem())
                .orElseThrow(() -> new CarteiraInexistenteException());

        var recebe = repositorioCarteira.findById(dto.contaDestino())
                .orElseThrow(() -> new CarteiraInexistenteException());

        validarTransferencia(dto, envia);

        envia.enviarSaldo(dto.valor());
        recebe.adicionarSaldo(dto.valor());

        var transferencia = new Transferencia(envia, recebe, dto.valor());

        repositorioCarteira.save(envia);
        repositorioCarteira.save(recebe);
        var resultadoTransferencia = repositorioTransferencia.save(transferencia);

        CompletableFuture.runAsync(() -> serviceNotificacao.notificar(transferencia));

        return resultadoTransferencia;
    }

    private void validarTransferencia(TranferenciaDto dto, Carteira envia) {

        if(!envia.isCarteiraUsuario()){
            throw new TipoCarteiraException();
        }

        if(!envia.isValorSuficiente(dto.valor())){
            throw new SaldoInsuficienteException();
        }

        if(!serviceAutorizado.isAutorizado(dto)){
            throw new NaoEstaAutorizadoException();
        }

    }
}
