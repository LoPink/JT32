package agenzia.integration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import agenzia.entities.Viaggio;
import agenzia.service.ViaggioService;

@RestController
@RequestMapping("/api/viaggi")
public class ViaggioREST {
	
	@Autowired
	ViaggioService vs;
	
	
	
	@GetMapping("")
	public List<Viaggio> trovaViaggi() {
		return vs.trovaTutti();
	}
	
	@GetMapping("/{id}")
	public Viaggio trovaUnViaggio(@PathVariable int id) {
		return vs.trovaUno(id);
	}

}