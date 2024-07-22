package com.example.payment.exception;

import org.springframework.http.ProblemDetail;

public class NaoEstaAutorizadoException extends PaymentException {

    @Override
    public ProblemDetail toProblemDetail() {

            var problemDetail = ProblemDetail.forStatus(403);

            problemDetail.setTitle("Não está autorizado");
            problemDetail.setDetail("O usuário não está autorizado");

            return problemDetail;
    }
}
