package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dal.AgendaDAO;
import dal.AgendaDAOImpl;
import model.Appuntamento;

/**
 * Servlet implementation class Agenda
 */
@WebServlet("/agenda")
public class Agenda extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	AgendaDAO ad;
    
    public Agenda() {
        super();
        ad = new AgendaDAOImpl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Appuntamento> all = ad.getAll();
		
		request.setAttribute("tutti", all);
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int id = Integer.parseInt(request.getParameter("id")); 
		int idUtente = Integer.parseInt(request.getParameter("idUtente")); 
		LocalDate date = LocalDate.parse(request.getParameter("data")); 
		LocalTime oraInizio = LocalTime.parse(request.getParameter("oraInizio")); 
		LocalTime oraFine = LocalTime.parse(request.getParameter("oraFine")); 
		String argomento = request.getParameter("argomento"); 
		
		Appuntamento a = new Appuntamento(id, argomento, date, oraInizio, oraFine, idUtente); 
		
		ad.addAppuntamento(a);
		
		doGet(request, response);
	}

}