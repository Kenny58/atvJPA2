package domain;

import lombok.*;

import javax.persistence.*;

@Entity
@DiscriminatorValue("T")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@NamedQueries({
        @NamedQuery(name = "equipeByTecnico", query = "select t from Tecnico t where t.nome =: nomeDoTecnico")
})
public class Tecnico extends Profissional {

    @OneToOne
    private Equipe equipe;
}
