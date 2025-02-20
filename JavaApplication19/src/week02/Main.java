package week02;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author japan
 */
import java.util.function.Supplier;
public class Main {
    public static void main(String[] args) {
        Supplier<Integer> a = () -> {Salary12.salary12(); return null;};
        Supplier<Integer> b = () -> {Saving11.saving11(); return null;};
        Supplier<Integer> c = () -> {Tax10.tax10(); return null;};
        run(a);
    }
    
    static void run(Supplier<Integer> func){
        func.get();
    }
}
