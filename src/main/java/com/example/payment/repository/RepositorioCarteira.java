package com.example.payment.repository;

import com.example.payment.entity.Carteira;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RepositorioCarteira extends JpaRepository<Carteira, Long> {

    Optional<Carteira> findByCpfCnpjOrEmail(String cpfCnpj, String email);
}
