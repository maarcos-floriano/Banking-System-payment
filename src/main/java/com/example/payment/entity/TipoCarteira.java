package com.example.payment.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tipo_carteira")
public class TipoCarteira {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String descricao;

  public TipoCarteira() {
  }

  public TipoCarteira(Long id, String descricao) {
    this.id = id;
    this.descricao = descricao;
  }

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getDescricao() {
    return this.descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public enum Tipo {
    usuario(1L, "Usuario"),
    lojista(2L, "Lojista");

    private Long id;
    private String descricao;

    Tipo(Long id, String descricao) {
      this.id = id;
      this.descricao = descricao;
    }

    public TipoCarteira getTipoCarteira() {
      return new TipoCarteira(this.id, this.descricao);
    }

    public Long getId() {
      return this.id;
    }

    public String getDescricao() {
      return this.descricao;
    }

    public TipoCarteira get() {
      return new TipoCarteira(this.id, this.descricao);
    }

  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    TipoCarteira that = (TipoCarteira) o;
    return Objects.equals(id, that.id) && Objects.equals(descricao, that.descricao);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, descricao);
  }
}
