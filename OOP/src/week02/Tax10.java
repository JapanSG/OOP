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
public class Tax10 {
    public static void tax10() {
        System.out.print("Input your salary : ");
        Scanner sc = new Scanner(System.in);
        double salary = sc.nextDouble();
        double tax;
        if (salary > 50000.00){
            tax = salary*0.1;
        }
        else{
            tax = salary*0.05;
        }
        System.out.println("Tax = "+tax);
        sc.close();
    }
    
}
