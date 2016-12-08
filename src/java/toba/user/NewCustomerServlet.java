
package toba.user;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import toba.business.Account;
import toba.business.User;
import toba.data.AccountDB;
import toba.data.PasswordUtil;
import toba.data.UserDB;

public class NewCustomerServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String url = "/new_customer.jsp";
        String message = "";
        HttpSession session = request.getSession();
        Account acct = null;
        
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

        User user = new User();
        user.setFname(fname);
        user.setLname(lname);
        user.setPhone(phone);
        user.setAddy(addy);
        user.setCity(city);
        user.setState(state);
        user.setZip(zip);
        user.setEmail(email);
        user.setUsername(username);
        user.setPassword(password);
        List saltNpass = new ArrayList();
        
        if( fname == null || lname == null || phone == null || addy == null || 
                city == null || state == null || zip == null || email == null ||
                fname.isEmpty() || lname.isEmpty() || phone.isEmpty() || addy.isEmpty() ||
                city.isEmpty() || state.isEmpty() || zip.isEmpty() || email.isEmpty()){
            message = "Please fill out every field.";
            url = "/new_customer.jsp";
            request.setAttribute("message", message);
            /*getServletContext()
            .getRequestDispatcher(url).include(request, response);*/

        }else if(UserDB.userExisted(user.getEmail())){
            message="Your information is already on file.<br>"+
                    "Please enter different information to create new account";
            url="/new_customer.jsp";
            request.setAttribute("message",message);
        }else{
            try{
                saltNpass = PasswordUtil.hashAndSaltPassword(user.getPassword());
                
            }catch(NoSuchAlgorithmException ex){
                System.out.print(ex);
            }
            for(int e = 0; e<saltNpass.size(); e++ ){
            if(e==0){
                user.setSalt((String) saltNpass.get(e));
            }
            else{
                user.setPassword((String) saltNpass.get(e));
            }
        }
            url = "/success.jsp";
            Account sAcct = new Account(user, 25.0, "Savings");
            Account cAcct = new Account(user,0.0, "Checkings");
            UserDB.insert(user);
            AccountDB.insert(cAcct);
            AccountDB.insert(sAcct);
            sAcct.getAcctID();
            cAcct.getAcctID();
            
            session.setAttribute("Savings", sAcct);
            session.setAttribute("Checkings", cAcct);
            session.setAttribute("user", user);
           
        }
        request.getRequestDispatcher(url).forward(request, response);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);

    }
}
