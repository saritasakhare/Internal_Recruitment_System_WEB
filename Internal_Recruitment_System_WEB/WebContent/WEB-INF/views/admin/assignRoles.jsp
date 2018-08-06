<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>

	
	
        <div class="body">
            <h1>Update User</h1>
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
                    
           	<div>        
        	<f:form  action="processAssignRoles.mvc" method="post" modelAttribute="User">
        		<table cellspacing="6" cellpadding="6">
        		<tr>
        			<th> User Id : </th>
        			<td><f:input path="userId" readonly="true"/></td>
        			
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
        			<th colspan="2"><input type="submit" value="Update"> </th>
        		</tr>
        		</table>
        	</f:form>
        </div>
        </div>
   </center>
</body>
</html>