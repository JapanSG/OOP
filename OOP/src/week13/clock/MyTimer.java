/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week13.clock;

import javax.swing.*;
import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author japan
 */
public class MyTimer extends JLabel implements Runnable{
    int hour;
    int min;
    int sec;
    boolean pause = false;
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
    
    public void pause(){
        setBackground(Color.RED);
        setForeground(Color.WHITE);
        p.stop();
    }
    
    public void unpause(){
        p.con();
        setForeground(Color.BLACK);
        setBackground(Color.WHITE);
    }
    
    @Override
    public void run() {
        while(true){
            try {
                setText(String.format("%02d:%02d:%02d", hour,min,sec));
                Thread.sleep(1000);
                System.out.println(sec);
                increment();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}
class PauseTimer{
    
    boolean isPause;
    
    public synchronized void con(){
        if (isPause){
            this.notify();
            isPause = false;
        }
    }
    
    public synchronized void check(){
        if (isPause){
            try {
                wait();
            }
            catch (InterruptedException ex) {
                Logger.getLogger(PauseTimer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public synchronized void stop(){
        isPause = true;
        try {
                wait();
            }
            catch (InterruptedException ex) {
                Logger.getLogger(PauseTimer.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
}
