package main;

import dao.CampeonatoDAO;
import dao.EquipeDAO;
import dao.JogadorDAO;
import dao.TecnicoDAO;
import domain.Equipe;
import domain.Jogador;
import domain.Tecnico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Consultas {
    public static void main(String[] args) {

        //consultar a equipe pelo nome
        EquipeDAO equipeDAO = new EquipeDAO();
        Equipe equipe = equipeDAO.buscarEquipePorNome("PSG");
        //System.out.println("Equipe: " + equipe.getNome());
        //System.out.println("Equipe: " + equipe.getTecnico().getNome());
        //equipe.getCampeonatos().forEach(c-> System.out.println("Campeonato: " + c.getNome()));


        //Consultar time pelo jogador
        JogadorDAO jogadorDAO = new JogadorDAO();
        //System.out.println("Equipe: " +jogadorDAO.equipeByJogador("João"));

        //consulta campeonatos de uma equipe pelo nome da equipe
        //equipeDAO.campeonatosDaEquipe("Barcelona").forEach(c -> System.out.println("Campeonato: "+ c.getNome()));

        CampeonatoDAO campeonatoDAO = new CampeonatoDAO();
        //campeonatoDAO.equipesDoCampeonato("Campeonato Sertao").forEach(e -> System.out.println("Equipe: " +e.getNome()));

//        Jogador j = (jogadorDAO.JogadorByNome("José"));
//        System.out.println("Jogador: " + j.getNome());
//        System.out.println("Posição: " + j.getPosicao());
//        System.out.println("Equipe: " + j.getEquipe().getNome());
//        System.out.print("É titutar? ");
//        System.out.println(j.getIsTitutar() ? "sim" : "não");

        //jogadorDAO.JogadorByStatus(true).forEach(j -> System.out.println(j.getNome()));

        TecnicoDAO tecnicoDAO = new TecnicoDAO();
        Tecnico tecnico = tecnicoDAO.tecnicoByNome("Mauricio");
        System.out.println("Equipe: " + tecnico.getEquipe().getNome());
        System.out.print("Jogadores: ");
        tecnico.getEquipe().getJogadores().forEach(j-> System.out.println(j.getNome()));
    }
}
