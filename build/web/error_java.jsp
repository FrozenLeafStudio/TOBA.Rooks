<%-- 
    Document   : error_java
    Created on : Oct 24, 2016, 5:51:41 PM
    Author     : stephen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Java Error</title>
    </head>
    <body>
        <h1>Java Error</h1>
        <p>Sorry, Java has thrown an exception.</p>
        <p>To continue, click the Back button</p>
        
        <h2>Details</h2>
        <p>Type: {pageContext.exception["class"]}</p>
        <p>Type: {pageContext.exception.message}</p>
    </body>
</html>
