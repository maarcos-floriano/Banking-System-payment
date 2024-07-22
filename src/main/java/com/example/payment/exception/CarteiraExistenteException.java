package com.example.payment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class CarteiraExistenteException extends PaymentException{

    private String detail;

    public CarteiraExistenteException(String detail) {
        this.detail = detail;
    }

    @Override
    public ProblemDetail toProblemDetail() {
        var problemDetail = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY);

        problemDetail.setTitle("Carteira já existente");
        problemDetail.setDetail(detail);

        return problemDetail;
    }
}
