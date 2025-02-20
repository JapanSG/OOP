/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week07.birdsplane;

/**
 *
 * @author japan
 */
public abstract class Vehicle implements Dieselable{
    protected double fuel;
    public Vehicle(){
        this(0);
    }
    
    public Vehicle(double fuel){
        this.fuel = fuel;
    }
    
    public void addFuel(double fuel){
        if (!(fuel > 0)){
            System.out.println("Fuel is empty.");
            return;
        }
        this.fuel += fuel;
        }
    
    public abstract void honk();

    public double getFuel() {
        return fuel;
    }

    public void setFuel(double fuel) {
        this.fuel = fuel;
    }
}
