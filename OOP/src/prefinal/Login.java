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
public class Login extends JPanel{
    JLabel login, password;
    JTextField loginf, passwordf;
    JButton loginbtn;
    
    public Login(ActionListener e){
        this.setLayout(new BorderLayout());
        JPanel north = new JPanel();
        north.setPreferredSize(new Dimension(300, 50));
        this.add(north, BorderLayout.NORTH);
        
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(4,2));
        center.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        login = new JLabel("Login");
        center.add(login);
        
        loginf  =new JTextField();
        center.add(loginf);
        
        center.add(new JPanel());
        center.add(new JPanel());

        password = new JLabel("Password");
        center.add(password);
        
        passwordf = new JTextField();
        center.add(passwordf);
        this.add(center, BorderLayout.CENTER);
        
        JPanel south = new JPanel();
        loginbtn = new JButton("Login");
        south.add(loginbtn);
        this.add(south,BorderLayout.SOUTH);
        this.setVisible(true);

        loginbtn.addActionListener(e);
    }
}
