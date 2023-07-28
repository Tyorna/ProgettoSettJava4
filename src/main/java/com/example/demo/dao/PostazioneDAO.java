package com.example.demo.dao;


import java.util.List;

import com.example.demo.entities.Postazione;
import com.example.demo.entities.TipoPost;

public interface PostazioneDAO {
	public void save(Postazione postazione);

	public void findPostazione(TipoPost tipo, String citta)	;
}
