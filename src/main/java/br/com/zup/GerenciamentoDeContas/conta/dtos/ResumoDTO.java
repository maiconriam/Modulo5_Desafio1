package br.com.zup.GerenciamentoDeContas.conta.dtos;

import br.com.zup.GerenciamentoDeContas.conta.enuns.Status;

public class ResumoDTO {
    private int id;
    private String nome;
    private Double valor;
    private Status status;

    public ResumoDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
