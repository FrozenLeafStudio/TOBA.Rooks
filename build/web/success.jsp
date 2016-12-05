<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/header.html"/>
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

    
<c:import url="/footer.jsp"/>
