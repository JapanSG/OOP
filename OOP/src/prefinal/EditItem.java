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
public class EditItem extends JFrame{
    ItemFieldPanel grid;
    JButton left, right, delete, update, close;
    int current = 0;
    public EditItem(ActionListener e){
        grid = new ItemFieldPanel();
        this.add(grid, BorderLayout.CENTER);
        this.setSize(300, 250);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        left =new JButton("<<<");
        right =new JButton(">>>");
        delete = new JButton("Delete Item");
        update  =new JButton("Update Item");
        close = new JButton("Close Item");
        
        JPanel south = new JPanel(new GridLayout(2,1));
        JPanel lr = new JPanel();
        lr.add(left);
        lr.add(right);
        south.add(lr);
        
        JPanel btns = new JPanel();
        btns.add(delete);
        btns.add(update);
        btns.add(close);
        south.add(btns);
        this.add(south, BorderLayout.SOUTH);
        
        left.addActionListener(e);
        right.addActionListener(e);
        delete.addActionListener(e);
        update.addActionListener(e);
        close.addActionListener(e);
        
        this.setVisible(true);
    }
    public void update(Item item){
        grid.idf.setText(item.getId()+"");
        grid.namef.setText(item.getName());
        grid.pricef.setText(item.getPrice()+"");
    }
}
