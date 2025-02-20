/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week06;

/**
 *
 * @author japan
 */
public class Seller extends Employee{
    public Food sell(Employee e){
        Food food = new Food();
        Wallet w = e.getWallet();
        if (w.getBalance() >= food.getPrice()){
            getWallet().setBalance(food.getPrice() + getWallet().getBalance());
            w.setBalance(w.getBalance()-food.getPrice());
            return food;
        }
        else{
            System.out.println("Your money is not enough.");
            return null;
        }
    }
}
