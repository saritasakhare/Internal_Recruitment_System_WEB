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
	
	<c:if test="${msg!=null}">
		${msg}
	</c:if>
	<sf:form action="processUpdteRequisition.mvc" modelAttribute="requisition">
		<table>
			<tr>
				<td> <label>Requisition Id</label> </td>
				<td>
					 <sf:input path="requisitionId"/>
					 <sf:errors path="requisitionId"/>
				 </td>
			</tr>
			<tr>
				<td> <label>project Id</label> </td>
				<td>
					 <sf:input path="projectBean.projectId"/>
					 <sf:errors path="projectBean.projectId"/>
				 </td>
			</tr>
			<tr>
				<td> <label>Vacancy Name</label> </td>
				<td>  
					<sf:input path="vacancyName"/>
					<sf:errors path="vacancyName"/>
				</td>
			</tr>
			<tr>
				<td> <label>Skills</label> </td>
				<td>  
					<sf:select path="skill">
						<sf:option value="Level1">Level1</sf:option>
						<sf:option value="Level2">Level2</sf:option>
						<sf:option value="Level3">Level3</sf:option>
						<sf:option value="Level4">Level4</sf:option>
					</sf:select>
					<sf:errors path="skill"/>
				</td>
			</tr>
			<tr>
				<td> <label>Domain</label> </td>
				<td>  
					<sf:select path="domain" >
						<sf:option value="Java EE">Java EE</sf:option>
						<sf:option value="VB">VB</sf:option>
						<sf:option value="UI/UX">Java EE</sf:option>
						<sf:option value="JavaScript">JavaScript</sf:option>
						<sf:option value="Cloud">Cloud</sf:option>
					</sf:select>
					<sf:errors path="domain"/>
				</td>
			</tr>
			<tr>
				<td> <label>Number Required</label> </td>
				<td>  
					<sf:input path="numberRequired"/>
					<sf:errors path="numberRequired"/>
				</td>
			</tr>
			<tr>
				<td colspan="2"> <input type="submit" value="Update Requisition" />  </td>
			</tr>
		</table>
	</sf:form>
	<h1> <a href="viewAssignedRequisition.mvc?requisitionId=${requisitionId}"> View Assigned Employees </a> </h1>
</body>
</html>