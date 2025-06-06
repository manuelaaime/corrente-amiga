package br.com.correnteamiga.api.doacao;

import br.com.correnteamiga.api.doacao.Doacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/doacoes")
public class DoacaoController {
    @Autowired
    DoacaoService doacaoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void cadastrarDoacao(@RequestBody Doacao doacao){
        doacaoService.cadastrarDoacao(doacao);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Doacao> listarTodasDoacoes(){
        return doacaoService.listarTodasDoacoes();
    }
    @GetMapping("/{id}")
    public Optional<Doacao> buscarDoacaoPorId(@PathVariable Long id){
        return doacaoService.buscarDoacaoPorId(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarDoacaoPorId(@PathVariable Long id){
        doacaoService.deletarDoacaoPorId(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarDoacaoPorId(@PathVariable Long id, @RequestBody Doacao doacao){
        doacaoService.atualizarDoacaoPorId(id, doacao);
    }


    public DoacaoController(DoacaoService doacaoService) {
        this.doacaoService = doacaoService;
    }



}


