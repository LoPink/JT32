package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.Appuntamento;

public class AgendaDAOImpl implements AgendaDAO {
	
	DB db = new DB();
	Connection conn; 
	Statement stat ; 
	ResultSet rs; 
	PreparedStatement ps; 
	

	@Override
	public void addAppuntamento(Appuntamento a) {
		db.getConn(); 
		
		try {
			
			
			ps = conn.prepareStatement(ADD);
			ps.setInt(1, a.getUtenteId());
			ps.setDate(2, Date.valueOf(a.getData()));
			ps.setTime(3, Time.valueOf(a.getOraInizio()));
			ps.setTime(4, Time.valueOf(a.getOraFine()));
			ps.setString(5, a.getArgomento());
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Appuntamento> getAll() {
		
		List <Appuntamento> appuntamenti = new ArrayList<>(); 
		
		try {
			
			
			stat = db.getConn().createStatement();
			rs = stat.executeQuery(FIND_ALL);
			while(rs.next()) {
				Appuntamento a = new Appuntamento(); 
				
				a.setArgomento(rs.getString("argomento"));
				a.setId(rs.getInt("id"));
				a.setUtenteId(rs.getInt("idUtente"));
				a.setData(rs.getDate("data").toLocalDate());
				a.setOraInizio(rs.getTime("oraInizio").toLocalTime());
				a.setOraFine(rs.getTime("oraFine").toLocalTime());
				
				appuntamenti.add(a); 
				
			}
			
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return appuntamenti;
	}

	@Override
	public Appuntamento getOneById(int id) {
		
		for (Appuntamento a : getAll()) {
			if(a.getId() == id) {
				return a; 
			}
			
		}
		
		return null;
	}
	


}
