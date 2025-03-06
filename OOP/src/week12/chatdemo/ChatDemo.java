/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week12.chatdemo;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author japan
 */
public class ChatDemo extends WindowAdapter implements ActionListener{
    
    JFrame frame;
    JTextField textField;
    JTextArea textArea;
    JButton submit;
    JButton reset;
    
    
    public ChatDemo() {
        frame = new JFrame("ChatDemo");
        frame.setSize(600,480);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        textArea =  new JTextArea();
        textArea.setPreferredSize(new Dimension(45,20));
        textArea.setEditable(false);
        frame.add(textArea,BorderLayout.CENTER);
        
        JPanel southPanel = new JPanel();
        southPanel.setLayout(new BorderLayout());
        textField = new JTextField();
        textField.setPreferredSize(new Dimension(45, 20));
        southPanel.add(textField,BorderLayout.NORTH);
        
        JPanel buttons = new JPanel();
        submit = new JButton("submit");
        reset = new JButton("reset");
        buttons.add(submit);
        buttons.add(reset);
        southPanel.add(buttons,BorderLayout.SOUTH);
        frame.add(southPanel,BorderLayout.SOUTH);
    }
    
    public void run(){
        frame.setVisible(true);
        frame.addWindowListener(this);
        submit.addActionListener(this);
        reset.addActionListener(this);
    }
    @Override
    public void windowClosing(WindowEvent e) {
        File f =  new File("ChatDemo.dat");
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(f))){
            out.writeObject(textArea.getText());
            System.out.println("Saved");
        }
        catch (IOException ex) {
            System.out.println(ex);
        }
        super.windowClosed(e); 
    }

    @Override
    public void windowOpened(WindowEvent e) {
        File f =  new File("ChatDemo.dat");
        if (!f.exists()){
            this.frame.dispose();
            return;
        }
        System.out.println(f.getAbsolutePath());
        try (
                ObjectInputStream in = new ObjectInputStream(new FileInputStream(f));
            ){
            String data = (String)in.readObject();
            textArea.setText(data);
        }
        catch (IOException ex) {
            System.out.println(ex);
        } 
        catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        super.windowOpened(e);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(submit)){
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            System.out.println(dtf.format(LocalDateTime.now()));
            String date = dtf.format(LocalDateTime.now());
            String text = textField.getText();
            textArea.setText(String.format("%s%s:%s\n",textArea.getText(), date, text));
            textField.setText("");
        }
        else {
            textArea.setText("");
        }
    }
    
    public static void main(String[] args) {
        var a = new ChatDemo();
        a.run();
    }
}
