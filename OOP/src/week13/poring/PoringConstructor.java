/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week13.poring;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
/**
 *
 * @author japan
 */
public class PoringConstructor {
    ArrayList<Poring> list = new ArrayList();
    JFrame frame;
    JButton add;

    public PoringConstructor(){
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(200,100);

        add = new JButton("add");
        frame.add(add);
        frame.setVisible(true);
        
        add.addActionListener(new AddEvent(this));
    }
    
    public void createPoring(){
        Poring poring = new Poring(this);
        list.add(poring);
        poring.start();
    }
    
    public void updatePoring(){
        for (Poring p : list){
            p.updateNum();
        }
    }
    public int getNum(){
        return list.size();
    }
    
    public static void main(String[] args) {
        new PoringConstructor();
    }
}

class AddEvent implements ActionListener{
    PoringConstructor p;
    
    public AddEvent(PoringConstructor p){
        this.p = p;
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        p.createPoring();
    }
}