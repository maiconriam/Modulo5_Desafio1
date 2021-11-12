package br.com.zup.GerenciamentoDeContas.conta;

import br.com.zup.GerenciamentoDeContas.conta.enuns.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ContaService {

    @Autowired
    private ContaRepository contaRepository;

    public Conta cadastrarConta(Conta conta) {
        LocalDate dataAtual = LocalDate.now();
        if (conta.getDataDeVencimento().isBefore(dataAtual)) {
            conta.setStatus(Status.VENCIDA);
        } else {
            conta.setStatus(Status.AGUARDANDO);
        }
        return contaRepository.save(conta);
    }

    public List<Conta> exibitListaDeContas(){
        Iterable<Conta> contas = contaRepository.findAll();
        return (List<Conta>) contas;
    }

}

