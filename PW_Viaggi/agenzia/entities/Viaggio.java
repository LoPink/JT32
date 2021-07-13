package agenzia.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "viaggi")
public class Viaggio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String destinazione;
	private int durata;
	private double prezzoPersona;

	public Viaggio() {}

	public Viaggio(int id, String destinazione, int durata, double prezzoPersona) {
		this.id = id;
		this.destinazione = destinazione;
		this.durata = durata;
		this.prezzoPersona = prezzoPersona;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDestinazione() {
		return destinazione;
	}

	public void setDestinazione(String destinazione) {
		this.destinazione = destinazione;
	}

	public int getDurata() {
		return durata;
	}

	public void setDurata(int durata) {
		this.durata = durata;
	}

	public double getPrezzoPersona() {
		return prezzoPersona;
	}

	public void setPrezzoPersona(double prezzoPersona) {
		this.prezzoPersona = prezzoPersona;
	}

	@Override
	public String toString() {
		return "Viaggio [id=" + id + ", destinazione=" + destinazione + ", durata=" + durata + ", prezzoPersona="
				+ prezzoPersona + "]";
	}

}