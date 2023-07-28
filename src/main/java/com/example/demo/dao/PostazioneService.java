package com.example.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Edificio;
import com.example.demo.entities.Postazione;
import com.example.demo.entities.Prenotazione;
import com.example.demo.entities.TipoPost;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PostazioneService implements PostazioneDAO{
	@Autowired
	private PostazioneRepository postRepo;
	
	public void save(Postazione postazione) {
		postRepo.save(postazione);
		log.info("Postazione " + postazione.getIdPostazione() +  " salvata!");
}
	public void findPostazione(TipoPost tipo, String citta) {
        List<Postazione> postazione = postRepo.findByTipoAndEdificio_Citta(tipo, citta);
        if (postazione != null) {
        	for (Postazione postazioni : postazione) {
        		log.info("Postazione trovata: " + postazioni.getIdPostazione() + " a: " + postazioni.getEdificio().getCitta());
        	}
        } else {
        	log.info("Postazione non trovata");
        }
    }
}