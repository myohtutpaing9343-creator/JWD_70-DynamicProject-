<%@page import="Model.MovieBean"%>
<%@page import="Model.CategoryBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Category List</h1>
<%-- <%

List<MovieBean> movList=(List<MovieBean>)request.getAttribute("mov_list");
%> --%>
<form action="selectedmovie" method="post">
<select name="MvName">
<option value="none">None</option>

<%-- <%
for(MovieBean obj:movList){
	%>
	<option value="<%=obj.getId()%>"><%=obj.getTitle()   %>, <%=obj.getRelease_year().getYear()%> </option>	
<%
}
%> --%>

<c:forEach items="${mov_list}" var="movie">
<option value="${movie.id }">${movie.title},${movie.release_year }
</c:forEach>


</select><br><br>
<input type="submit" value="choose">
</form>







</body>
</html>