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

public class Saving11 {

    public static void saving11() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input your money : ");
        double money = sc.nextDouble();
        System.out.print("Input your account type(Please type A B C or X in uppercase : ");
        char type = sc.next().charAt(0);
        System.out.print("Your money in one year = ");
        switch (type){
            case 'A' -> System.out.println(Math.round(money * 1.015));
            case 'B' -> System.out.println(Math.round(money * 1.02));
            case 'C' -> System.out.println(Math.round(money * 1.015));
            case 'X' -> System.out.println(Math.round(money * 1.05));
            default -> System.out.println("Wrong Input");
        }
        sc.close();
    }
}
