package agenzia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import agenzia.dal.ViaggioDAO;
import agenzia.entities.Viaggio;

@Service
public class ViaggioServiceImpl implements ViaggioService {
	
	@Autowired
	ViaggioDAO vd;

	@Override
	public List<Viaggio> trovaTutti() {
		return vd.findAll();
	}

	@Override
	public Viaggio trovaUno(int id) {
		return vd.findById(id).get();
	}

}