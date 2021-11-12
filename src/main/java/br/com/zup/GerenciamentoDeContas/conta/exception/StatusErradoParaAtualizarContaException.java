package br.com.zup.GerenciamentoDeContas.conta.exception;

public class StatusErradoParaAtualizarContaException extends RuntimeException{
    public StatusErradoParaAtualizarContaException(String message) {
        super(message);
    }
}