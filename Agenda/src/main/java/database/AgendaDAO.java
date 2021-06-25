package database;

import java.util.List;

import model.Appuntamento;

public interface AgendaDAO {
	
	
	String ADD = "INSERT INTO appuntamento() values(?,?,?,?,?)";
	
	String FIND_ALL = "SELECT * from appuntamento";
	String FIND_ONE = "SELECT * from appuntamento WHERE id =?";
	
	
	void addAppuntamento(Appuntamento a);
	
	List<Appuntamento> getAll();
	
	Appuntamento getOneById(int id);


}
