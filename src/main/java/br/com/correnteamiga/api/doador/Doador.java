package br.com.correnteamiga.api.doador;

import br.com.correnteamiga.api.doacao.Doacao;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "doadores")
@Entity
public class Doador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDoador;

    private String nomeDoador;

    private String cpfDoador;

    private String emailDoador;

    private String telefoneDoador;

    private LocalDate dataCadastroDoador;

    @OneToMany(mappedBy = "doador")
    private List<Doacao> doacoes;
}
