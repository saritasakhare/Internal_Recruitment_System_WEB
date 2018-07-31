<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
    <head>
        <title> project Name | Page Name </title>
        <link rel="stylesheet" href="css/main.css" />
        <link rel="stylesheet" href="css/form.css" />
        <link rel="stylesheet" href="css/custom/login.css" />
    </head>
    
    <body>
        <div class="header">
            <div class="icon"></div>
            <div class="title">Internal Recruitment System</div>
            <div class="desc-ln"> Recruit Employees For Projects.</div>
        </div>
        
        <div class="body">
          
	          <div class="error" align="center" style="color: red; font-family: sans-serif;">
	          <c:if test="${msg!=null}">${msg}</c:if>
	          </div>
           
            <div class="login-panel">
                <div class="title">
                   <label class="title">LOG IN</label> 
                </div>
                <div class="form">
                    <form action="login.mvc" method="post">
                        <table>
                            <tr>
                                <td> <label> Enter User Name : </label> </td>
                            </tr>
                            <tr>
                                <td> <input type="text" name="userId" /> </td>
                            </tr>
                            <tr>
                                <td> <label> Enter Password : </label> </td>
                            </tr>
                            <tr>
                                <td> <input type="password" name="password" /> </td>
                            </tr>
                            <tr>
                                <td colspan="2">
                                    <input type="submit" value="LogIn"/>
                                </td>
                            </tr>
                        </table>
                    </form>
                </div>
            </div>
            
        </div>
        
        <div class="footer"> 
        
        </div>
</html>