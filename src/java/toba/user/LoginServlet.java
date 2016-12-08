
package toba.user;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import toba.business.User;
import toba.data.PasswordUtil;
import toba.data.UserDB;

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
        String message = null;
        RequestDispatcher rd;
        HttpSession session = request.getSession();
        User user;
        if(action.equals("login")){
        
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            //validates login attempt & set initiates user for session use
            user = attemptLogin(username, password);
            if(user != null){
                session.setAttribute("user", user);
                url="/account_activity.jsp";
            } else{
                message = "Incorrect Username Or Password. Please login again or create a new account";
                url="/login.jsp";
                
            }
            request.setAttribute("message", message);
            rd = getServletContext().getRequestDispatcher(url);
            rd.forward(request, response);
        }else if(action.equals("resetpw")){
            
            
            String password = request.getParameter("resetPw");
            user = (User) session.getAttribute("user");
            user.setPassword(password);
            UserDB.update(user);
            url = "/account_activity.jsp";
            rd = getServletContext().getRequestDispatcher(url);
            rd.forward(request, response);
        }
    }
    private User attemptLogin(String u, String p){
        String username = u;
        String password = p;

        User user;
        if(chkUser(username) == true){
            user = UserDB.selectUser(username);
            String salt = user.getSalt();
            try{
                password = PasswordUtil.hashPassword(password+salt);
                
            }catch(NoSuchAlgorithmException ex){
                System.out.print(ex);
            }
            if(user.getPassword().equals(password)){
                return user;
            }else{
                user = null;
            }
            
        }else{
            user = null;
        }
        return user;
    }

    private boolean chkUser(String username) {
        boolean valid = UserDB.userExisted(username);
        return valid;
    }

}
