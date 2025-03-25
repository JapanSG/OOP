/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prefinal;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author japan
 */
public class Dashboard extends JPanel{
    JLabel intro;
    JButton add,edit,logout;
    JTable table;
    DefaultTableModel m;
    public Dashboard(ActionListener e){
        setLayout(new BorderLayout());
        JPanel north = new JPanel();
        north.setLayout(new BorderLayout());
        north.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        intro = new JLabel("Welcome to Jisoo Marketplace");
        intro.setHorizontalAlignment(JLabel.CENTER);
        north.add(intro, BorderLayout.NORTH);

        JPanel btns = new JPanel();
        ((FlowLayout)btns.getLayout()).setAlignment(FlowLayout.CENTER);
        add = new JButton("Add item");
        edit = new JButton("Edit item");
        logout = new JButton("Logout");
        btns.add(add);
        btns.add(edit);
        btns.add(logout);
        north.add(btns, BorderLayout.SOUTH);
        this.add(north, BorderLayout.NORTH);
        
        table = new JTable();
        m = (DefaultTableModel)table.getModel();
        m.addColumn("ID");
        m.addColumn("Name");
        m.addColumn("Price");
        m.addColumn("Create_On");
        JScrollPane s = new JScrollPane(table);
        
        this.add(s, BorderLayout.CENTER);
        
        add.addActionListener(e);
        edit.addActionListener(e);
        logout.addActionListener(e);
        
    }
    
    public void updateAdd(ArrayList<Item> items){
        for(Item item : items){
            Date d = item.getCreate_on();
            SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            Object[] rowData = {item.getId(), item.getName(), item.getPrice(), df.format(d)};
            m.addRow(rowData);
        }
    }
    
    public void updateAdd(Item item){
        Date d = item.getCreate_on();
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Object[] rowData = {item.getId(), item.getName(), item.getPrice(), df.format(d)};
        m.addRow(rowData);
    }
    
    public void updateDelete(int row){
        m.removeRow(row);
    }
    
    public void updateRow(int row, Item item){
        Date d = item.getCreate_on();
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Object[] rowData = {item.getId(), item.getName(), item.getPrice(), df.format(d)};
        m.insertRow(row, rowData);
        m.removeRow(row+1);
    }
}
