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
public class BookView extends WindowAdapter{
    JFrame frame;
    JLabel name,price,type;
    JTextField namef, pricef, pagenum;
    JComboBox<String> typef;
    JPanel center, south;
    JButton add, update, delete, left, right;
    Controller c;
    
    public BookView(){
        c = new Controller(this);
        frame = new JFrame("Book view");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.addWindowListener(c);
        frame.setSize(300,300);
        //center
        center = new JPanel();
        center.setBorder(BorderFactory.createEmptyBorder(0,10,0,0));
        center.setLayout(new GridLayout(3, 2));
        center.setPreferredSize(new Dimension(200,100));
        
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
        
        left = new JButton("<<<");
        pagenum = new JTextField("0");
        pagenum.setPreferredSize(new Dimension(50,20));
        right = new JButton(">>>");
        add = new JButton("Add");
        update = new JButton("Update");
        delete = new JButton("Delete");
        JPanel s1 = new JPanel();
        s1.add(left);
        s1.add(pagenum);
        s1.add(right);
        JPanel s2 = new JPanel();
        s2.add(add);
        s2.add(update);
        s2.add(delete);
        south.setLayout(new GridLayout(2,1));
        south.add(s1);
        south.add(s2);
        south.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        frame.add(south, BorderLayout.SOUTH);

        add.addActionListener(c);
        update.addActionListener(c);
        delete.addActionListener(c);
        left.addActionListener(c);
        right.addActionListener(c);

        frame.pack();
        frame.setVisible(true);
    }
    
    public static void main(String[] args) {
        new BookView();
    }
}
