package week02;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author japan
 */
import java.util.Scanner;
public class Salary12 {

    public static void salary12() {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Please insert your name : ");
            String name = sc.nextLine();
            int age = (int)inputDouble(sc, "Please insert your age : ");
            int wDay = (int)inputDouble(sc, "Please insert number of working days : ");
            int aDay = (int)inputDouble(sc, "Please insert number of absent days : ");
            double weight = inputDouble(sc, "Please insert your weight : ");
            double salary;
            
            if (51 <= age && age <= 60){
                salary = wDay * 3000;
            }
            else if (age >= 41){
                salary = wDay * 1000 - aDay * 25;
            }
            else if (age >= 31){
                salary = wDay * 500 - aDay * 50;
            }
            else {
                salary = wDay * 300 - aDay * 50;
            }

            System.out.println("Hi, "+ name);
            System.out.println("Your salary is " + Math.round(salary) + " Baht");
            
            if (weight >= 10 && weight <= 60){
                salary += 5000;
            }
            else if (weight >= 60 && weight <= 90){
                salary += (5000-((weight - 60) * 10));
            }
            System.out.println("Your salary and bonus is " + Math.round(salary) + " Baht");
        }
    }
    
    static double inputDouble(Scanner sc, String message){
        System.out.print(message);
        double input = sc.nextDouble();
        return input;
    }
}
