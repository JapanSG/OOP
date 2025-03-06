/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author japan
 */
public abstract class Houses {

    private String name;
    private String color;
    
    public Houses(){
        this("","");
    }
    public Houses(String name, String color){
        setName(name);
        setColor(color);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    @Override
    public String toString(){
        String str =  "[House] : " + getName() + " , Color : " + getColor();
        return str;
    }
}
