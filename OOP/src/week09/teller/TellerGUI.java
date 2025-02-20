/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week09.teller;

/**
 *
 * @author japan
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TellerGUI {
    JFrame frame;
    JPanel balance;
    JPanel amount;
    JPanel buttons;
    JLabel balanceLabel;
    JLabel amountLabel;
    JTextField balanceNum;
    JTextField amountField;
    JButton deposit;
    JButton withdraw;
    JButton exit;
    Account acc =  new Account();
    
    public TellerGUI(){
        //set frame
        acc.balance = 6000;
        frame = new JFrame("Teller GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(4,1));
        frame.setSize(250,300);
        
        //set balance
        balance = new JPanel();
        balance.setLayout(new GridLayout(1,2));
        balanceLabel = new JLabel("Balance");
        balanceNum = new JTextField(acc.balance + "");
        balanceNum.setEditable(false);
        balance.add(balanceLabel);
        balance.add(balanceNum);
        
        //set amount
        amount = new JPanel();
        amount.setLayout(new GridLayout(1,2));
        amountLabel = new JLabel("Amount");
        amountField = new JTextField();
        amount.add(amountLabel);
        amount.add(amountField);
        
        //set buttons
        buttons = new JPanel();
        deposit = new JButton("Deposit");
        withdraw = new JButton("Withdraw");
        exit = new JButton("Exit");
        buttons.add(deposit);
        buttons.add(withdraw);
        buttons.add(exit);
        
        frame.add(balance);
        frame.add(amount);
        frame.add(buttons);
        
        frame.setVisible(true);
        frame.pack();
        
        EventHandler h = new EventHandler(this);
        deposit.addActionListener(h);
        withdraw.addActionListener(h);
        exit.addActionListener(h);
            
    }
    public static void main(String[] args) {
        new TellerGUI();
    }
}

class EventHandler implements ActionListener{
    
    TellerGUI ui;
    Account acc;
    
    public EventHandler(TellerGUI ui){
        this.ui = ui;
        acc = ui.acc;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(ui.deposit)){
            double value = Double.parseDouble(ui.amountField.getText());
            acc.deposit(value);
            ui.balanceNum.setText(ui.acc.balance + "");
        }
        else if(e.getSource().equals(ui.withdraw)){
            double value = Double.parseDouble(ui.amountField.getText());
            acc.withdraw(value);
            ui.balanceNum.setText(ui.acc.balance + "");
        }
        else{
            ui.frame.dispose();
        }
    }
}
