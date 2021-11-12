package br.com.zup.GerenciamentoDeContas.conta.dtos;

import br.com.zup.GerenciamentoDeContas.conta.enuns.Tipo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class CadastrarDTO {

    @Size(min = 2, max = 50,message = "Por favor, digite um nome entre 2 a 50 caracteres")
    @NotBlank(message = "Campo Obrigatorio")
    private String nome;
    @Positive(message = "Numero invalido")
    @NotNull(message = "campo obrigatorio")
    private Double valor;
    @NotNull(message = "Campo Obrigatorio")
    private Tipo tipo;
    @NotNull(message = "Campo Obrigatorio")
    private LocalDate dataDeVencimento;

    public CadastrarDTO() {
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

    public LocalDate getDataDeVencimento() {
        return dataDeVencimento;
    }

    public void setDataDeVencimento(LocalDate dataDeVencimento) {
        this.dataDeVencimento = dataDeVencimento;
    }
}