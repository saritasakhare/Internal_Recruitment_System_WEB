<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Insert title here</title>
	<link rel="stylesheet" href="/Internal_Recruitment_System_WEB/css/form.css" >
</head>
<body>

        <div class="body">
           <h1 class="frm-title" > Add User </h1>
           <div class="message" align="center">
	          <c:if test="${msg!=null}">${msg}</c:if>
	   </div>
        
        <div>            
        	<f:form  action="processAddUser.mvc" method="post" modelAttribute="user">
        		<table>
        		<tr>
        			<th> Password </th>
        			<td><f:password path="password"/></td>
        		</tr>
        		<tr>
        			<th> Role </th>
        			<td>
        				<f:select path="role">
        					<f:option value="ADMIN"/>
        					<f:option value="RM"/>
        					<f:option value="RMGE"/>
        				</f:select>
        				<f:errors path="role" />
        			</td>
        		</tr>
        		<tr>
        			<th colspan="2"><input type="submit" value="Add"> </th>
        		</tr>
        		</table>
        	</f:form>
        </div>
        </div>
        
</body>
</html>