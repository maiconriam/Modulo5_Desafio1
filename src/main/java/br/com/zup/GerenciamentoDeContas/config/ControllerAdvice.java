package br.com.zup.GerenciamentoDeContas.config;

import org.springframework.http.HttpStatus;
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
}
