package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Appuntamento;

/**
 * Servlet implementation class Agenda
 */
@WebServlet("/agenda")
public class Agenda extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Agenda() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		int id = Integer.parseInt(request.getParameter("id")); 
		int idUtente = Integer.parseInt(request.getParameter("idUtente")); 
		LocalDate date = LocalDate.parse(request.getParameter("data")); 
		LocalTime oraInizio = LocalTime.parse(request.getParameter("oraInizio")); 
		LocalTime oraFine = LocalTime.parse(request.getParameter("oraFine")); 
		String argomento = request.getParameter("argomento"); 
		
		Appuntamento a = new Appuntamento(id, argomento, date, oraInizio, oraFine, idUtente); 
		
	}

}
