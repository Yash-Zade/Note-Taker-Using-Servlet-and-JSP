package com.MyPackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;




@WebServlet(name="SaveNote",urlPatterns="/Save")
public class SaveNote extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			String title=request.getParameter("title");
			String content=request.getParameter("content");
			
			NotesData note=new NotesData(title, content, new Date());
			Session s=Provider.getFactory().openSession();
			Transaction tx=s.beginTransaction();
			s.persist(note);
			tx.commit();
			
//			Provider.closeFactory();
			PrintWriter out=response.getWriter();
			out.println("success");
			response.sendRedirect("show.jsp");
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
	}

}
