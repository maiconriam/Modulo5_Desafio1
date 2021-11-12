package br.com.zup.GerenciamentoDeContas.conta.dtos;

import br.com.zup.GerenciamentoDeContas.conta.enuns.Status;

public class AtualizarContaDTO {
    private Status status;

    public AtualizarContaDTO() {
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
