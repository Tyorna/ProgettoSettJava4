package com.example.demo.dao;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Postazione;
import com.example.demo.entities.Prenotazione;
import com.example.demo.entities.Utente;

@Repository
public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Long>{
	
	boolean existsByPostazioneAndDataPrenotazione(Postazione postazione, LocalDate dataPrenotazione);
	boolean existsByUtenteAndDataPrenotazione(Utente utente, LocalDate dataPrenotazione);
}
