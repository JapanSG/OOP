/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week13.clock;

import javax.swing.*;
import java.awt.*;
import java.util.Calendar;
/**
 *
 * @author japan
 */
public class MyClock extends JLabel implements Runnable{

    public MyClock() {
        setHorizontalAlignment(CENTER);
        Font a = new Font("Arial", Font.BOLD, 40);
        setFont(a);
        
    }

    @Override
    public void run() {
        while(true){
            try {
                Calendar d = Calendar.getInstance();
                int sec = d.get(Calendar.SECOND);
                int min = d.get(Calendar.MINUTE);
                int hour = d.get(Calendar.HOUR_OF_DAY);
                setText(String.format("%02d:%02d:%02d", hour,min,sec));
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
    
}
