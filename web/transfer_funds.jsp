<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/header.html"/>
<form action="TransactionServlet" method="post">
    <fieldset style="border: 0;">
        <table border="3" width="600" cellspacing="30" cellpadding="50">
            <thead>
                <tr>
                    <th></th>
                    <th>Checkings</th>
                    <th>Savings</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>Balance Remaining</td>
                    <td><h3>$ ${Checkings.acctBal}</h3></td>
                    <td><h3>$ ${Savings.acctBal}</h3></td>
                </tr>
                <tr>
                    <td>Money Transfer</td>
                    <td>
                        <p style="margin: 0px">From</p>
                        <input style="clear: both; position: relative; overflow: visible; height: 15px; width: 15px;" required="true" type="radio" name="selected" value="rdCheck">
                        <br>
                        <input placeholder="${Checkings.acctBal}" type="text" name="checkings" >
                    </td>
                    <td>
                        <p style="margin: 0px">From</p>
                        <input style="clear: both; position: relative; overflow: visible; height: 15px; width: 15px;" required="true" type="radio" name="selected" value="rdSave">
                        <br>
                        <input placeholder="${Savings.acctBal}" type="text" name="savings" ></td>
                </tr>
            </tbody>
        </table>
        <input type="submit" name="Transfer" value="Submit Transfer">
            
    </fieldset>
</form>
    
<c:import url="/footer.jsp"/>
