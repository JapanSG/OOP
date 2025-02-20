package week04;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author japan
 */
public class Student {
    public String name;
    public double mScore;
    public  double fScore;
    public void showGrade(){
        double s = (mScore*0.4)+(fScore*0.4)+20;
        char grade;
        if (s >= 80){
            grade = 'A';
        }
        else if (s >= 70){
            grade = 'B';
        }
        else if (s >= 60){
            grade = 'C';
        }
        else if (s >= 50){
            grade = 'D';
        }
        else{
            grade = 'F';
        }
        System.out.println("Your grade is "+ grade);
    }
}
