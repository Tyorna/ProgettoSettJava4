package com.example.demo.entities;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table (name = "edifici")
@Getter
@Setter
public class Edificio {
	@Id
	@GeneratedValue
	private int id;
	private String nome;
	private String indirizzo;
	private String citta;
	
	@OneToMany(mappedBy = "edificio")
	private Set<Postazione> postazione;
	
	public Edificio(String nome, String indirizzo, String citta) {
		this.nome = nome;
		this.indirizzo = indirizzo;
		this.citta = citta;
	}

	@Override
	public String toString() {
		return "Edificio [nome=" + nome + ", id=" + id + ", indirizzo=" + indirizzo + ", citta=" + citta
				+ ", postazione=" + postazione + "]" + "\n";
	}
}
