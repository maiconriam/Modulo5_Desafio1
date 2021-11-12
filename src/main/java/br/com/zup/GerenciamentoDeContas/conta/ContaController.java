package br.com.zup.GerenciamentoDeContas.conta;

import br.com.zup.GerenciamentoDeContas.conta.dtos.CadastrarDTO;
import br.com.zup.GerenciamentoDeContas.conta.dtos.SaidaCadastroDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/contas")
public class ContaController {

    @Autowired
    private ContaService contaService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SaidaCadastroDTO cadastrarConta(@RequestBody @Valid CadastrarDTO cadastrarDTO) {
        Conta conta = modelMapper.map(cadastrarDTO, Conta.class);
        return modelMapper.map(contaService.cadastrarConta(conta), SaidaCadastroDTO.class);
    }

}
