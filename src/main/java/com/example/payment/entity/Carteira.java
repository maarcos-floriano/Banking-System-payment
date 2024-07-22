package com.example.payment.entity;

import java.math.BigDecimal;

import org.hibernate.annotations.Collate;

import jakarta.persistence.*;

@Entity
@Table(name = "carteira")
public class Carteira {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "nome")
  private String nome;

  @Column(name = "sobrenome")
  private String sobrenome;

  @Column(name = "email", unique = true)
  private String email;

  @Column(name = "cpf_cnpj", unique = true)
  private String cpfCnpj;

  @Column(name = "senha")
  private String senha;

  @Column(name = "saldo")
  private BigDecimal saldo = BigDecimal.ZERO;

  @ManyToOne
  @JoinColumn(name = "tipo_carteira_id")
  private TipoCarteira tipoCarteira;

  public Carteira() {
  }

  public Carteira(String nome, String sobrenome, String email, String cpfCnpj, String senha, TipoCarteira tipoCarteira) {
    this.nome = nome;
    this.sobrenome = sobrenome;
    this.email = email;
    this.cpfCnpj = cpfCnpj;
    this.senha = senha;
    this.tipoCarteira = tipoCarteira;
  }

  public boolean isCarteiraUsuario() {
    return this.tipoCarteira.equals(TipoCarteira.Tipo.usuario.get());
  }

  public boolean isValorSuficiente(BigDecimal valor) {
    return this.saldo.doubleValue() >= valor.doubleValue();
  }

  public void enviarSaldo(BigDecimal valor) {
    this.saldo = this.saldo.subtract(valor);
  }

  public void adicionarSaldo(BigDecimal valor) {
    this.saldo = this.saldo.add(valor);
  }

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNome() {
    return this.nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getSobrenome() {
    return this.sobrenome;
  }

  public void setSobrenome(String sobrenome) {
    this.sobrenome = sobrenome;
  }

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getCpfCnpj() {
    return this.cpfCnpj;
  }

  public void setCpfCnpj(String cpfCnpj) {
    this.cpfCnpj = cpfCnpj;
  }

  public String getSenha() {
    return this.senha;
  }

  public void setSenha(String senha) {
    this.senha = senha;
  }

  public BigDecimal getSaldo() {
    return this.saldo;
  }

  public void setSaldo(BigDecimal saldo) {
    this.saldo = saldo;
  }

  public TipoCarteira getTipoCarteira() {
    return this.tipoCarteira;
  }

  public void setTipoCarteira(TipoCarteira tipoCarteira) {
    this.tipoCarteira = tipoCarteira;
  }
}
