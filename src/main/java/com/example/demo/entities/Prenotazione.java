package com.example.demo.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "prenotazione")
@Getter
@Setter
public class Prenotazione {
	@Id
	@GeneratedValue
	private long id;
	private LocalDate dataPreontazione;
	
	@ManyToOne
	@JoinColumn(name = "utente", referencedColumnName = "id")
	private Utente utente;
	
	@OneToOne
	private Postazione postazione;
}
