/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week14.texteditor;

import javax.swing.*;
/**
 *
 * @author japan
 */
public class MyTextEditor {
    JFrame frame;
    JMenuBar menu;
    JMenu file;
    JTextArea text;
    JMenuItem ne,op,sa,cl;
    
    public MyTextEditor(){
        frame = new JFrame("My Text Editor");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,480);
        
        menu = new JMenuBar();
        
        file = new JMenu("File");
        
        ne = new JMenuItem("New");
        file.add(ne);
        
        op = new JMenuItem("Open");
        file.add(op);
        
        sa = new JMenuItem("Save");
        file.add(sa);
        
        file.add(new JSeparator());
        
        cl = new JMenuItem("Close");
        file.add(cl);
       
        menu.add(file);
        
        frame.setJMenuBar(menu);
        
        text = new JTextArea();
        text.setBorder(BorderFactory.createEmptyBorder(5,5,0,0));
        frame.add(text);
        
        MenuItemsHandler handler = new MenuItemsHandler(this);
        ne.addActionListener(handler);
        op.addActionListener(handler);
        sa.addActionListener(handler);
        cl.addActionListener(handler);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        MyTextEditor a = new MyTextEditor();
    }
}
