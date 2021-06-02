package controller;

import java.util.ArrayList;
import java.util.Random;

import model.Esame;
import model.Studente;

public class CorsoLaurea {
	
	private String nome;
	private ArrayList<Studente> immatricolati;
	public static int prossimaMatricola = 0;
	public static final int MIN_CREDITI = 100;
	
	
	public CorsoLaurea(String nomeStudente) {
		
		this.immatricolati = new ArrayList<>(); 
			
		iscrivi(nomeStudente);
	
	}
		
	public String getNome() {
		return nome;
	}

	public void iscrivi(String nomeStudente) {
		Studente studente1 = new Studente(nomeStudente, ++prossimaMatricola);
		immatricolati.add(studente1);
	}
	
	public ArrayList<Studente> getImmatricolati() {
		return immatricolati;
	}

	public void ritira(String nomeStudente) {
		
		for (int i = 0; i < immatricolati.size(); i++) {
			if(immatricolati.get(i).getNome().equals(nomeStudente)) {
				immatricolati.remove(i);
			}
		}
	}

	public void appello(String nomeEsame, ArrayList<Studente> immatricolati) {
		
		Random casuale = new Random();
				
		for (int i = 0; i < immatricolati.size(); i++) {
			Esame esame = immatricolati.get(i).cercaEsamiPiano(nomeEsame);
			immatricolati.get(i).aggiungiEsame(nomeEsame, esame.getCrediti());
			int random = casuale.nextInt(30);
			/*while(!(random<=30&&random>0)) {
				random = casuale.nextInt();
			}*/
			immatricolati.get(i).promosso(nomeEsame, random);
		}
				
	}

	public void laurea() {
		
		for (Studente studente : immatricolati) {
			studente.crediti();
			if(studente.crediti()>=MIN_CREDITI) {
				System.out.println("Lo studente " + studente.getNome()  + " si è laureato! Con una media di " + studente.media() + ".");
				//ritira(studente.getNome());
			} else {
			System.out.println("Allo studente " + studente.getNome() + " mancano dei crediti.");
			}
		}//end for
					
	}


}
