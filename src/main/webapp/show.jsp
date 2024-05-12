<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="org.hibernate.Session" %>
    <%@page import="org.hibernate.query.Query" %>
    <%@page import="com.MyPackage.*" %>
    <%@page import="java.util.*" %>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://getbootstrap.com/docs/5.3/assets/css/docs.css" rel="stylesheet">
    <title>Bootstrap Example</title>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
  </head>
  <body class="p-3 m-0 border-0 bd-example m-0 border-0">

    <!-- Example Code -->
    
    <%@include file="nav.jsp" %>
    <h1>All Notes</h1>
     <%
     	Session s=Provider.getFactory().openSession();
     	Query q=s.createQuery("from NotesData");
     	List<NotesData> li=q.list();
     	for(NotesData n:li){
     %> 
     	   
    <div class="card" style="width: 18rem;">
      <div class="card-body">
        <h5 class="card-title"><%=n.getTitle() %></h5>
        <h6 class="card-subtitle mb-2 text-body-secondary">Card subtitle</h6>
        <p class="card-text"><%=n.getNote() %></p>
        <a href="Delete?id=<%=n.getId()%>" class="btn">Delete</a>
        <a href="edit.jsp?id=<%=n.getId()%>" class="btn">Update</a>
      </div>
    </div>
    <% 
    	}
      s.close();
     
     %>
    <!-- End Example Code -->
  </body>
</html>