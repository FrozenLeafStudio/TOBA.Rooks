
package toba.data;


import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DBtool {
    private static final EntityManagerFactory efact = Persistence.createEntityManagerFactory("TobaPU");
    
    public static EntityManagerFactory getEmFactory(){
        return efact;
    }
    
}
