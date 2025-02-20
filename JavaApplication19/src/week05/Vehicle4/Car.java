/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week05.Vehicle4;

/**
 *
 * @author japan
 */
public class Car extends Vehicle{
    private String typeEngine;

    public String getTypeEngine() {
        return typeEngine;
    }

    public void setTypeEngine(String t) {
        typeEngine = t;
    }
    
    public void showCarInfo(){
        String message = "Car engine is %s.";
        System.out.println(String.format(message, typeEngine));
        showInfo();
    }
    
    public void setCarInfo(int s, String t, String y){
        setFuel(s);
        setTopSpeed(t);
        setTypeEngine(y);
    }
    
    public void move(){
        if (getFuel() < 50){
            System.out.println("Please add fuel.");
        }
        else {
            System.out.println("Move.");
            setFuel(getFuel()-50);
        }
    }
    
    
    
}
