/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week13.clock;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author japan
 */
public class MyTimer extends JLabel implements Runnable{
    int hour;
    int min;
    int sec;
    PauseTimer p = new PauseTimer();
    public MyTimer() {
        setHorizontalAlignment(CENTER);
        Font a = new Font("Arial", Font.BOLD, 40);
        setFont(a);
        setOpaque(true);
        setBackground(Color.WHITE);
    }
    
    public void increment(){
        sec++;
        if (sec == 60){
            sec = 0;
            min++;
        }
        if (min == 60){
            min = 0;
            hour++;
        }
    }
    @Override
    public void run() {
        while(true){
            try {
                p.check();
                setText(String.format("%02d:%02d:%02d", hour,min,sec));
                p.check();
                Thread.sleep(1000);
                p.check();
                increment();
                p.check();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}
class PauseTimer{
    
    boolean isPause;
    public synchronized void check(){
        if (isPause){
            try {
                wait();
            } 
            catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public synchronized void con(){
        if (isPause){
            notify();
            isPause = false;
        }
    }
    
    public synchronized void stop(){
        isPause = true;
    }
}
