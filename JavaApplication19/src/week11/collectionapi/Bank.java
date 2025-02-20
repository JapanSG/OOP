package week11.collectionapi;

import week11.bank.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author japan
 */
public class Bank {
    private Account[] acct;
    private int numAcct = 0;
    
    public Bank(){
        acct  = new Account[10];
    }
    
    public void addAccount(Account ac){
        acct[numAcct] = ac;
        numAcct += 1;
    }
    
    public Account getAccount(int index){
        return acct[index];
    }
    
    public int getNumAccount(){
        return numAcct;
    }
}
