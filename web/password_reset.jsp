
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/header.html"/>
        <h1>Password Reset</h1>
        <p>Update your password below.</p>
        
        <form action="resetPw" method="post">
            <input type="hidden" name="action" value="resetpw">
            <input type="text" name="resetPw" value="${user.password}">
            <input type="submit" name="resetButton" value="Reset">
            
            
        </form>
<c:import url="/footer.jsp"/>
