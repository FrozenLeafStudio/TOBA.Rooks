package toba.business;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import toba.business.Transfer;
import toba.business.User;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-05T09:59:02")
@StaticMetamodel(Account.class)
public class Account_ { 

    public static volatile CollectionAttribute<Account, Transfer> transfers;
    public static volatile SingularAttribute<Account, String> acctType;
    public static volatile SingularAttribute<Account, Long> acctID;
    public static volatile SingularAttribute<Account, User> acctOwner;
    public static volatile SingularAttribute<Account, Double> acctBal;

}