/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week12.studentprofile;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
/**
 *
 * @author japan
 */
public class StudentView {
    Student student = new Student();
    JFrame frame;
    JLabel idLabel, nameLabel, moneyLabel;
    JTextField idField, nameField, moneyField;
    JButton deposit, withdraw;
    
    public StudentView(){
        frame = new JFrame("StudentView");
        JPanel contentPane = new JPanel();
        contentPane.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        GridLayout gl = new GridLayout(4,2);
        gl.setHgap(5);
        gl.setVgap(5);
        frame.setContentPane(contentPane);
        frame.setLayout(gl);
        frame.setSize(300, 200);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        idLabel = new JLabel("ID:");
        frame.add(idLabel);
        
        idField = new JTextField();
        frame.add(idField);
        
        nameLabel = new JLabel("Name:");
        frame.add(nameLabel);
        
        nameField = new JTextField();
        frame.add(nameField);
        
        moneyLabel = new JLabel("Money:");
        frame.add(moneyLabel);
        
        moneyField = new JTextField(student.getMoney()+"");
        moneyField.setEditable(false);
        frame.add(moneyField);
        
        deposit = new JButton("Deposit");
        frame.add(deposit);
        
        withdraw = new JButton("Withdraw");
        frame.add(withdraw);
        frame.setVisible(true);
        
        EventHandler handler = new EventHandler(this);
        frame.addWindowListener(handler);
        deposit.addActionListener(handler);
        withdraw.addActionListener(handler);
    }
    
    
    public static void main(String[] args) {
        new StudentView();
    }
}
class EventHandler extends WindowAdapter implements ActionListener{
    StudentView ui;
    public EventHandler(StudentView ui){
        this.ui = ui;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if (e.getSource().equals(ui.deposit)){
           ui.student.setMoney(ui.student.getMoney() + 100);
           ui.moneyField.setText(ui.student.getMoney() + "");
       }
       else{
           ui.student.setMoney(ui.student.getMoney() - 100);
           ui.moneyField.setText(ui.student.getMoney() + "");
       }
    }

    @Override
    public void windowOpened(WindowEvent e) {
        File f = new File("StudentM.dat");
        if (!f.exists()){
            System.out.println("StudentM.dat file not found");
            ui.frame.dispose();
            return;
        }
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(f))){
            ui.student = (Student)in.readObject();
            ui.idField.setText(ui.student.getID() + "");
            ui.nameField.setText(ui.student.getName());
            ui.moneyField.setText(ui.student.getMoney() + "");
        }
        catch (IOException|ClassNotFoundException ex){
            ex.printStackTrace();
        } 
    }

    @Override
    public void windowClosing(WindowEvent e) {
        File f = new File("StudentM.dat");
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(f))){
            ui.student.setID(Integer.parseInt(ui.idField.getText()));
            ui.student.setName(ui.nameField.getText());
            ui.student.setMoney(Integer.parseInt(ui.moneyField.getText()));
            out.writeObject(ui.student);
        }
        catch (IOException ex){
            ex.printStackTrace();
        }
        System.out.println("Saved");
    }
}
