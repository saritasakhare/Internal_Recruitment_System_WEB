<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<sf:form action="saveAssignedRequisition.mvc" modelAttribute="">
		<table>
			<tr>
				<th>Employee Id</th>
				<th>Name</th>
				<th>Skill</th>
				<th>Domain</th>
			</tr>
			<c:forEach var="emp" items="empList">
				<tr>
					<td>${emp.employeeId}</td>
					<td>${emp.employeeName }</td>
					<td>${emp.skill}</td>
					<td>${emp.domian}</td>
					<td> <input type="checkbox" name="" value="" > </td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="2">
					<input type="submit" value="Save Requisition">
				</td>
			</tr>
		</table>
	</sf:form>
		
</body>
</html>