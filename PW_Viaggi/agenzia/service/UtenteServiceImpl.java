package agenzia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import agenzia.dal.UtenteDAO;
import agenzia.entities.Utente;

@Service
public class UtenteServiceImpl implements UtenteService {

	@Autowired
	UtenteDAO ud;
	
	
	@Override
	public List<Utente> trovaTutti() {
		return ud.findAll();
	}

	@Override
	public Utente trovaById(int id) {
		return ud.findById(id).get();
	}

	@Override
	public void aggiungiUtente() {
		// TODO Auto-generated method stub

	}

	@Override
	public void aggiungiUtente(String nome, String cognome, String email, int nCarta) {
		Utente u = new Utente(0, nome, cognome, email, nCarta);
		ud.findAll().add(u);
	}

}
