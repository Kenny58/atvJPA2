package domain;

import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@DiscriminatorValue("J")
@NamedQueries({
        @NamedQuery(name = "equipeByPlayer",query = "select j.equipe.nome from Jogador j where j.nome =: nomeJogador"),
        @NamedQuery(name = "jogadorByNome",query = "select j from Jogador j where j.nome =: nomeDoJogador"),
        @NamedQuery(name = "jogadorByStatus",query = "select j from Jogador j where j.isTitutar =: status")
})
public class Jogador extends Profissional {

    private String posicao;
    private Boolean isTitutar;

    @ManyToOne
    private Equipe equipe;

}
