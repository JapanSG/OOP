/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week11.collectionapi;

import java.util.ArrayList;
/**
 *
 * @author japan
 */
public class Customer {
    private String firstName;
    private String lastName;
    private ArrayList acct;
    private int numOfAccount; 

    public Customer(){ 
        this("","");
    }

    public Customer(String firstName, String lastName){
        setFirstName(firstName);
        setLastName(lastName);
        acct = new ArrayList();
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
        return acct.size();
    }
    
    public void addAccount(Account acct){
        this.acct.add(acct);
        numOfAccount++;
    }
    
    public Account getAccount(int index) {
        return (Account)acct.get(index);
    }

    @Override
    public String toString(){
        return String.format("%s %s %d", getFirstName(), getLastName(), getNumOfAccount());
    }
    
    public boolean equals(Customer c){
        return getFirstName().equals(c.getFirstName()) && getLastName().equals(c.getLastName());
    }
}

