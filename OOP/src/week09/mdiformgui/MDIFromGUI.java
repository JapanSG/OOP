/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week09.mdiformgui;

/**
 *
 * @author japan
 */
import java.awt.*;
import javax.swing.*;

public class MDIFromGUI {
    private JFrame frame;
    private JDesktopPane desk;
    private JMenuBar mb;
    private JMenu file;
    private JMenu edit;
    private JMenu view;
    private JMenu n;
    private JMenuItem win,message,o,s,e;
    private JInternalFrame a1,a2,a3;
    
    public MDIFromGUI(){
        frame = new JFrame("SubMenuItem Demon");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        desk = new JDesktopPane();
        mb = new JMenuBar();
        file = new JMenu("File");
        edit = new JMenu("Edit");
        view = new JMenu("View");
        n = new JMenu("New");
        win = new JMenuItem("Window");
        message = new JMenuItem("Message");
        o = new JMenuItem("Open");
        s = new JMenuItem("Save");
        e = new JMenuItem("Exit");
        a1 = new JInternalFrame("application 1",true,true,true,true);
        a1.setSize(150,150);
        a1.setVisible(true);

        a2 = new JInternalFrame("application 2",true,true,true,true);
        a2.setSize(150,150);
        a2.setVisible(true);

        a3 = new JInternalFrame("application 3",true,true,true,true);
        a3.setSize(150,150);
        a3.setVisible(true);
        
        frame.setJMenuBar(mb);
        mb.add(file);
        mb.add(edit);
        mb.add(view);
        file.add(n);
        file.add(o);
        file.add(s);
        file.add(e);
        n.add(win);
        n.add(message);

        desk.add(a1);
        desk.add(a2);
        desk.add(a3);
        frame.add(desk,BorderLayout.CENTER);
        
        frame.setVisible(true);
        frame.setMinimumSize(new Dimension(600,600));
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
       
    }
    
    public static void main(String[] args) {
        new MDIFromGUI();
    }
}
