<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/header.html"/>

        <p><i>${message}</i></p>
        <div>
                <form name="newUser" method="post" action="newCustomer">
                
                First name:<br>
                <input type="text" name="firstname"><br>
                Last name:<br>
                <input type="text" name="lastname"><br>
                Phone:<br>
                <input type="text" name="phone"><br>
                Address:<br>
                <input type="text" name="address"><br>
                City:<br>
                <input type="text" name="city"><br>
                State:<br>
                <input type="text" name="state"><br>
                Zip Code:<br>
                <input type="text" name="zip"><br>
                Email:<br>
                <input type="text" name="email"><br>
                <input type="submit" value="new customer">
            </form>
        </div>
<c:import url="/footer.jsp"/>