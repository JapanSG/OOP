/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tutor1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 *
 * @author japan
 */
public class ClientChat {
    JFrame frame;
    JTextArea textArea;
    JTextField textField;
    JButton submit;
    JScrollPane chat;
    private final static ArrayList<ClientChat> clients = new ArrayList();
    
    public ClientChat(){
        frame = new JFrame();
        frame.setSize(600,480);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        textArea = new JTextArea();
        textArea.setEditable(false);
        chat = new JScrollPane(textArea);
        frame.add(chat,BorderLayout.CENTER);
        
        JPanel southPanel = new JPanel();
        JPanel textFieldWrapper = new JPanel(new BorderLayout());
        textField = new JTextField();
        textField.setPreferredSize(new Dimension(500,30));
        textFieldWrapper.add(textField, BorderLayout.CENTER);
        southPanel.add(textFieldWrapper);

        submit = new JButton("Submit");
        southPanel.add(submit);
        
        frame.add(southPanel,BorderLayout.SOUTH);
        
        frame.setVisible(true);
        clients.add(this);
        
        EventHandler e = new EventHandler(this);
        submit.addActionListener(e);
        frame.addWindowListener(e);
    }
    
    public static ArrayList<ClientChat> getClientList(){
        return clients;
    }
}
class EventHandler extends WindowAdapter implements ActionListener{
    ClientChat ui;
    
    public EventHandler(ClientChat ui){
        this.ui = ui;
    }

    @Override
    public void windowOpened(WindowEvent e) {
        File f = new File("chat_history.dat");
        if (!f.exists()){
            ui.frame.dispose();
            System.out.println("chat_history.dat not found");
            return;
        }
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(f))){
            ui.textArea.setText((String)in.readObject());
        }
        catch (IOException|ClassNotFoundException ex){
            ex.printStackTrace();
        }
        System.out.println(ui.frame.getTitle()+" Data Loaded");
    }

    @Override
    public void windowClosing(WindowEvent e) {
        File f = new File("chat_history.dat");
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(f))){
            out.writeObject(ui.textArea.getText());
        }
        catch (IOException ex){
            ex.printStackTrace();
        }
        System.out.println("Data Saved");
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       ArrayList<ClientChat> list = ClientChat.getClientList();
       DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
       String date = dtf.format(LocalDateTime.now());
       for (ClientChat c : list){
           c.textArea.setText(String.format("%s%s:%s\n", c.textArea.getText(), date, ui.textField.getText()));
       }
       ui.textField.setText("");
    }
}
