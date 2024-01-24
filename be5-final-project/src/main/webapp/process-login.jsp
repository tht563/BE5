<%@page import="entity.User"%>>
<%@page import="dao.UserDAO"%>>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%

String username = request.getParameter("username");
String password = request.getParameter("password");

UserDAO userDAO = new UserDAO();

User user = userDAO.getUserByUsernameAndPassword(username, password);

if (user==null){
	response.sendRedirect("login.jsp");
}else{
	response.sendRedirect("Home");
}
%>>