/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author japan
 */
public class Player {

    private final String name;
    private final int attackDamage = 2;
    private Houses houses;
    private int hp = 20;
    private int mana = 50;
    
    public Player(){
        this("");
    }
    
    public Player(String name){
        this.name = name;
    }
    
    public Player(String name, int hp){
        this(name);
        setHP(hp);
    }

    public String getName() {
        return name;
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    public Houses getHouses() {
        return houses;
    }

    public void setHouses(Houses houses) {
        this.houses = houses;
    }

    public int getHP() {
        return hp;
    }

    public void setHP(int hp) {
        if (hp < 0){
            this.hp = 0;
        }
        else if (hp > 20){
            this.hp = 20;
        }
        else{
            this.hp = hp;
        }
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        if (mana < 0){
            this.mana = 0;
        }
        else if (mana > 50){
            this.mana = 50;
        }
        else{
            this.mana = mana; 
        }
    }
    
    @Override
    public String toString(){
        String str = "[Player] : " + getName() + " HP: " + getHP() + " Mana: " + getMana() + " || " + getHouses();
        return str;
    }
    
    public boolean equals(Player player){
        return getName().equals(player.getName()) && getHouses().equals(player.getHouses());
    }
    
    public void attack(Player target, Spell spell){
        Magicable house = (Magicable)getHouses();
        house.attackSpell(this,target,spell);
        if (target.getHP() <= 0){
            System.out.println("[DEAD]: " + target.getName() + " was killed by "+ getName());
        }
    }
    
    public void protectFromPlayer(Player target){
        Magicable house = (Magicable)getHouses();
        house.defense(this, target);
    }
}
