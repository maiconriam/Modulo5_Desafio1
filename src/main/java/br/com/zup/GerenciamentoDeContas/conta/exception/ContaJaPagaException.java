package br.com.zup.GerenciamentoDeContas.conta.exception;

public class ContaJaPagaException extends RuntimeException{
    public ContaJaPagaException(String message) {
        super(message);
    }
}