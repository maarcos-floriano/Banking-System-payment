package com.example.payment.repository;

import com.example.payment.entity.Transferencia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RepositorioTransferencia extends JpaRepository<Transferencia, UUID> {
}
