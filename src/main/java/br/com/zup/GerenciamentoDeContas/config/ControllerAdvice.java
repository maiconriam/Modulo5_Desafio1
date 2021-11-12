package br.com.zup.GerenciamentoDeContas.config;

import br.com.zup.GerenciamentoDeContas.conta.exception.ContaJaPagaException;
import br.com.zup.GerenciamentoDeContas.conta.exception.ContaNaoEncontradaException;
import br.com.zup.GerenciamentoDeContas.conta.exception.StatusErradoParaAtualizarContaException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public List<MensagemDeErro> manipularErrosDeValidacao(MethodArgumentNotValidException exception){
        List<MensagemDeErro> erros = new ArrayList<>();

        for (FieldError fieldError : exception.getFieldErrors()){
            MensagemDeErro erroDeValidacao = new MensagemDeErro(fieldError.getDefaultMessage());
            erros.add(erroDeValidacao);
        }
        return erros;
    }

    @ExceptionHandler(ContaNaoEncontradaException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public MensagemDeErro manipularExececaoParaContaNaoEncontrada(ContaNaoEncontradaException exception){
        return new MensagemDeErro(exception.getMessage());
    }

    @ExceptionHandler(StatusErradoParaAtualizarContaException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public MensagemDeErro manipularExececaoParaStatusErrado(StatusErradoParaAtualizarContaException exception){
        return new MensagemDeErro(exception.getMessage());
    }

    @ExceptionHandler(ContaJaPagaException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public MensagemDeErro manipularExececaoParaContaJaPaga(ContaJaPagaException exception){
        return new MensagemDeErro(exception.getMessage());
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public MensagemDeErro manipularExececaoEnumErrado (HttpMessageNotReadableException exception){
        return new MensagemDeErro("Erro de Sintaxe");
    }
}
