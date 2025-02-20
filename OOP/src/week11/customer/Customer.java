/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week11.customer;

import week11.bank.*;

/**
 *
 * @author japan
 */
public class Customer {
    private String firstName;
    private String lastName;
    private Account[] acct;
    private int numOfAccount; 

    public Customer(){ 
        this("","");
    }

    public Customer(String firstName, String lastName){
        setFirstName(firstName);
        setLastName(lastName);
        acct = new Account[5];
    }
    
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public int getNumOfAccount(){
        return numOfAccount;
    }
    
    public void addAccount(Account acct){
        this.acct[numOfAccount] = acct;
        numOfAccount++;
    }
    
    public Account getAccount(int index) {
        return acct[index];
    }

    @Override
    public String toString(){
        return String.format("%s %s %d", getFirstName(), getLastName(), getNumOfAccount());
    }
    
    public boolean equals(Customer c){
        return getFirstName().equals(c.getFirstName()) && getLastName().equals(c.getLastName());
    }
}

