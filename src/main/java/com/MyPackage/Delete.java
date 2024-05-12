package com.MyPackage;

import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.Transaction;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name="Delete",urlPatterns = "/Delete1" )
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int id=Integer.parseInt(request.getParameter("id"));
			Session s=Provider.getFactory().openSession();
			NotesData n= s.get(NotesData.class,id);
			Transaction tx=s.beginTransaction();
			s.remove(n);
			tx.commit();
			s.close();
			response.sendRedirect("show.jsp");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
