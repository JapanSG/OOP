/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week14.books;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author japan
 */
public class BookAdd {
    JFrame frame;
    JLabel name,price,type;
    JTextField namef, pricef;
    JComboBox<String> typef;
    JPanel center, south;
    JButton insert;
    public BookAdd(ActionListener c){
        frame = new JFrame("Book view");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,300);

        center = new JPanel();
        center.setBorder(BorderFactory.createEmptyBorder(0,10,0,0));
        center.setLayout(new GridLayout(3, 2));
        center.setPreferredSize(new Dimension(300,70));
        
        name = new JLabel("Name");
        price = new JLabel("Price");
        type = new JLabel("Type");
        namef = new JTextField();
        pricef = new JTextField();
        typef = new JComboBox(new String[]{"General", "Computer", "Math&Sci", "Photo"});
        center.add(name);
        center.add(namef);
        center.add(price);
        center.add(pricef);
        center.add(type);
        center.add(typef);
        frame.add(center,BorderLayout.NORTH);
        //south
        south = new JPanel();
        insert = new JButton("Insert");
        south.add(insert);
        frame.add(south,BorderLayout.SOUTH);
        frame.pack();
        frame.setVisible(true);
        
        insert.addActionListener(c);
    }
}
