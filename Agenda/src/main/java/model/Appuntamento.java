package model;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

public class Appuntamento {
	
	private int id;
	private String argomento;
	private LocalDate data;
	private LocalTime oraInizio;
	private LocalTime OraFine;
	private int utenteId;
	
	
	public Appuntamento() {
		
	}
	
	public Appuntamento(int id, String argomento, LocalDate date, LocalTime oraInizio2, LocalTime oraFine2, int utenteId ) {
		
		this.id = id;
		this.argomento = argomento;
		this.data = date;
		this.oraInizio = oraInizio2;
		this.OraFine = oraFine2;
		this.utenteId = utenteId;
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getArgomento() {
		return argomento;
	}
	
	public void setArgomento(String argomento) {
		this.argomento = argomento;
	}
	
	public LocalDate getData() {
		return data;
	}
	
	public void setData(LocalDate data) {
		this.data = data;
	}
	
	public LocalTime getOraInizio() {
		return oraInizio;
	}
	
	public void setOraInizio(LocalTime oraInizio) {
		this.oraInizio = oraInizio;
	}
	
	public LocalTime getOraFine() {
		return OraFine;
	}
	
	public void setOraFine(LocalTime oraFine) {
		OraFine = oraFine;
	}
	
	public int getUtenteId() {
		return utenteId;
	}
	
	public void setUtenteId(int id) {
		
		this.utenteId = id;
	
	}
	
	@Override
	public String toString() {
		return "Appuntamento [id=" + id + ", argomento=" + argomento + ", data=" + data + ", oraInizio=" + oraInizio
				+ ", OraFine=" + OraFine + ", utenteId=" + utenteId + "]";
	}
	

}
