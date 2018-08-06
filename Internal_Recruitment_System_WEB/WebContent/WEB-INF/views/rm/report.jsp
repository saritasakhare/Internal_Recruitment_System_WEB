<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Insert title here</title>
	<link rel="stylesheet" href="/Internal_Recruitment_System_WEB/css/table.css" >
	<link rel="stylesheet" href="/Internal_Recruitment_System_WEB/css/custom/viewRequisitionsList.css" >
</head>
<body>
	
	<c:if test="${msg!=null}">
		<div class="message"> ${msg} </div>
	</c:if>
	<c:if test="${errMsg!=null}">
		<label class="err-message"> ${errMsg}  </label>
	</c:if>
	
	<c:if test="${listSize==0}">
		<label class="err-message"> No Requisitions Found! </label>
	</c:if>

	<c:if test="${listSize>0}">
	<table cellspacing="0px">
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
				
			</tr>
		</c:forEach>
	</table>
	</c:if>
	
</body>
</html>