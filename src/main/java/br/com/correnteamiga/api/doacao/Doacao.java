package br.com.correnteamiga.api.doacao;

import br.com.correnteamiga.api.doador.Doador;
import br.com.correnteamiga.api.instituicao.Instituicao;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.security.PrivateKey;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "doacao")
@Entity
public class Doacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDoacao;

    private String dataDoacao;

    private String valorDoacao;

    private String formaPagamentoDoacao;

    @ManyToOne
    @JoinColumn(name = "instituicao_id")
    private Instituicao instituicao;

    @ManyToOne
    @JoinColumn(name = "doador_id")
    private Doador doador;
}
