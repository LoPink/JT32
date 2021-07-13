package agenzia.service;

import java.util.List;

import agenzia.entities.Viaggio;

public interface ViaggioService {
	
	List<Viaggio> trovaTutti();
	Viaggio trovaUno(int id);

}
