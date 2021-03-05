package dao;

import domain.Equipe;
import domain.Jogador;

import javax.persistence.Query;
import java.util.List;

public class JogadorDAO extends GenericDAO<Jogador>{

    public String equipeByJogador(String nomeDoJogador){
        Query query = em.createNamedQuery("equipeByPlayer");
        query.setParameter("nomeJogador", nomeDoJogador);
        return query.getSingleResult().toString();
    }
    public Jogador JogadorByNome (String nome){
        Query query = em.createNamedQuery("jogadorByNome");
        query.setParameter("nomeDoJogador", nome);
        return (Jogador) query.getSingleResult();
    }
    public List<Jogador> JogadorByStatus (Boolean status){
        Query query = em.createNamedQuery("jogadorByStatus");
        query.setParameter("status", status);
        return query.getResultList();
    }

}
