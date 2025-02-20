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
public class CountOddAndEven10 {
    public static void main(String[] args) {
        int num;
        int even = 0;
        int odd = 0;
        Scanner sc = new Scanner(System.in);
        while (true){
            num = sc.nextInt();
            if (num == -1){
                break;
            }
            if (num%2 == 0){
                even++;
            }
            else {
                odd++;
            }
        }
        System.out.println("Odd number = " + odd + " Even number = " + even);
    }
 }

