/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package week05.Player3;

/**
 *
 * @author japan
 */
public class Player {
   private String name;
   private String team;

    public String getName() {
        return name;
    }

    public void setName(String n) {
        name = n;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String t) {
        team = t;
    }
    
    public boolean isSameTeam(Player p){
        return team.equals(p.team);
    }
    
}
