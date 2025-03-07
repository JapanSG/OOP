/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tutor1;

import java.io.Serializable;
import java.util.ArrayList;
/**
 *
 * @author japan
 */
public class ChatLog implements Serializable{
    ArrayList<String> messages = new ArrayList();
    
    public ChatLog(){}
    
    public String load(char name){
        String chat = "";
        for (int i =0; i < messages.size(); i++){
            chat+= loadAtIndex(name, i);
        }
        return chat;
    }
    
    public void append(String message){
        messages.add(message);
    }
    
    public String loadLast(char name){
        String message = messages.getLast()+"";
        if (message.charAt(21) == name){
            message = message.substring(0, 22) + "(You)" + message.substring(22);
        }
        System.out.println(message);
        return message;
    }
    
    public String loadAtIndex(char name, int index){
        String message = messages.get(index)+"";
        System.out.println(message.charAt(21));
        if (message.charAt(21) == name){
            message = message.substring(0, 22) + "(You)" + message.substring(22);
        }
        System.out.println(message);
        return message;
    }
}
