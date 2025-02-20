package week03;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author japan
 */
import java.util.Scanner;
public class LineAndSlash11 {
    public static void main(String[] args) {
        System.out.print("Please insert a number : ");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        for (int i = 1; i < num+1; i++){
            if (i%5 == 0){
                System.out.print("/");
            }
            else{
                System.out.print("|");
            }
        }
        System.out.println("");
    }
}
