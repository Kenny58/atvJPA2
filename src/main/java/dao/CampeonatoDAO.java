package dao;

import domain.Campeonato;
import domain.Equipe;

import javax.persistence.Query;
import java.util.List;

public class CampeonatoDAO extends GenericDAO<Campeonato>{

    public List<Equipe> equipesDoCampeonato(String nomeCampeonato){
        Query query = em.createNamedQuery("equipesDoCampeonato");
        query.setParameter("nomeCampeonato",nomeCampeonato);
        return query.getResultList();
    }
}
