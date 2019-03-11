<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h2 class="my-4">FOOD STOP</h2>
          <div class="list-group">
          
          <c:forEach items="${categories}" var="category">
          
          <a href="${contextRoot}/show/category/${category.id}/items" class="list-group-item" 
          id="a_${category.name}">
          ${category.name}</a>
  
          </c:forEach>
            
          </div>