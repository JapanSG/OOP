/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week07.birdsplane;

/**
 *
 * @author japan
 */
public class Ship extends Vehicle implements Floatable{
    public Ship(){
        this(0);
    }
    
    public Ship(double fuel){
        this.fuel = fuel;
    }
    
    public void move(){
        fl0at();
    }
    
    public void move(int distance){
        for (int i = 0; i < distance; i++){
            if (fuel < 50){
                System.out.println("Fuel is not enough.");
                break;
            }
            fl0at();
        }
    }
    
    @Override
    public void fl0at(){
        if (fuel >= 50){
            fuel -= 50;
            System.out.println("Ship moves");
        }
        else{
            System.out.println("Fuel is not enough.");
        }
    }
    @Override
    public void startEngine(){
        if (fuel >= 10){
            fuel -= 10;
            System.out.println("Engine starts");
        }
        else{
            System.out.println("Fuel is not enough.");
        }
    }
    
    @Override
    public void stopEngine(){
        System.out.println("Engine stops");
    }
    
    @Override
    public void honk(){
        System.out.println("Shhhhh");
    }
}
