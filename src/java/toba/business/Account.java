/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toba.business;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Account implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long acctID;

    public long getAcctID() {
        return acctID;
    }

    public void setAcctID(long acctID) {
        this.acctID = acctID;
    }
    
    private String acctType;
    @ManyToOne
    private User acctOwner;
    
    private Double acctBal;
    
    private Collection<Transfer> transfers;

    public Collection<Transfer> getTransfers() {
        return transfers;
    }

    public void setTransfers(Transfer trans) {
        this.transfers.add(trans);
    }

    public Account() {
    }
    
    public Account(User acctOwner, Double acctBal, String acctType){
        setAcctType(acctType);
        setAcctBal(acctBal);
        setAcctOwner(acctOwner);
        }
    
    public Double Debit(Double amt){
        Double deposit = amt;
        acctBal -= deposit;
        acctBal = round(acctBal,2);
        setAcctBal(acctBal);
        return acctBal;
    }
    
    public Double Credit(Double amt){
        Double deposit = amt;
        acctBal += deposit;
        acctBal = round(acctBal,2);
        setAcctBal(acctBal);
        return acctBal;
    }
    
    
    public String getAcctType() {
        return acctType;
    }

    public void setAcctType(String acctType) {
        this.acctType = acctType;
    }

    public Double getAcctBal() {
        return acctBal;
    }

    public void setAcctBal(Double acctBal) {
        acctBal = round(acctBal,2);
        this.acctBal = acctBal;
    }

    public User getAcctOwner() {
        return acctOwner;
    }
    public void setAcctOwner(User acctOwner) {
        this.acctOwner = acctOwner;
    }
    public double round(double val, int decimal) {
        BigDecimal dec = new BigDecimal(val);
        dec = dec.setScale(decimal,
                BigDecimal.ROUND_HALF_UP);
        return dec.doubleValue();
    }
}
