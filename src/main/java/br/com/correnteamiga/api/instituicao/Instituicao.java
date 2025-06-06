package br.com.correnteamiga.api.instituicao;

import br.com.correnteamiga.api.doacao.Doacao;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "instituicao")
@Entity
public class Instituicao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idInstituicao;

    private String nomeInstituicao;

    private String cnpjInstituicao;

    private String areaInstituicao;

    private String telefoneInstituicao;

    private String emailInstituicao;

    private String enderecoInstituicao;

    @OneToMany(mappedBy = "instituicao")
    private List<Doacao> doacoes;

}
