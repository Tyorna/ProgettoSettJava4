package com.example.demo;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.dao.EdificioDAO;
import com.example.demo.dao.PostazioneDAO;
import com.example.demo.dao.PrenotazioneDAO;
import com.example.demo.dao.UtenteDAO;
import com.example.demo.entities.Edificio;
import com.example.demo.entities.Postazione;
import com.example.demo.entities.Prenotazione;
import com.example.demo.entities.TipoPost;
import com.example.demo.entities.Utente;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class AppRunner implements CommandLineRunner {
	@Autowired 
	private UtenteDAO uDAO;
	@Autowired 
	private PrenotazioneDAO preDAO;
	@Autowired 
	private PostazioneDAO postDAO;
	@Autowired 
	private EdificioDAO edDAO;
	@Override
	public void run(String... args) throws Exception {
		Utente utente1 = Utente.builder().nomeCompleto("Ty Primo").email("ty@p.it").build();
		Utente utente2 = Utente.builder().nomeCompleto("Giorgia ALberani").email("gio@alb.it").build();
		Utente utente3 = Utente.builder().nomeCompleto("Alessandro Scotti").email("ale@scotti.it").build();
		Utente utente4 = Utente.builder().nomeCompleto("Elisa N").email("elisa@N.it").build();
		Utente utente5 = Utente.builder().nomeCompleto("Giulia Palu").email("giulia@palu.it").build();
		uDAO.save(utente1);
		uDAO.save(utente2);
		uDAO.save(utente3);
		uDAO.save(utente4);
		uDAO.save(utente5);

		log.info("**EDIFICI**");
		Edificio edificio1 = Edificio.builder().nome("Edificio Principale").indirizzo("Via Emilia").citta("Reggio Emilia").build();
		Edificio edificio2 = Edificio.builder().nome("UniPr").indirizzo("Via Langhirano").citta("Parma").build();
		Edificio edificio3 = Edificio.builder().nome("Matitone").indirizzo("Via NonRicordo").citta("Genova").build();
		Edificio edificio4 = Edificio.builder().nome("UniGe").indirizzo("Via NonHoInventiva").citta("Genova").build();
		edDAO.save(edificio1);
		edDAO.save(edificio2);
		edDAO.save(edificio3);
		edDAO.save(edificio4);
		
		log.info("**Postazioni**");
		Postazione postazione1 = Postazione.builder().descrizione("Una piccola sala dedita a piccoli eventi privati").tipo(TipoPost.Privato).maxOccupanti(10).edificio(edificio1).build();
		Postazione postazione2 = Postazione.builder().descrizione("Una sala grande per le riunioni").tipo(TipoPost.SalaRiunioni).maxOccupanti(110).edificio(edificio1).build();
		Postazione postazione3 = Postazione.builder().descrizione("Una salone per le fiere").tipo(TipoPost.OpenSpace).maxOccupanti(5000).edificio(edificio3).build();
		Postazione postazione4 = Postazione.builder().descrizione("Una piccola sala dedita eventi privati").tipo(TipoPost.Privato).maxOccupanti(60).edificio(edificio3).build();
		Postazione postazione5 = Postazione.builder().descrizione("Una piccola sala dedita eventi privati").tipo(TipoPost.Privato).maxOccupanti(40).edificio(edificio2).build();
		Postazione postazione6 = Postazione.builder().descrizione("Una comoda sala riunioni").tipo(TipoPost.SalaRiunioni).maxOccupanti(50).edificio(edificio1).build();
		postDAO.save(postazione1);
		postDAO.save(postazione2);
		postDAO.save(postazione3);
		postDAO.save(postazione4);
		postDAO.save(postazione5);
		postDAO.save(postazione6);
		
		log.info("**Prenotazioni**");
		
		Prenotazione prenotazione5 = Prenotazione.builder().dataPrenotazione(LocalDate.now()).utente(utente1).postazione(postazione4).build();
		preDAO.save(prenotazione5);
		try {
		Prenotazione prenotazione1 = Prenotazione.builder().dataPrenotazione(LocalDate.now()).utente(utente1).postazione(postazione1).build();
		if(preDAO.controlloDataPostazione(prenotazione1.getPostazione(), prenotazione1.getDataPrenotazione())){
			log.info("Postazione già prenotata");
		} else {
			if(preDAO.controlloDataUtente(prenotazione1.getUtente(), prenotazione1.getDataPrenotazione())){
				log.info("Postazione già prenotata dall'utente");
			} else {
				preDAO.save(prenotazione1);
			}
		}
		}catch (Exception e) {
			e.printStackTrace();
			log.info("Errore durante la creazione della prenotazione");
		}
		
			
		Prenotazione prenotazione2 = Prenotazione.builder().dataPrenotazione(LocalDate.of(2023, 8, 12)).utente(utente2).postazione(postazione2).build();
	Prenotazione prenotazione3 = Prenotazione.builder().dataPrenotazione(LocalDate.of(2023, 10, 2)).utente(utente3).postazione(postazione3).build();
		Prenotazione prenotazione4 = Prenotazione.builder().dataPrenotazione(LocalDate.of(2023, 9, 17)).utente(utente1).postazione(postazione4).build();
		preDAO.save(prenotazione2);
		preDAO.save(prenotazione3);
		preDAO.save(prenotazione4);
		
		log.info("**Find Postazione**");
		postDAO.findPostazione(TipoPost.OpenSpace, "Genova");
	}
}