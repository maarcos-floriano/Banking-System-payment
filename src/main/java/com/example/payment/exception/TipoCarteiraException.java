package com.example.payment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class TipoCarteiraException extends PaymentException {

    @Override
    public ProblemDetail toProblemDetail() {

        var problemDetail = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY);

        problemDetail.setTitle("Tipo de carteira inválido");
        problemDetail.setDetail("A carteira informada não é de usuário");

        return problemDetail;

    }
}
