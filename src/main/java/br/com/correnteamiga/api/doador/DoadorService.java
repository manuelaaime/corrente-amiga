package br.com.correnteamiga.api.doador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class DoadorService {
    @Autowired
    DoadorRepository doadorRepository;

    public void criarDoador(Doador doador){
        doadorRepository.save(doador);
    }

    public List<Doador> listarTodosDoadores(){
        return doadorRepository.findAll();
    }

    public Optional<Doador> buscarDoadorPorId(Long id) {
        return doadorRepository.findById(id);
    }
    public void deletarDoadorPorId(Long id){
        doadorRepository.deleteById(id);
    }

    public void atualizarDoadorPorId(Long id, Doador doador){
        Optional<Doador> doadorDoBancoDeDados = buscarDoadorPorId(id);

        if(doadorDoBancoDeDados.isEmpty()) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                "Doador não encontrada no Banco de Dados");
        }

        Doador doadorParaEditar = doadorDoBancoDeDados.get();

        doadorParaEditar.setNomeDoador(doador.getNomeDoador());
        doadorParaEditar.setCpfDoador(doadorParaEditar.getCpfDoador());
        doadorParaEditar.setEmailDoador(doador.getEmailDoador());
        doadorParaEditar.setTelefoneDoador(doador.getTelefoneDoador());
        doadorParaEditar.setDataCadastroDoador(doador.getDataCadastroDoador());


        doadorRepository.save(doadorParaEditar);
    }

}

