<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>All User List</h2>
	
	<c:if test="${msg!=null}">
		<div class="message" >
			${msg}
		</div>
	</c:if>
	<c:if test="${errMsg!=null}">
		 <div class="err-message" >
			${errMsg}
		</div>
	</c:if>
			
	<c:if test="${listSize>0}">
	<table>
		<tr>
			<th>User Id</th>
			<th>Role</th>
		</tr>
		<c:forEach var="user" items="${userList}">
			<tr>
				<td>${user.userId}</td>
				<td>${user.role}</td>
				<td><a class="button" href="deleteUser.mvc?userId=${user.userId}"> Delete  </a></td>
				<td><a class="button" href="assignRoles.mvc?userId=${user.userId}"> Update  </a></td>
			</tr>
		</c:forEach>
	</table>
	</c:if>
	
</body>
</html>