package com.example.demo.dao;

import java.time.LocalDate;

import com.example.demo.entities.Postazione;
import com.example.demo.entities.Prenotazione;
import com.example.demo.entities.Utente;

public interface PrenotazioneDAO {
	public void save(Prenotazione prenotazione);
	public boolean controlloDataPostazione(Postazione postazione, LocalDate dataPrenotazione);
	public boolean controlloDataUtente(Utente utente, LocalDate dataPrenotazione);
}
