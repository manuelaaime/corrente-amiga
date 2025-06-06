package br.com.correnteamiga.api.doacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class DoacaoService {
    @Autowired
    DoacaoRepository doacaoRepository;

    public void cadastrarDoacao(Doacao doacao){
        doacaoRepository.save(doacao);
    }
    public List<Doacao> listarTodasDoacoes(){
        return (List<Doacao>) doacaoRepository.findAll();
    }

    public Optional<Doacao> buscarDoacaoPorId(Long id){
        return doacaoRepository.findById(id);
    }

    public void deletarDoacaoPorId(Long id){
        doacaoRepository.deleteById(id);
    }

    public void atualizarDoacaoPorId(Long id, Doacao doacao) {
        Optional<Doacao> doacaoDoBancoDeDados = buscarDoacaoPorId(id);

        if(doacaoDoBancoDeDados.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Doação não encontrada no Banco de Dados");
        }

        Doacao doacaoParaEditar = doacaoDoBancoDeDados.get();

        doacaoParaEditar.setValorDoacao(doacao.getValorDoacao());
        doacaoParaEditar.setFormaPagamentoDoacao(doacao.getFormaPagamentoDoacao());

        doacaoRepository.save(doacaoParaEditar);
        }

}
