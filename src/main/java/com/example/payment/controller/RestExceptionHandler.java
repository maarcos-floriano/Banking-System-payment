package com.example.payment.controller;

import com.example.payment.exception.PaymentException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(PaymentException.class)
    public ProblemDetail handlePaymentException(PaymentException e) {
        return e.toProblemDetail();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ProblemDetail handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {

        var camposErro = e.getFieldErrors()
                .stream()
                .map(c -> new InvalidParam(c.getField(), c.getDefaultMessage()))
                .toList();

        var pb = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);

        pb.setTitle("Erro de validação");
        pb.setProperty("invalidParams", camposErro);

        return pb;
    }

    private record InvalidParam(String campo, String mensagem) {
    }
}
