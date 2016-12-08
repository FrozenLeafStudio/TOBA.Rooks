/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toba.data;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Random;

public class PasswordUtil {
    public static String hashPassword(String password) throws NoSuchAlgorithmException{
        
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(password.getBytes());
        byte[] mdArray = md.digest();
        StringBuilder ab = new StringBuilder(mdArray.length * 2);
        for(byte b : mdArray){
        int v = b & 0xff;
        if(v<16){
            ab.append('0');
        }
        ab.append(Integer.toHexString(v));
    }
        
        return ab.toString();
        
    }
    public static String getSalt(){
        Random r = new SecureRandom();
        byte[] saltyBytes = new byte[32];
        r.nextBytes(saltyBytes);
        return Base64.getEncoder().encodeToString(saltyBytes);
    }
    public static List hashAndSaltPassword(String password) throws NoSuchAlgorithmException{
        List set = new ArrayList();
        String salt = getSalt();
        set.add(salt);
        set.add(hashPassword(password+salt));
        return set;
     
    }
    
}
