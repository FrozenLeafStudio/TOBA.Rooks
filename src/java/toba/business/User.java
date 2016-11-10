package toba.business;

import java.beans.*;
import java.io.Serializable;


public class User implements Serializable {
    
    private String fname;  
    private String lname;
    private String phone;
    private String addy;
    private String city;
    private String state; 
    private String zip;
    private String email;
    private String username;
    private String password;
    
    public User(){
        fname = "";
        lname = "";
        phone = "";
        addy = "";
        city = "";
        state = "";
        zip = "";
        email = "";
        username = "";
        password = "";
    }
    
    public User(String fname, String lname, String phone, String addy,
            String city, String state, String zip, String email,
            String username, String password){
        this.fname = fname;
        this.lname = lname;
        this.phone = phone;
        this.addy = addy;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.email = email;
        this.username = username;
        this.password = password;
    }
    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddy() {
        return addy;
    }

    public void setAddy(String addy) {
        this.addy = addy;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }    
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
