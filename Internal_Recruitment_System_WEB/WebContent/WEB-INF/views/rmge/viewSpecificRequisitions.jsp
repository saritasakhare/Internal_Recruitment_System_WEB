
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Insert title here</title>
	<link rel="stylesheet" href="/Internal_Recruitment_System_WEB/css/form.css" >
</head>
<body>
	
		<h1>View Specific RM's Requisitions</h1>
	<c:if test="${msg!=null}">
		${msg}
	</c:if>
	
	<form action="processViewSpecificRequisitions.mvc">
		Enter RM_Id :
		<input type="text" name="rmId" />
		<input type="submit" value="List" />
	</form>
	
</body>
</html>