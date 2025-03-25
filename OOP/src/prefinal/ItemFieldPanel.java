/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prefinal;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
/**
 *
 * @author japan
 */
public class ItemFieldPanel extends JPanel{
    JLabel Id,name,price;
    JTextField idf, namef, pricef;
    
    public ItemFieldPanel(){
        super(new GridLayout(3,2,5,5));
        this.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        Id = new JLabel("ID");
        idf = new JTextField();
        name = new JLabel("Name");
        namef = new JTextField();
        price = new JLabel("Price");
        pricef = new JTextField();
        add(Id);
        add(idf);
        add(name);
        add(namef);
        add(price);
        add(pricef);
    }
    
    public String getIdText(){
        return idf.getText();
    }
    
    public String getNameText(){
        return namef.getText();
    }
    
    public String getPriceText(){
        return pricef.getText();
    }
    
    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.add(new ItemFieldPanel());
        f.pack();
        f.setVisible(true);
    }
}
