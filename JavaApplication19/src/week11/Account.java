package week11;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author japan
 */
public class Account {
    protected double balance;
    protected String name;
    
    public Account(double balance, String name){
        setBalance(balance);
        setName(name);
    }
    
    public void deposit(double a){
        if (a >= 0){
            System.out.println(a + " baht is deposited to "+ getName()+".");
            setBalance(getBalance() + a);
        }
        else{
            System.out.println("Input number must be a positive integer.");
        }
    }
    
    public void withdraw(double a){
        if (a > balance){
            System.out.println("Not enough money!");
        }
        else if (a < 0){
            System.out.println("Input number must be a positive integer.");
        }
        else{
            System.out.println(a + " baht is withdrawn from "+ getName()+".");
            setBalance(getBalance() - a);
        }
    }
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void showAccount(){
        System.out.println(getName() + " account has " + getBalance() + " baht.");
    }
}
