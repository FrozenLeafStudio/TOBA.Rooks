<%-- 
    Document   : success
    Created on : Nov 6, 2016, 7:23:19 PM
    Author     : stephen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Successful Login</title>
    </head>
    <body>
        <h1>Successful Login!</h1>
        <h3>Welcome ${user.fname}</h3>
        <p>Please verify your information:</p>
        <p>Last Name: ${user.lname}</p>
        <p>Phone#: ${user.phone}</p>
        <p>Address: ${user.addy}</p>
        <p>City: ${user.city}</p>
        <p>State: ${user.state}</p>
        <p>Zip Code: ${user.zip}</p>
        <p>Email Address: ${user.email}</p>
        
        <p>if the information is correct then you username and password will be listed below.</p>
        <p><b>USERNAME:</b> ${user.username}</p>
        <p><b>PASSWORD:</b> ${user.password}</p>

    </body>
</html>
