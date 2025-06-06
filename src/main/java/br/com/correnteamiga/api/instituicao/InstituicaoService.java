package br.com.correnteamiga.api.instituicao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class InstituicaoService {
    @Autowired
    InstituicaoRepository instituicaoRepository;

    public void cadastrarInstituicao(Instituicao instituicao) {
        instituicaoRepository.save(instituicao);
    }

    public List<Instituicao> listarTodasInstituicoes(){
        return instituicaoRepository.findAll();
    }

    public Optional<Instituicao> buscarInstituicaoPorId(Long id){
        return instituicaoRepository.findById(id);
    }

    public void deletarInstituicaoPorId(Long id){
        instituicaoRepository.deleteById(id);
    }

    public void atualizarInstituicaoPorId(Long id, Instituicao instituicao) {
        Optional<Instituicao> instituicaoDoBancoDeDados = buscarInstituicaoPorId(id);

        if (instituicaoDoBancoDeDados.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Instituicao não encontrado no Banco de Dados");
        }

        Instituicao instituicaoParaEditar = instituicaoDoBancoDeDados.get();
        instituicaoParaEditar.setNomeInstituicao(instituicao.getNomeInstituicao());
        instituicaoParaEditar.setCnpjInstituicao(instituicao.getCnpjInstituicao());
        instituicaoParaEditar.setAreaInstituicao(instituicao.getAreaInstituicao());
        instituicaoParaEditar.setTelefoneInstituicao(instituicao.getTelefoneInstituicao());
        instituicaoParaEditar.setEmailInstituicao(instituicao.getEmailInstituicao());
        instituicaoParaEditar.setEnderecoInstituicao(instituicao.getEnderecoInstituicao());


        instituicaoRepository.save(instituicaoParaEditar);
    }
}
