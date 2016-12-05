package toba.business;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import toba.business.Account;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-05T09:59:02")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile SingularAttribute<User, String> zip;
    public static volatile SingularAttribute<User, String> fname;
    public static volatile SingularAttribute<User, String> lname;
    public static volatile SingularAttribute<User, String> password;
    public static volatile SingularAttribute<User, String> phone;
    public static volatile SingularAttribute<User, String> addy;
    public static volatile SingularAttribute<User, String> city;
    public static volatile SingularAttribute<User, String> state;
    public static volatile SingularAttribute<User, Account> accounts;
    public static volatile SingularAttribute<User, Long> userid;
    public static volatile SingularAttribute<User, String> email;
    public static volatile SingularAttribute<User, String> username;

}