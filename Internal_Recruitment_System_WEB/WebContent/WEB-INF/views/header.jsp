<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Insert title here</title>
	<link rel="stylesheet" href="css/main.css">
	<link rel="stylesheet" href="../../../css/main.css">
	<link rel="stylesheet" href="/Internal_Recruitment_System_WEB/css/main.css" >
	<link rel="stylesheet" href="/Internal_Recruitment_System_WEB/css/custom/header.css" >
</head>
<body>
	 <div class="header">
            <div class="icon"> <!-- <a href="/Internal_Recruitment_System_WEB/home.mvc"> <img src="../img/img6.jpg" /> </a> --> </div>
            <div class="title">Internal Recruitment System</div>
            <div class="desc-ln"> Recruit Employees For Projects.</div>
     </div>
     <c:if test="${user!=null }">
     	<div id="logout-div">
     			<div class="userId"> <label > ${ user.userId} </label> </div>
     			<div class="userRole"> <label > ${ user.role} </label> </div>
     		
     	<div class="logout-lnk" >	 <a href="/Internal_Recruitment_System_WEB/logout.mvc" class="btn">  Log Out </a> </div>
     	</div>
     </c:if>
</body>
</html>