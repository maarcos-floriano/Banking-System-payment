package com.example.payment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class CarteiraInexistenteException extends PaymentException {

    @Override
    public ProblemDetail toProblemDetail() {

        var problemDetail = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY);

        problemDetail.setTitle("Carteira não encontrada");
        problemDetail.setDetail("A carteira informada não existe");

        return problemDetail;

    }
}
