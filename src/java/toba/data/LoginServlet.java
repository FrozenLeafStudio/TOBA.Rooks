
package toba.data;

import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import toba.business.User;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String action = request.getParameter("action");
        String url = null;
        RequestDispatcher rd;
        HttpSession session = request.getSession();
        if(action.equals("login")){
        
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String fname = " ";
            String lname = " ";
            
            if(username.equals("jsmith@toba.com") && password.equals("letmein")){
                fname = "User";
                lname = "Name";
                url="/account_activity.jsp";
            }else{
                url="/login_failure.jsp";
            }
            
            User user = new User(fname, lname, null, null, null,
                            null, null, null, username, password);
            session.setAttribute("user", user);
            rd = getServletContext().getRequestDispatcher(url);
            rd.forward(request, response);
        }else if(action.equals("resetpw")){
            
            User user = (User) session.getAttribute("password");
            String password = request.getParameter("resetPw");
            session.setAttribute("password", user);
            url = "/account_activity.jsp";
            rd = getServletContext().getRequestDispatcher(url);
            rd.forward(request, response);
        }
    }

}
