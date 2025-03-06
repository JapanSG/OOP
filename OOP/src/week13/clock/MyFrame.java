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
public class MyFrame {
    JFrame frame;
    MyClock clock;
    Thread t;
    
    
    public MyFrame(){
        frame = new JFrame("Clock");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        clock = new MyClock();
        clock.setPreferredSize(new Dimension(300,200));
        frame.add(clock, BorderLayout.CENTER);
        
        t = new Thread(clock);
        frame.pack();
    }
    
    public void run(){
       frame.setVisible(true);
       t.start();
    }
    public static void main(String[] args) {
        MyFrame app = new MyFrame();
        app.run();
    }
}
