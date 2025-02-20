/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week06;

/**
 *
 * @author japan
 */
public class Employee {
    private static String nationality = "Thai";
    private String name;
    private Wallet wallet;
    private int energy;

    public static String getNationality() {
        return nationality;
    }

    public static void setNationality(String nationality) {
        Employee.nationality = nationality;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }
    
    public boolean equals(Employee e){
        return getName().equals(e.getName());
    }
    @Override
    public String toString(){
        String output = "My name is " + getName() +". \nI have " + getEnergy() + " energy left.\nI have a balance of " + getWallet().getBalance() + " baht.";
        return output;
    }
    
    public boolean buyFood(Seller s){
        Food food = s.sell(this);
        if (food == null){
            return false;
        }
        eat(food);
        return true;
    }
    
    public void eat(Food f){
        setEnergy(getEnergy() + f.getEnergy());
    }
}
