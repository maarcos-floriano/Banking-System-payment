package com.example.payment.repository;

import com.example.payment.entity.TipoCarteira;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioTipoCarteira extends JpaRepository<TipoCarteira, Long> {
}
