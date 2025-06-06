package br.com.correnteamiga.api.instituicao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/instituicoes")
public class InstituicaoController {

    @Autowired
    InstituicaoService instituicaoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void cadastrarInstituicao(@RequestBody Instituicao instituicao){
        instituicaoService.cadastrarInstituicao(instituicao);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Instituicao> listarTodasInstituicoes(){
       return instituicaoService.listarTodasInstituicoes();
    }

    @GetMapping("/{id}")
    public Optional<Instituicao> buscarInstituicaoPorId(@PathVariable Long id){
        return instituicaoService.buscarInstituicaoPorId(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarInstituicaoPorId(@PathVariable Long id){
        instituicaoService.deletarInstituicaoPorId(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarInstituicaoPorId(@PathVariable Long id, @RequestBody Instituicao instituicao){
        instituicaoService.atualizarInstituicaoPorId(id, instituicao);
    }
}
