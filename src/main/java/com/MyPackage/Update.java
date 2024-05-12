package com.MyPackage;

import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name="Update",urlPatterns = "/Update" )
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String title=request.getParameter("title");
		String content=request.getParameter("content");
		int id=Integer.parseInt(request.getParameter("id"));
		Session s=Provider.getFactory().openSession();
		Transaction tx=s.beginTransaction();
		NotesData n=s.get(NotesData.class,id);
		n.setDate(new Date());
		n.setNote(content);
		n.setTitle(title);
		
		s.persist(n);
		tx.commit();
		s.close();
		response.sendRedirect("show.jsp");
		
	}

}
