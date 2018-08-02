<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Insert title here</title>
	<link rel="stylesheet" href="/Internal_Recruitment_System_WEB/css/table.css" >
</head>
<body>
	
	<h2>All Requisitions List</h2>
	<c:if test="${msg!=null}">
		${msg}
	</c:if>
	<table>
		<tr>
			<th>Req. Id</th>
			<th>RM Id</th>
			<th>Project Id</th>
			<th>Status</th>
			<th>Vacancy Name</th>
			<th>Skill</th>
			<th>Domain</th>
			<th>Required</th>
		</tr>
		<c:forEach var="req" items="${requisitionList}">
			<tr>
				<td>${req.requisitionId}</td>
				<td>${req.userBean.userId}</td>
				<td>${req.projectBean.projectId}</td>
				<td>${req.currentStatus}</td>
				<td>${req.vacancyName}</td>
				<td>${req.skill}</td>
				<td>${req.domain}</td>
				<td>${req.numberRequired}</td>
				<td><a class="button" href="viewRequisition.mvc?requisitionId=${req.requisitionId}"> View  </a></td>
			</tr>
		</c:forEach>
	</table>
	
</body>
</html>