package model;

import java.util.ArrayList;

public class Studente {

	private String nome;
	private int matricola;
	private ArrayList<Esame> esamiSostenuti;
	private ArrayList<Esame> pianoStudio;
	
	
	public Studente(String nome, int matricola) {
		
		this.esamiSostenuti = new ArrayList<>();
		this.pianoStudio = new ArrayList<>();
		this.nome = nome;
		this.matricola = matricola;
	}


	public String getNome() {
		return nome;
	}


	public int getMatricola() {
		return matricola;
	}
	
	

	public ArrayList<Esame> getPianoStudio() {
		return pianoStudio;
	}

	public void aggiungiEsame(String nomeEsame, int crediti) {
		
		Esame esame1 = new Esame(nomeEsame, crediti);
		esamiSostenuti.add(esame1);
				
	}
	
	public void promosso(String nomeEsame, int voto) {
		
		if(voto<18) {
			cancella(nomeEsame);
		}
		Esame esame = cercaEsamiSostenuti(nomeEsame);
		
		if (esame!=null) {
			esame.setVoto(voto);
		} else {
			System.out.println("Esame ancora da sostenere.");
		}
			
	}
	
	private Esame cercaEsamiSostenuti(String nomeEsame) {
		
		for (Esame esame : esamiSostenuti) {
			if (esame.getNome().equals(nomeEsame)) {
				return esame;
			}
		}
		return null;
	}

	public Esame cercaEsamiPiano(String nomeEsame) {
		
		for (Esame esame : pianoStudio) {
			if (esame.getNome().equals(nomeEsame)) {
				return esame;
			}
		}//end for
		return null;
	}

	public void cancella(String nomeEsame) {
		
		for (int i=0; i<esamiSostenuti.size(); i++) {
			if (esamiSostenuti.get(i).getNome().equals(nomeEsame)) {
				esamiSostenuti.remove(i);
			}
		}//end for
	}

	public void cancellaPS(String nomeEsame) {
		
		for (int i=0; i<pianoStudio.size(); i++) {
			if (pianoStudio.get(i).getNome().equals(nomeEsame)) {
				pianoStudio.remove(i);
			}
		}//end for
	}
	
	public double media() {
		
		double somma = 0.0;
		for (int i = 0; i < esamiSostenuti.size(); i++) {
			somma += esamiSostenuti.get(i).getVoto();
		}
		return somma/esamiSostenuti.size();		
		
	}
	
	public double crediti() {
		
		double somma = 0.0;
		for (int i = 0; i < esamiSostenuti.size(); i++) {
			somma += esamiSostenuti.get(i).getCrediti();
		}
		return somma;
	}


	@Override
	public String toString() {
		return "Studente [nome=" + nome + ", matricola=" + matricola + ", esamiSostenuti=" + esamiSostenuti
				+ ", pianoStudio=" + pianoStudio + "]";
	}
	
	
}

















