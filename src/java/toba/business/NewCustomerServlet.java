
package toba.business;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NewCustomerServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String url = "/new_customer.html";
        String message = "";
        try(PrintWriter write = response.getWriter()) {
            String fname = request.getParameter("firstname");
            String lname = request.getParameter("lastname");
            String phone = request.getParameter("phone");
            String addy = request.getParameter("address");
            String city = request.getParameter("city");
            String state = request.getParameter("state");
            String zip = request.getParameter("zip");
            String email = request.getParameter("email");
            String username = lname+zip;
            String password = "welcome1";
            
            User user = new User(fname, lname, phone, addy, city,
                            state, zip, email, username, password);
            
            if( fname == null || lname == null || phone == null || addy == null || 
                    city == null || state == null || zip == null || email == null ||
                    fname.isEmpty() || lname.isEmpty() || phone.isEmpty() || addy.isEmpty() ||
                    city.isEmpty() || state.isEmpty() || zip.isEmpty() || email.isEmpty()){
                message = "<html> <h3>Please fill out every field.</h3></html>";
                write.println(message);
                url = "/new_customer.html";
                request.getRequestDispatcher(url).include(request, response);
                /*getServletContext()
                .getRequestDispatcher(url).include(request, response);*/

            }else{
                url = "/success.jsp";
                request.setAttribute("user", user);
                request.getRequestDispatcher(url).forward(request, response);
            }
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);

    }
}
