package br.com.zup.GerenciamentoDeContas.conta.dtos;

import br.com.zup.GerenciamentoDeContas.conta.enuns.Status;
import br.com.zup.GerenciamentoDeContas.conta.enuns.Tipo;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class SaidaCadastroDTO {

    private int id;
    private String nome;
    private Double valor;
    private Tipo tipo;
    private Status status;
    private LocalDate dataDeVencimento;
    private LocalDateTime dataDePagamento;

    public SaidaCadastroDTO() {
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

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDate getDataDeVencimento() {
        return dataDeVencimento;
    }

    public void setDataDeVencimento(LocalDate dataDeVencimento) {
        this.dataDeVencimento = dataDeVencimento;
    }

    public LocalDateTime getDataDePagamento() {
        return dataDePagamento;
    }

    public void setDataDePagamento(LocalDateTime dataDePagamento) {
        this.dataDePagamento = dataDePagamento;
    }

}
