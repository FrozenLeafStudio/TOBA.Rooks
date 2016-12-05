/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toba.user;

import toba.business.Transfer;
import java.io.IOException;
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


public class TransactionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url ="/transfer_funds.jsp";
        HttpSession session = request.getSession();
        Transfer trans = new Transfer();
        String checkings = request.getParameter("checkings");
        String savings = request.getParameter("savings");
        String selected = request.getParameter("selected");
        User user = (User) session.getAttribute("user");
        Account Savings = null;
        Account Checkings = null;
        List accts = AccountDB.selectAccount(user);
        for(Iterator<Account> it = accts.listIterator(); it.hasNext();){
            Account var = it.next();
            if(var.getAcctType().equals("Checkings")){
                Checkings = var;
            }else if(var.getAcctType().equals("Savings")){
                Savings = var;
            }
        }

        double endBalC = Checkings.getAcctBal();
        double endBalS = Savings.getAcctBal();
        if(selected.equals("rdCheck")){
            //From Checkings to Savings
            double check = Double.parseDouble(checkings);
            Checkings.Debit(check);
            Savings.Credit(check);
            endBalS = check + endBalS;
            trans.setAmt(check);
            trans.setFromAcct("Checkings");
            trans.setToAcct(Savings);
            trans.setEndBal(Savings.getAcctBal());
            Savings.setTransfers(trans);
        }
        if(selected.equals("rdSave")){
            //From Savings to Checkings
            double save = Double.parseDouble(savings);
            Savings.Debit(save);
            Checkings.Credit(save);
            trans.setAmt(save);
            trans.setFromAcct("Savings");
            trans.setToAcct(Checkings);
            trans.setEndBal(Checkings.getAcctBal());
            Checkings.setTransfers(trans);
            
        }
        
        AccountDB.update(Checkings);
        AccountDB.update(Savings);
        session.setAttribute("Savings", Savings);
        session.setAttribute("Checkings",Checkings);
        request.getRequestDispatcher(url).forward(request, response);


        //      ArrayList accts = new ArrayList();
        //      accts.addAll((Collection) AccountDB.selectAccount(acct.getAcctOwner()));
        //      Iterator<String> iterator = null;
        //      iterator = accts.iterator();
        //        for (Iterator it = accts.iterator(); it.hasNext();) {
        //            Account element = (Account) it.next();
        //            if(element.getAcctType().equals("Checkings")){
        //                element.Debit(check);
        //                AccountDB.update(element);
        //                
        //            }else if(element.getAcctType().equals("Savings")){
        //                element.Credit(save);
        //                AccountDB.update(element);
        //            }
        //        }
        //Transfer(accts, checkings, savings);

      }
}