<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/header.html"/>
    <div>
        <p>${message}</p>
        <form name="loginForm" method="post" action="LoginServlet">
            Username:<br>
            <input type="text" name="username"><br>
            Password:<br>
            <input type="text" name="password"><br>
            <input name ="action" type="hidden" value="login">
            <input type="submit" value="Login">
        </form>
        <a href="new_customer.jsp">New Customer Sign up</a>
        <br>
        <a href="password_reset.jsp">Reset Password</a>
    </div>
<c:import url="/footer.jsp"/>
