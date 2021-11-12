package br.com.zup.GerenciamentoDeContas.conta;

import br.com.zup.GerenciamentoDeContas.conta.enuns.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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

    public Conta procurarId(int id) {
        Optional<Conta> conta = contaRepository.findById(id);
        if (conta.isEmpty()) {
            throw new RuntimeException("Conta Não encontrado");
        }
        return conta.get();
    }

    public Conta atualizarPagamentoDeConta(int id) {
        Conta conta = procurarId(id);
        if (conta.getStatus() != Status.PAGO) {
            conta.setStatus(Status.PAGO);
            conta.setDataDePagamento(LocalDateTime.now());
            contaRepository.save(conta);
        } else {
            throw new RuntimeException("Conta ja paga");
        }

        return conta;
    }

}

