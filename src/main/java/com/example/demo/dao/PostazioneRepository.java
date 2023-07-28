package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Postazione;
import com.example.demo.entities.TipoPost;

@Repository
public interface PostazioneRepository extends JpaRepository<Postazione, Long>{
	
//	List<Postazione> findByTipoPost(TipoPost tipoPost);
	List<Postazione> findByTipoAndEdificio_Citta(TipoPost tipoPost, String città);
}
