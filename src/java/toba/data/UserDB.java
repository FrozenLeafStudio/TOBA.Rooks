
package toba.data;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import toba.business.User;
import javax.persistence.TypedQuery;


public class UserDB {
    public static void insert(User user){
        EntityManager ent = DBtool.getEmFactory().createEntityManager();
        EntityTransaction tran = ent.getTransaction();
        tran.begin();
        try{
            ent.persist(user);
            tran.commit();
        }catch(Exception e){
            System.out.println(e);
            tran.rollback();
        }finally{
            ent.close();
        }
    }
    
    public static void update(User user){
        EntityManager ent = DBtool.getEmFactory().createEntityManager();
        EntityTransaction tran = ent.getTransaction();
        tran.begin();
        try{
            ent.merge(user);
            tran.commit();
        }catch(Exception e){
            System.out.println(e);
            tran.rollback();
        }finally{
            ent.close();
        }
    }
    public static User selectUser(String username){
        EntityManager ent = DBtool.getEmFactory().createEntityManager();
        String qString = "SELECT u FROM User u " +
                "WHERE u.username = :username";
        TypedQuery<User> q = ent.createQuery(qString, User.class);
        q.setParameter("username", username);
        try {
            List qUser = q.getResultList();
            User foundUser = null;
            if(!qUser.isEmpty()){
                foundUser = (User) qUser.get(0);
            }
            return foundUser;
        }finally {
            ent.close();
        }
    }
    public static boolean userExisted(String email){
        User u = selectUser(email);
        return u != null;
    }
}
