package week03;


import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author japan
 */
public class LineAndNewLine12 {
    public static void main(String[] args) {
        System.out.print("Please insert a number : ");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        for (int i = 1; i < num+1; i++){
            if (i%5 == 0){
                System.out.println("|");
            }
            else{
                System.out.print("|");
            }
        }
        System.out.println("");
    }
}
