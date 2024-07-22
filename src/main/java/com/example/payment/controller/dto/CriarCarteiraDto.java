package com.example.payment.controller.dto;

import com.example.payment.entity.Carteira;
import com.example.payment.entity.TipoCarteira;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CriarCarteiraDto(@NotBlank String nome,
                               @NotBlank String sobrenome,
                               @NotBlank String email,
                               @NotBlank String cpfCnpj,
                               @NotBlank String senha,
                               @NotNull TipoCarteira.Tipo tipoCarteira) {

    public Carteira toCarteira() {
        return new Carteira(nome, sobrenome, email, cpfCnpj, senha, tipoCarteira.get());
    }
}
