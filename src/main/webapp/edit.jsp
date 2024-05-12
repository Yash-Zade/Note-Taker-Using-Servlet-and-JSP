<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="nav.jsp"%>
    <%@page import="org.hibernate.Session" %>
    <%@page import="org.hibernate.query.Query" %>
    <%@page import="com.MyPackage.*" %>
    <%@page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	int id=Integer.parseInt(request.getParameter("id"));
	Session s=Provider.getFactory().openSession();
	NotesData n=s.get(NotesData.class,id);
	
%>
<form action="Update" method="post">
<input value="<%=n.getId()%>" name="id" type="hidden"></inpute>
  <div class="mb-3">
    <label for="text" class="form-label">Title</label>
    <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="title" value="<%=n.getTitle() %>">
    
  </div>
  <div class="mb-3">
    <label for="content" class="form-label">Note</label>
    <textarea name="content"class="form-control" ><%=n.getNote()%></textarea>
  </div>
  <button type="submit" class="btn btn-primary">Submit</button>
</form>

</body>
</html>