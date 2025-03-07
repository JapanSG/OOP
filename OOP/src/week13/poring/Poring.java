/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week13.poring;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author japan
 */
public class Poring extends Thread{
    JFrame frame;
    JLabel poring, num;
    PoringConstructor master;
    Random rand = new Random();
    
    public Poring(PoringConstructor master){
        this.master = master;
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        frame.setResizable(false);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        int x = rand.nextInt(d.width-100);
        int y = rand.nextInt(d.height-100);
        frame.setLocation(x,y);
        
        ImageIcon icon = new ImageIcon("poring.png");
        icon = new ImageIcon(icon.getImage().getScaledInstance(100,100, Image.SCALE_SMOOTH));
        poring = new JLabel(icon);
        poring.addMouseListener(new OnClick(this));
        frame.add(poring);

        num = new JLabel(master.getNum()+"");
        frame.add(num);
        frame.pack();
        frame.setVisible(true);
        
        master.updatePoring();
    }
    
    public void updateNum(){
        num.setText(master.getNum()+"");
    }
    
    @Override
    public void run(){
        while (frame.isVisible()){
            updateNum();
            Point p = frame.getLocation();
            p.x = rand.nextInt(p.x-1,p.x+2);
            p.y = rand.nextInt(p.y-1,p.y+2);
            frame.setLocation(p);
            try {
                TimeUnit.MILLISECONDS.sleep(10);
            } catch (InterruptedException ex) {
                Logger.getLogger(Poring.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

class OnClick extends MouseAdapter {
    Poring p;
    
    public OnClick(Poring p){
        this.p = p;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        p.frame.dispose();
        p.master.list.remove(p);
        p.master.updatePoring();
    }
    
    @Override
    public void mousePressed(MouseEvent e) {
        p.frame.dispose();
        p.master.list.remove(p);
        p.master.updatePoring();
    }  
    
}
