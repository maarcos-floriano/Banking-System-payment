package com.example.payment.controller.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record TranferenciaDto(@NotNull @DecimalMin("0.01") BigDecimal valor,
                              @NotNull Long contaOrigem,
                              @NotNull Long contaDestino) {
}
