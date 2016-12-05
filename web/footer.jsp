<%@page import="java.util.GregorianCalendar, java.util.Calendar"%>
<%
    GregorianCalendar currentDate = new GregorianCalendar();
    int currentYear = currentDate.get(Calendar.YEAR);
    
%>
</div> 
</div> 
<label class="pure-overlay" for="pure-toggle-left" data-overlay="left"></label> 
</div>
</body>
<div id="footer">
<p>&copy; Copyright <%= currentYear %> Stephen Rooks</p>

</div>
</html>
