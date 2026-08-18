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

<!-- List<CategoryBean>cat_List=(List<CategoryBean>)request.getAttribute("catList"); -->

<c:forEach items="${ catList }" var="category">
<a href="MovieLists?catId=${category.id}">${category.title}</a>
</c:forEach>


</body>
</html>