package main;

import dao.CampeonatoDAO;
import dao.EquipeDAO;
import dao.JogadorDAO;
import dao.TecnicoDAO;
import domain.Campeonato;
import domain.Equipe;
import domain.Jogador;
import domain.Tecnico;


import java.util.Arrays;
import java.util.Calendar;

public class App {
    public static void main(String[] args) {
        CampeonatoDAO campeonatoDAO = new CampeonatoDAO();
        EquipeDAO equipeDAO = new EquipeDAO();
        JogadorDAO jogadorDAO = new JogadorDAO();
        TecnicoDAO tecnicoDAO = new TecnicoDAO();


        Campeonato campeonatoFafic = Campeonato.builder().nome("Campeonato Fafic")
                .dataInicio(new Calendar.Builder().setDate(2021,03,15).build())
                .dataFim(new Calendar.Builder().setDate(2021,05,16).build()).build();

        Campeonato campeonatoSertao = Campeonato.builder().nome("Campeonato Sertao")
                .dataInicio(new Calendar.Builder().setDate(2021,8,1).build())
                .dataFim(new Calendar.Builder().setDate(2021,12,1).build()).build();

        campeonatoDAO.saveOrUpdate(campeonatoFafic);
        campeonatoDAO.saveOrUpdate(campeonatoSertao);

        Jogador jogador1 = new Jogador();
        jogador1.setNome("João");
        jogador1.setPosicao("Atacante");
        jogador1.setIsTitutar(true);

        Jogador jogador2 = new Jogador();
        jogador2.setNome("José");
        jogador2.setPosicao("Goleiro");
        jogador2.setIsTitutar(false);

        Jogador jogador3 = new Jogador();
        jogador3.setNome("Felipe");
        jogador3.setPosicao("Volante");
        jogador3.setIsTitutar(true);

        Jogador jogador4 = new Jogador();
        jogador4.setNome("Luciano");
        jogador4.setPosicao("meia");
        jogador4.setIsTitutar(false);


        Tecnico tecnico = new Tecnico();
        tecnico.setNome("Mauricio");

        Tecnico tecnico2 = new Tecnico();
        tecnico2.setNome("Rodrigo");

        campeonatoFafic = campeonatoDAO.findById(Campeonato.class,1l);
        campeonatoSertao = campeonatoDAO.findById(Campeonato.class,2l);

                Equipe equipe1 = Equipe.builder()
                        .campeonatos(Arrays.asList(campeonatoFafic))
                        .jogadores(Arrays.asList(jogador1,jogador2))
                        .nome("Barcelona")
                        .tecnico(tecnico).build();

        equipeDAO.saveOrUpdate(equipe1);

        Equipe equipe2 = Equipe.builder()
                .campeonatos(Arrays.asList(campeonatoFafic, campeonatoSertao))
                .jogadores(Arrays.asList(jogador3,jogador4))
                .nome("PSG")
                .tecnico(tecnico2).build();

         equipeDAO.saveOrUpdate(equipe2);

         tecnico = tecnicoDAO.findById(Tecnico.class,1l);
         equipe1 = equipeDAO.findById(Equipe.class,1l);
         tecnico.setEquipe(equipe1);
         tecnicoDAO.saveOrUpdate(tecnico);

        tecnico2 = tecnicoDAO.findById(Tecnico.class,4l);
        equipe2 = equipeDAO.findById(Equipe.class,2l);
        tecnico2.setEquipe(equipe2);
        tecnicoDAO.saveOrUpdate(tecnico2);

        jogador1 = jogadorDAO.findById(Jogador.class, 2l);
        jogador2 = jogadorDAO.findById(Jogador.class, 3l);
        jogador1.setEquipe(equipe1);
        jogador2.setEquipe(equipe1);
        jogadorDAO.saveOrUpdate(jogador1);
        jogadorDAO.saveOrUpdate(jogador2);

        jogador3 = jogadorDAO.findById(Jogador.class, 5l);
        jogador4 = jogadorDAO.findById(Jogador.class, 6l);
        jogador3.setEquipe(equipe2);
        jogador4.setEquipe(equipe2);
        jogadorDAO.saveOrUpdate(jogador3);
        jogadorDAO.saveOrUpdate(jogador4);

    }
}
