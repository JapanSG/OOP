/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author japan
 */
public class Customer {
    private String firstName;
    private String lastName;
    private CheckingAccount acct;

    public Customer(){ this("","",null);}
    public Customer(String firstName, String lastName){
        this(firstName, lastName, null);
    }
    
    public Customer(String firstName,  String lastName, CheckingAccount acct){
        setFirstName(firstName);
        setLastName(lastName);
        setAcct(acct);
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

    public CheckingAccount getAcct() {
        return acct;
    }

    public void setAcct(CheckingAccount acct) {
        this.acct = acct;
    }
    @Override
    public String toString(){
        if (getAcct() == null){
            return getFirstName() + " " + getLastName() + " doesn’t have account.";
        }
        return "The " + getFirstName() + " account has " + getAcct().getBalance() + " baht and "+ getAcct().getCredit() +" credits.";
    }
    
    public boolean equals(Customer c){
        return getFirstName().equals(c.getFirstName()) && getLastName().equals(c.getLastName());
    }
}

