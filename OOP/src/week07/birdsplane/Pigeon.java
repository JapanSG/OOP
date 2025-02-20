/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week07.birdsplane;

/**
 *
 * @author japan
 */
public class Pigeon extends Bird{
    private static int numberOfPigeon;
    public Pigeon(){
        this(0,0,0);
    }
    public Pigeon(double wingSize, double weight, double height){
        super(wingSize, weight, height);
        numberOfPigeon++;
    }
    
    public void eat(String food){
        if (food.equals("worm")){
            super.eat(0.5);
        }
        else if (food.equals("seed")){
            super.eat(0.2);
        }
        else{
            System.out.println("Pigeon can eat only worm and seed.");
        }
    }
    
    @Override
    public String toString(){
        double w = getWeight();
        double h = getHeight();
        String message = "Pigeon "+w+" kg and "+h+" cm. There are "+numberOfPigeon+" pigeons.";
        return message;
    }
    
    @Override
    public void fly(){
        if (getWeight() >= 5){
            setWeight(getWeight() - 0.25);
            System.out.println("Fly Fly");
        }
        else{
            System.out.println("I’m hungry.");
        }
    }
    
    @Override
    public void takeOff(){
        if (getWeight() >= 5){
            setWeight(getWeight() - 0.5);
            System.out.println("Take Off");
        }
        else{
            System.out.println("I’m hungry.");
        }
    }
    
    @Override
    public void landing(){
        if (getWeight() >= 5){
            setWeight(getWeight() - 0.5);
            System.out.println("Landing");
        }
        else{
            System.out.println("I’m hungry.");
        }
    }
}
