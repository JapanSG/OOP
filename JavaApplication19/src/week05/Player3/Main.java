/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week05.Player3;

/**
 *
 * @author japan
 */
public class Main {
    public static void main(String[] args) {
        Player p1 = new Player();
        p1.setName("Bank");
        p1.setTeam("Gate OR");
        
        Player p2 = new Player();
        p2.setName("Khim");
        p2.setTeam("Gate OR");
        
        if (p1.isSameTeam(p2))
            System.out.println(p1.getName() +" is a same team with "+p2.getName());
        else
            System.out.println(p1.getName() +" is not a same team with "+p2.getName());
    }
}
