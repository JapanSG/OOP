package week11.bank;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author japan
 */
public class Main {
    public static void main(String[] args) {
        Bank myBank = new Bank();
        Account acc1 = new Account(5000, "Sommai");
        Account acc2 = new Account(3000, "Somchai");
        Account acc3 = new Account(900, "Somsri");
        myBank.addAccount(acc1);
        myBank.addAccount(acc2);
        myBank.addAccount(acc3);

        System.out.println("Number of Account: " + myBank.getNumAccount());
        myBank.getAccount(0).showAccount();
        System.out.println("Deposit 500...");
        myBank.getAccount(0).deposit(500);
        myBank.getAccount(0).showAccount();
        System.out.println("Show all accounts");
        System.out.println("==============================");
        for(int i=0; i<myBank.getNumAccount(); i++){
        myBank.getAccount(i).showAccount();
 }

    }
    
}
