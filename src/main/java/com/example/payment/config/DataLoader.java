package com.example.payment.config;

import com.example.payment.entity.TipoCarteira;
import com.example.payment.repository.RepositorioTipoCarteira;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class DataLoader implements CommandLineRunner {

    private final RepositorioTipoCarteira repositorioTipoCarteira;

    public DataLoader(RepositorioTipoCarteira repositorioTipoCarteira) {
        this.repositorioTipoCarteira = repositorioTipoCarteira;
    }

    @Override
    public void run(String... args) throws Exception {
        Arrays.stream(TipoCarteira.Tipo.values())
                .forEach(tipoCarteira -> repositorioTipoCarteira.save(tipoCarteira.get()));
    }
}
