<%-- 
    Document   : account_activity
    Created on : Nov 10, 2016, 12:53:51 AM
    Author     : stephen
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/header.html"/>
        <h1>Account Activity</h1>
        
        <c:if test="${user != null}">
            <p>Welcome ${user.fname} ${user.lname}</p>
        </c:if>
            
<c:import url="/footer.jsp"/>