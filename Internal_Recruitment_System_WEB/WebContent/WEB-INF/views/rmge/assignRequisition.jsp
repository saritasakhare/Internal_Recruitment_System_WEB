
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
	
	<h1>Assign Requisitions</h1>
	<c:if test="${msg!=null}">
		${msg}
	</c:if>
	
	<sf:form action="saveAssignedRequisition.mvc" modelAttribute="idList">
		<table>
				<tr>
					<th></th>
					<th>Employee Id</th>
					<th>Employee Name</th>
					<th>Project Id</th>
					<th>Skill</th>
					<th>Domain</th>
					<th>Skills</th>
				</tr>
			<c:forEach var="emp" items="${employeeList}" varStatus="loop">
				<tr>
					<td> <input type="checkbox" name="list[${loop.index}]" value="${emp.employeeId}"> </td>
					<td>${emp.employeeId}</td>
					<td>${emp.employeeName}</td>
					<td>${emp.projectBean.projectId}</td>
					<td>${emp.skill}</td>
					<td>${emp.domain}</td>
					<td>${emp.years}</td>
				</tr>
			</c:forEach>
		</table>
		
		<input type="hidden" name="requisitionId" value="${requisitionId}">
		<input type="submit" value="Save Assigned">
	</sf:form>
</body>
</html>