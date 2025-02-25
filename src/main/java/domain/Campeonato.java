package domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
@NamedQueries({
        @NamedQuery(name = "equipesDoCampeonato", query = "select c.equipes from Campeonato c where c.nome =: nomeCampeonato")
})
public class Campeonato implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @ManyToMany(mappedBy = "campeonatos", cascade = CascadeType.ALL)
    private List<Equipe> equipes;


    @Temporal(TemporalType.DATE)
    private Calendar dataInicio;

    @Temporal(TemporalType.DATE)
    private Calendar dataFim;
}
