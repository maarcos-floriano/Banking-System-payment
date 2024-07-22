package com.example.payment.service;

import com.example.payment.controller.dto.CriarCarteiraDto;
import com.example.payment.entity.Carteira;
import com.example.payment.exception.CarteiraExistenteException;
import com.example.payment.repository.RepositorioCarteira;
import org.springframework.stereotype.Service;

@Service
public class ServiceCarteira {

    private final RepositorioCarteira repositorioCarteira;

    public ServiceCarteira(RepositorioCarteira repositorioCarteira) {
        this.repositorioCarteira = repositorioCarteira;
    }

    public Carteira criarCarteira(CriarCarteiraDto dto) {

        var carteiraDb = repositorioCarteira.findByCpfCnpjOrEmail(dto.cpfCnpj(), dto.email());

        if (carteiraDb.isPresent()) {
            throw new CarteiraExistenteException("Carteira já existente");
        }

        Carteira carteira = dto.toCarteira();
        return repositorioCarteira.save(carteira);
    }
}
