/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toba.business;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Transfer implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long tran;
    private double amt, endBal;
    private String fromAcct;
    
    @ManyToOne
    private Account toAcct;

    public long getTran() {
        return tran;
    }

    public void setTran(long tran) {
        this.tran = tran;
    }

    public double getAmt() {
        return amt;
    }

    public void setAmt(double amt) {
        this.amt = amt;
    }

    public String getFromAcct() {
        return fromAcct;
    }

    public void setFromAcct(String fromAcct) {
        this.fromAcct = fromAcct;
    }

    public Account getToAcct() {
        return toAcct;
    }

    public void setToAcct(Account toAcct) {
        this.toAcct = toAcct;
    }

    public Double getEndBal() {
        return endBal;
    }

    public void setEndBal(Double endBal) {
        
        this.endBal = endBal;
    }
    
    
    
}
