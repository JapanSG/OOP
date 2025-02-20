/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week09.calculator;

/**
 *
 * @author japan
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CalculatorTwoGUI {
    private JFrame frame;
    private JPanel buttons;
    private JTextField field;
    private double total = 0;
    public String sign = "+";

    public CalculatorTwoGUI(){
        frame = new JFrame("My Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        field = new JTextField();
        field.setText("");
        buttons = new JPanel();
        buttons.setSize(100,100);
        buttons.setLayout(new GridLayout(4,4));
        Dimension buttonSize = new Dimension(20,30);
        createButton("7", buttonSize);
        createButton("8", buttonSize);
        createButton("9", buttonSize);
        createButton("+", buttonSize);
        createButton("4", buttonSize);
        createButton("5", buttonSize);
        createButton("6", buttonSize);
        createButton("-", buttonSize);
        createButton("1", buttonSize);
        createButton("2", buttonSize);
        createButton("3", buttonSize);
        createButton("x", buttonSize);
        createButton("0", buttonSize);
        createButton("c", buttonSize);
        createButton("=", buttonSize);
        createButton("/", buttonSize);
        frame.add(field,BorderLayout.NORTH);
        frame.add(buttons,BorderLayout.CENTER);
        
        frame.setVisible(true);
        frame.setSize(250,250);
    }
    
    private void createButton(String str, Dimension d){
        JButton btn = new JButton(str);
        btn.setSize(d);
        buttons.add(btn);
        if (str.equals("=")){
            btn.addActionListener(new Equal(this));
        }
        else if (str.equals("c")){
            btn.addActionListener(new C(this));
        }
        else if (str.equals("+") || str.equals("-") || str.equals("x") || str.equals("/")){
            btn.addActionListener(new SignB(this,str));
        }
        else{
            btn.addActionListener(new BtnLis(this,str));
        }
    }
    
    public JTextField getField(){
        return field;
    }
    
    public double getTotal(){
        return total;
    }
    
    public void setTotal(double total){
        this.total = total;
    }
}
class BtnLis implements ActionListener{
    protected String val;
    protected JTextField field;
    protected CalculatorTwoGUI ui;
    
    public BtnLis(CalculatorTwoGUI ui, String val){
        this.val = val;
        this.field = ui.getField();
        this.ui = ui;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (ui.sign.equals("=")){
            field.setText("");
            ui.setTotal(Double.parseDouble(val));
        }
        String str = field.getText();
        field.setText(str+val);
    }
}
class C extends BtnLis{
    public C(CalculatorTwoGUI ui){
        super(ui,"");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        ui.sign = "+";
        ui.setTotal(0);
        field.setText(ui.getTotal()+"");
    }
    
}
class SignB extends BtnLis{
    
    public SignB(CalculatorTwoGUI ui, String val){
        super(ui,val);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (ui.sign.equals("+")){
            ui.setTotal(ui.getTotal() + Double.parseDouble(field.getText()));
        }
        else if(ui.sign.equals("-")){
            ui.setTotal(ui.getTotal() - Double.parseDouble(field.getText()));
        }
        else if(ui.sign.equals("x")){
            ui.setTotal(ui.getTotal() * Double.parseDouble(field.getText()));
        }
        else if(ui.sign.equals("/")){
            ui.setTotal(ui.getTotal() / Double.parseDouble(field.getText()));
        }
        field.setText("");
        ui.sign = val;
    }
    
}
class Equal extends BtnLis{

    public Equal(CalculatorTwoGUI ui){
        super(ui, "");
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (ui.sign.equals("+")){
            ui.setTotal(ui.getTotal() + Double.parseDouble(field.getText()));
        }
        else if(ui.sign.equals("-")){
            ui.setTotal(ui.getTotal() - Double.parseDouble(field.getText()));
        }
        else if(ui.sign.equals("x")){
            ui.setTotal(ui.getTotal() * Double.parseDouble(field.getText()));
        }
        else if(ui.sign.equals("/")){
            ui.setTotal(ui.getTotal() / Double.parseDouble(field.getText()));
        }
        field.setText(ui.getTotal()+"");
        ui.sign = "=";
        ui.setTotal(0);
    }
}