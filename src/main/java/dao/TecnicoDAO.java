package dao;

import domain.Tecnico;

import javax.persistence.Query;

public class TecnicoDAO extends GenericDAO<Tecnico> {

    public Tecnico tecnicoByNome(String nome){
        Query query = em.createNamedQuery("equipeByTecnico");
        query.setParameter("nomeDoTecnico", nome);
        return (Tecnico) query.getSingleResult();
    }
}
