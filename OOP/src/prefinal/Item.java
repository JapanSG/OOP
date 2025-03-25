/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prefinal;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author japan
 */
public class Item implements Serializable{
    private int Id;
    private String name;
    private double price;
    private Date create_on;
    
    public Item(){
        this(0,"",0.0,null);
    }

    public Item(int Id, String name, double price, Date create_on) {
        this.Id = Id;
        this.name = name;
        this.price = price;
        this.create_on = create_on;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getCreate_on() {
        return create_on;
    }

    public void setCreate_on(Date create_on) {
        this.create_on = create_on;
    }
    
    
}
