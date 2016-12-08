package toba.business;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import toba.business.Account;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-07T13:00:16")
@StaticMetamodel(Transfer.class)
public class Transfer_ { 

    public static volatile SingularAttribute<Transfer, Account> toAcct;
    public static volatile SingularAttribute<Transfer, Double> endBal;
    public static volatile SingularAttribute<Transfer, Double> amt;
    public static volatile SingularAttribute<Transfer, String> fromAcct;
    public static volatile SingularAttribute<Transfer, Long> tran;

}