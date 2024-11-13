package com.racoes.demo.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDate;

@Document(collection = "lote")
public class Lote implements Serializable {

    @Id
    private String id;
    private Integer quantidade;
    private LocalDate dataValidade;
    @DBRef
    private Produto produto;

    public Lote() {
        // Construtor vazio, necessário para frameworks de injeção de dependência e para serialização/deserialização
    }

    public Lote(String id, Integer quantidade, LocalDate dataValidade, Produto produto) {
        this.id = id;
        this.quantidade = quantidade;
        this.dataValidade = dataValidade;
        this.produto = produto;
    }

    public Lote(Lote lote, Produto produto) {
        this.id = lote.getId();
        this.quantidade = lote.getQuantidade();
        this.dataValidade = lote.getDataValidade();
        this.produto = produto;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public LocalDate getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(LocalDate dataValidade) {
        this.dataValidade = dataValidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}
