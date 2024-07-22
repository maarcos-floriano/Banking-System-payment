package com.example.payment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class SaldoInsuficienteException extends PaymentException {

    @Override
    public ProblemDetail toProblemDetail() {

        var problemDetail = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY);

        problemDetail.setTitle("Saldo insuficiente");
        problemDetail.setDetail("O saldo da carteira é insuficiente");

        return problemDetail;

    }
}
