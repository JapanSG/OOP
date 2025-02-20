/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week09.calculator;

/**
 *
 * @author japan
 */
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Dimension;

public class CalculatorOneGUI {
    JFrame frame;
    JTextField num1Field;
    JTextField num2Field;
    JTextField ansField;
    JPanel north;
    JPanel south;
    JPanel buttonGroup;
    JButton plus;
    JButton minus;
    JButton mult;
    JButton div;
    
    public CalculatorOneGUI(){
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Calculator");
        
        num1Field = new JTextField();
        num1Field.setPreferredSize(new Dimension(20,30));
        num2Field = new JTextField();
        num2Field.setPreferredSize(new Dimension(20,30));
        north = new JPanel();
        north.setLayout(new BorderLayout());
        north.add(num1Field,BorderLayout.NORTH);
        north.add(num2Field,BorderLayout.SOUTH);
        frame.add(north,BorderLayout.NORTH);

        south = new JPanel();
        south.setLayout(new BorderLayout());
        buttonGroup = new JPanel();
        plus = new JButton("plus");
        minus = new JButton("minus");
        mult = new JButton("mult");
        div = new JButton("div");
        
        buttonGroup.add(plus);
        buttonGroup.add(minus);
        buttonGroup.add(mult);
        buttonGroup.add(div);
        buttonGroup.setPreferredSize(new Dimension(400,35));
        ansField = new JTextField();
        ansField.setPreferredSize(new Dimension(20,30));
        south.add(buttonGroup, BorderLayout.NORTH);
        south.add(ansField, BorderLayout.SOUTH);

        frame.add(south, BorderLayout.SOUTH);
        frame.setVisible(true);
        frame.pack();
    }
}
