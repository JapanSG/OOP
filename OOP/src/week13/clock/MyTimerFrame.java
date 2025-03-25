/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week13.clock;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author japan
 */
public class MyTimerFrame{
    JFrame frame;
    MyTimer timer;
    Thread t;
    
    public MyTimerFrame(){
        frame = new JFrame("Timer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        timer = new MyTimer();
        timer.setPreferredSize(new Dimension(300,200));
        frame.addMouseListener(new MouseHandler(this));
        frame.add(timer, BorderLayout.CENTER);
        
        t = new Thread(timer);
        frame.pack();
        frame.setVisible(true);
        t.start();
    }
    
    public static void main(String[] args) {
        MyTimerFrame a = new MyTimerFrame();
    }
}

class MouseHandler extends MouseAdapter{
    MyTimerFrame timer;
    public MouseHandler(MyTimerFrame timer){
        this.timer = timer;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (timer.timer.p.isPause){
            timer.timer.unpause();
        }
        else{
            timer.timer.pause();
        }
    }
}
