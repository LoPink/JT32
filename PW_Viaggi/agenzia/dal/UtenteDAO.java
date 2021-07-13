package agenzia.dal;

import org.springframework.data.jpa.repository.JpaRepository;

import agenzia.entities.Utente;

public interface UtenteDAO extends JpaRepository<Utente, Integer> {

}
