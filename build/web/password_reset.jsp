<%-- +
    Document   : password_reset
    Created on : Nov 9, 2016, 10:35:23 PM
    Author     : stephen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Password Reset</title>
    </head>
    <body>
        <h1>Password Reset</h1>
        <p>Update your password below.</p>
        
        <form method="post" action="loginServlet">
            <input type="hidden" value="reset">
            <input type="text" name="resetPw" value="${user.password}">
            <input type="submit" name="resetButton" value="Reset">
            
            
        </form>
    </body>
</html>
