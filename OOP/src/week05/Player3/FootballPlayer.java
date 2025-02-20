/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week05.Player3;

/**
 *
 * @author japan
 */
public class FootballPlayer extends Player{
    private int playerNumber;
    private String position;

    public int getPlayerNumber() {
        return playerNumber;
    }

    public void setPlayerNumber(int n) {
        playerNumber = n;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String p) {
        position = p;
    }
    public boolean isSamePosition(FootballPlayer p){
        return position.equals(p.position);
    }
}
