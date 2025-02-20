/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week06;

/**
 *
 * @author japan
 */
public class Programmer extends Employee{
    private int happiness;
    
    public void coding(String str){
        if (getEnergy() >= 30){
            System.out.println("Your code is " + str);
        }
        else{
            System.out.println("Error Error Error");
        }
        setEnergy(getEnergy() - 30);
        setHappiness(getHappiness() - 30);
    }
    
    public void coding(char str){
        if (this instanceof SeniorProgrammer){
            if (getEnergy() >= 10){
                System.out.println("I'm coding about " + str);
            }
            else{
                System.out.println("ZzZzZz");
            }
            setEnergy(getEnergy() - 5);
            setHappiness(getHappiness() - 5);
        }
        else{
            if (getEnergy() >= 30){
                System.out.println("Your code is " + str);
            }
            else{
                System.out.println("Error Error Error");
            }
            setEnergy(getEnergy() - 30);
            setHappiness(getHappiness() - 30);
        }
    }

    public int getHappiness() {
        return happiness;
    }

    public void setHappiness(int happiness) {
        this.happiness = happiness;
    }
}
