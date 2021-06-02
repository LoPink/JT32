package view;

import java.util.ArrayList;

import controller.CorsoLaurea;
import model.*;

public class CorsoTester {

	public static void main(String[] args) {
	
		Esame[] listaEsami = {

		new Esame("matematica discreta", 24),
		new Esame("C++", 25),
		new Esame("Analisi II", 28),
		new Esame("Calcolo matriciale", 21),
		new Esame("Programmazione II", 27),
		new Esame("Inglese", 42),
		new Esame("Algoritmi e strutture dati", 50),
		new Esame("Sistemi complessi", 36)
		};
		
		CorsoLaurea informatica = new CorsoLaurea("Paperino");
		
		informatica.iscrivi("Pippo");
		informatica.iscrivi("Topolino");
		informatica.iscrivi("Minnie");
		informatica.iscrivi("Paperina");

		for (Studente studente : informatica.getImmatricolati()) {
			for (Esame esame : listaEsami) {
				studente.getPianoStudio().add(esame);
			}
		}
				
		informatica.appello("matematica discreta", informatica.getImmatricolati());
		informatica.appello("C++", informatica.getImmatricolati());
		informatica.appello("Analisi II", informatica.getImmatricolati());
		informatica.appello("Calcolo matriciale", informatica.getImmatricolati());
		informatica.appello("Programmazione II", informatica.getImmatricolati());
		informatica.appello("Inglese", informatica.getImmatricolati());
		informatica.appello("Algoritmi e strutture dati", informatica.getImmatricolati());
		informatica.appello("Sistemi complessi", informatica.getImmatricolati());
		
		informatica.laurea();
			
		
	}

}
