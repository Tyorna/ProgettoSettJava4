package com.example.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Edificio;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EdificioService implements EdificioDAO{
	@Autowired
	private EdificioRepository edRepo;
	
	public void save(Edificio edificio) {
		edRepo.save(edificio);
		log.info("Edificio " + edificio.getNome() + " salvato!");
	}
}
