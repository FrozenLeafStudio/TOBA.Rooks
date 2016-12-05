<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : account_activity
    Created on : Nov 10, 2016, 12:53:51 AM
    Author     : stephen
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/header.html"/>
<div id="accountpg">
    
<h1>Account Activity</h1>
        
        <div>
            <table border="1" width="450px" cellspacing="15" cellpadding="15">
                <thead>
                    <tr>
                        <th>Account ID</th>
                        <th>Account Type</th>
                        <th>Account Balance</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>${Savings.acctID}</td>
                        <td>${Savings.acctType}</td>
                        <td>${Savings.acctBal}</td>

                    </tr>
                    <tr>

                        <td>${Checkings.acctID}</td>
                        <td>${Checkings.acctType}</td>
                        <td>${Checkings.acctBal}</td>
                    </tr>
                </tbody>
            </table>
        </div>
                    <div id="Tran">
                <h2 id="Transactions">Transfer transactions</h2>
                <div id="Savings">
                    <table border="1" width="450" cellspacing="15" cellpadding="15">
                        <thead>
                            <tr>

                                <td>Transfer Amount</td>
                                <td>Transfered From</td>
                                <td>Transfered To</td>
                                <td>End Balance</td>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${Savings.transfers}" var="val">
                                <tr>
                                    <td>${val.amt}</td>
                                    <td>${val.fromAcct}</td>
                                    <td>${val.toAcct.acctType}</td>
                                    <td>${val.endBal}</td>
                                </tr>
                            </c:forEach>
                        </tbody>

                    </table>
                </div>
                <div id="Checkings">
                    <table border="1" width="450" cellspacing="15" cellpadding="15">
                        <thead>
                            <tr>

                                <td>Transfer Amount</td>
                                <td>Transfered From</td>
                                <td>Transfered To</td>
                                <td>End Balance</td>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${Checkings.transfers}" var="val">
                                <tr>
                                    <td>${val.amt}</td>
                                    <td>${val.fromAcct}</td>
                                    <td>${val.toAcct.acctType}</td>
                                    <td>${val.endBal}</td>
                                </tr>

                            </c:forEach>
                        </tbody>

                    </table>
                </div>
            </div>
</div>  
<c:import url="/footer.jsp"/>