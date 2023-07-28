package com.example.demo.dao;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Postazione;
import com.example.demo.entities.Prenotazione;
import com.example.demo.entities.Utente;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PrenotazioneService implements PrenotazioneDAO{
	@Autowired
	private PrenotazioneRepository preRepo;
	
	public void save(Prenotazione prenotazione) {
		preRepo.save(prenotazione);
		log.info("Prenotazione " + prenotazione.getDataPrenotazione()+ " della postazione numero: " + prenotazione.getPostazione().getIdPostazione() +" dell'utente: " + prenotazione.getUtente().getNomeCompleto() + " salvata!");
	}
	
	public boolean controlloDataPostazione(Postazione postazione, LocalDate dataPrenotazione) {
	        return preRepo.existsByPostazioneAndDataPrenotazione(postazione, dataPrenotazione);
	    }
	
	public boolean controlloDataUtente(Utente utente, LocalDate dataPrenotazione) {
        return preRepo.existsByUtenteAndDataPrenotazione(utente, dataPrenotazione);
    }
	}
