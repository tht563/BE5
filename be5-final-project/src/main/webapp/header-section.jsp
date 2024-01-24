<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<header class="header_section">
      <nav class="navbar navbar-expand-lg custom_nav-container ">
        <a class="navbar-brand" href="Home">
          <span>
            Giftos
          </span>
        </a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
          <span class=""></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
          <ul class="navbar-nav  ">
            <li class="nav-item active">
              <a class="nav-link" href="Home">Home <span class="sr-only">(current)</span></a>
            </li>
            
            <c:forEach items="${categories}" var = "categories">
            
	            <li class="nav-item">
	              <a class="nav-link" href="Home?action=SHOW_PRODUCT_BY_CATEGORY&categoryId=${categories.id}">
	                ${categories.name}
	              </a>
	            </li>
            </c:forEach>
            
            <c:if test="${empty sessionScope.user}">
	            <li>
	              <a class="nav-link" href="login.jsp">Login</a>
	            </li>
	             <li>
              		<a class="nav-link" href="register.jsp">Register</a>
            	</li>
            </c:if>
            <c:if test="${not empty sessionScope.user}">
	            <li>
	               <a class="nav-link" href="login.jsp">Hello ${sessionScope.user.username}</a>
	            </li>
	            <li>
	            	<a class="nav-link" href="Authentication?action=LOGOUT">Logout</a>
	            </li>
            </c:if>
            <a href=""> <i class="fa fa-shopping-bag" aria-hidden="true"></i> ${sessionScope.cart.size()}
          </div>
        </div>
      </nav>
    </header>