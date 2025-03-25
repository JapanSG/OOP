/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prefinal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author japan
 */
public class AddItem extends JFrame{
    ItemFieldPanel center;
    JButton insert;
    
    public AddItem(App app){
        this.setDefaultCloseOperation(3);
        this.setSize(300,200);
        center = new ItemFieldPanel();
        insert = new JButton("Insert Items");
        JPanel south = new JPanel();
        south.add(insert);
        add(center, BorderLayout.CENTER);
        add(south, BorderLayout.SOUTH);
        
        this.setVisible(true);

        insert.addActionListener(app);
    }
}
