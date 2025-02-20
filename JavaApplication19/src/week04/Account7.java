package week04;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author japan
 */
public class Account7 {
    public static void main(String[] args) {
        Customer c = new Customer();
        c.name = "Taravichet";

        MyDate dob = new MyDate();
        dob.day = 8;
        dob.month = 11;
        dob.year = 2023;

        Account acct = new Account();
        acct.name = c.name;
        acct.balance = 500;

        c.DOB = dob;
        c.acct = acct;

        System.out.println("My name is " + c.name + ".");

        c.acct.showInfo();
        c.DOB.showDate();

        c.acct.deposit(500);
        c.acct.showInfo();
        c.acct.withdraw(3000);
        c.acct.showInfo();
    }
}