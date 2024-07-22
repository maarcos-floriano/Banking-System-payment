package com.example.payment.entity;

import jakarta.persistence.*;
import com.example.payment.entity.Carteira;

import java.math.BigDecimal;

@Entity
@Table(name = "transferencia")
public class Transferencia {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne
    @JoinColumn(name = "carteira_remetente_id")
    private Carteira remetente;

    @ManyToOne
    @JoinColumn(name = "carteira_destinatario_id")
    private Carteira destinatario;

    @Column(name = "valor")
    private BigDecimal valor;

    public Transferencia() {
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Carteira getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(Carteira destinatario) {
        this.destinatario = destinatario;
    }

    public Carteira getRemetente() {
        return remetente;
    }

    public void setRemetente(Carteira remetente) {
        this.remetente = remetente;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
