/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week14.texteditor;

import javax.swing.*;
import java.awt.event.*;
import java.io.*;
/**
 *
 * @author japan
 */
public class MenuItemsHandler implements ActionListener{
    MyTextEditor mte;
    public MenuItemsHandler(MyTextEditor mte){
        this.mte = mte;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        var a = e.getSource();
        if (a.equals(mte.ne)){
            mte.text.setText("");
        }
        else if (a.equals(mte.op)){
            JFileChooser fc = new JFileChooser();
            fc.showOpenDialog(mte.frame); 
            File f = fc.getSelectedFile();
            try(BufferedReader reader = new BufferedReader(new FileReader(f))){
                String text = "";
                while (true){
                    String line = reader.readLine();
                    if (line == null){
                       break; 
                    }
                    text += line +"\n";
                }
                mte.text.setText(text);
            } 
            catch (FileNotFoundException ex) {
                ex.printStackTrace();
            } 
            catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        else if (a.equals(mte.sa)){
            JFileChooser fc = new JFileChooser();
            fc.showSaveDialog(mte.frame);
            File f = fc.getSelectedFile();
            try(FileWriter writer = new FileWriter(f)){
                writer.write(mte.text.getText());
            } 
            catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        else{
            mte.frame.dispose();
        }
    }
}
