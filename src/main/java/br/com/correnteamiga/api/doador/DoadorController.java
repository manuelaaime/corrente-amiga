package br.com.correnteamiga.api.doador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/doadores")
public class DoadorController {

    @Autowired
    DoadorService doadorService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarDoador(@RequestBody Doador doador){
        doadorService.criarDoador(doador);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Doador> listarTodosDoadores(){
        return doadorService.listarTodosDoadores();
    }

    @GetMapping("/{id}")
    public Optional<Doador> buscarDoadorPorId(@PathVariable Long id){
        return doadorService.buscarDoadorPorId(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarDoadorPorId(@PathVariable Long id){
        doadorService.deletarDoadorPorId(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarDoadorPorId(@PathVariable Long id, @RequestBody Doador doador){
        doadorService.atualizarDoadorPorId(id,doador);
    }

}
