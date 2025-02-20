/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week06;

/**
 *
 * @author japan
 */
public class Food {
    final private static int energy = 10;
    static double price = 50;

    public static int getEnergy() {
        return energy;
    }

    public static double getPrice() {
        return price;
    }

    public static void setPrice(double price) {
        if (price > Food.price){
            Food.price = price;
        }
        else{
            System.out.println("Cannot update the food price.");
        }
    }
    
    
}
