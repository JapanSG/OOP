/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week07.customer;

/**
 *
 * @author japan
 */
public class CheckingAccount extends Account{
    private double credit;
    public CheckingAccount(){
        super(0,"");
        setCredit(0);
    }
    
    public CheckingAccount(double balance, String name, double credit){
        super(balance, name);
        this.credit = credit;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        if  (credit >= 0){
            this.credit = credit; 
        }
        else{
            System.out.println("Input number must be a positive integer.");
        }
    }
    
    @Override
    public void withdraw(double a){
        if (a <= 0){
            System.out.println("Input number must be a positive integer.");
            return;
        }
        if (balance > a){
            setBalance(getBalance() - a);
            System.out.println(a + " baht is withdrawn from " + getName() + " and your credit balance is " + getCredit() + ".");
        }
        else if (balance < a && getCredit() + getBalance() >= a){
            double debt = a - getBalance();
            setBalance(0);
            setCredit(getCredit() - debt);
            System.out.println(a + " baht is withdrawn from " + getName() + " and your credit balance is " + getCredit() + ".");
        }
        else{
            System.out.println("Not enough money!");
        }
    }
    public void withdraw(String a){
        withdraw(Double.parseDouble(a));
    }
    
    @Override
    public String toString(){
        return "The "+ getName() +" account has "+ getBalance() + " baht and "+ getCredit() +" credits.";
    }
    
    
    
}
