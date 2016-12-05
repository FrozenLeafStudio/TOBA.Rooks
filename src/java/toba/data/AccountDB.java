
package toba.data;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import toba.business.Account;
import toba.business.User;

public class AccountDB {
    public static void insert(Account acct){
        EntityManager ent = DBtool.getEmFactory().createEntityManager();
        EntityTransaction tran = ent.getTransaction();
        tran.begin();
        try{
            ent.persist(acct);
            tran.commit();
        }catch(Exception e){
            System.out.println(e);
            tran.rollback();
        }finally{
            ent.close();
        }
        
    }
    public static void update(Account acct){
        EntityManager ent = DBtool.getEmFactory().createEntityManager();
        EntityTransaction tran = ent.getTransaction();
        tran.begin();
        try{
            ent.merge(acct);
            tran.commit();
        }catch(Exception e){
            System.out.println(e);
            tran.rollback();
        }finally{
            ent.close();
        }
    }
        public static List selectAccount(User userid){
        EntityManager ent = DBtool.getEmFactory().createEntityManager();
        String qString = "SELECT u.acctID FROM Account u " +
                "WHERE u.acctOwner = :acctOwner";
        TypedQuery<Account> q = ent.createQuery(qString, Account.class);
        q.setParameter("acctOwner", userid);
        try {
            List qAcct = q.getResultList();
            if(!qAcct.isEmpty()){
                qString = "SELECT u FROM Account u " +
                "WHERE u.acctOwner = :acctOwner";
                TypedQuery<Account> l = ent.createQuery(qString, Account.class);
                l.setParameter("acctOwner", userid);
                qAcct = l.getResultList();
            }
            return qAcct;
        }finally {
            ent.close();
        }
    }


    static boolean checkBalance(User userid) {
        List u = selectAccount(userid);
        return u != null;
    }
}
