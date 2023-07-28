package com.example.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Utente;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UtenteService implements UtenteDAO{
	@Autowired
	private UtenteRepository uRepo;
	
	public void save(Utente utente) {
		uRepo.save(utente);
		log.info("Utente " + utente.getNomeCompleto() +  " salvato!");
	}
}
