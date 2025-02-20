/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week05.Vehicle4;

/**
 *
 * @author japan
 */
public class Vehicle {
    private int fuel;
    private String topSpeed;    

    protected int getFuel() {
        return fuel;
    }

    protected void setFuel(int i) {
        fuel = i;
    }

    protected String getTopSpeed() {
        return topSpeed;
    }

    protected void setTopSpeed(String n) {
        topSpeed = n;
    }
    
    public void showInfo() {
        String message = "Fuel is %d litre and Top Speed is %s m/s.";
        System.out.println(String.format(message, fuel, topSpeed));
    }
}
