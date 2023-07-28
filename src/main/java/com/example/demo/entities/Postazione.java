package com.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "postazioni")
@Getter
@Setter
public class Postazione {
	@Id
	@GeneratedValue
	private long idPostazione;
	private String descrizione;
	@Enumerated(EnumType.STRING)
	private TipoPost tipo;
	private int maxOccupanti;
	
	@ManyToOne
	@JoinColumn(name = "edificio", referencedColumnName = "id")
	private Edificio edificio;
	
	@OneToOne(mappedBy ="prenotazione")
	private Prenotazione prenotazione;
}
