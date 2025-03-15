/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week14.books;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.util.ArrayList;
/**
 *
 * @author japan
 */
public class Controller extends WindowAdapter implements ActionListener{
    ArrayList<Book> booklist = new ArrayList();
    BookView view;
    BookAdd insert;
    int current = 0;

    public Controller(BookView view){
        this.view = view;
    }
    
    public void viewUpdate(){
        if (booklist.isEmpty()){
            view.pagenum.setText("0");
            view.namef.setText("");
            view.pricef.setText("");
            view.typef.setSelectedItem("General");
            return;
        }
        view.pagenum.setText((current+1)+"");
        Book b = booklist.get(current);
        view.namef.setText(b.getName());
        view.pricef.setText(b.getPrice() + "");
        view.typef.setSelectedItem(b.getType());
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(view.add)){
            insert = new BookAdd(this);
        }
        else if (insert != null && e.getSource().equals(insert.insert)){
            String name = insert.namef.getText();
            double price = Double.parseDouble(insert.pricef.getText());
            String type = (String)insert.typef.getSelectedItem();
            booklist.add(new Book(name, price, type));
            insert.frame.dispose();
            JOptionPane.showMessageDialog(view.frame, "Done it.", "",JOptionPane.INFORMATION_MESSAGE);
            viewUpdate();
        }
        else if (e.getSource().equals(view.left)){
            if (current > 0){
                current--;
                viewUpdate();
            }
        }
        else if (e.getSource().equals(view.right)){
            if (current < booklist.size()-1){
                current++;
                viewUpdate();
            }
        }
        else if (e.getSource().equals(view.update)){
            Book b = booklist.get(current);
            b.setName(view.namef.getText());
            b.setPrice(Double.parseDouble(view.pricef.getText()));
            b.setType((String)view.typef.getSelectedItem());
            JOptionPane.showMessageDialog(view.frame, "Done it.", "Update Command",JOptionPane.INFORMATION_MESSAGE);
        }
        else if (e.getSource().equals(view.delete)){
            booklist.remove(current);
            if (current >= booklist.size()){
                current = booklist.size()-1;
            }
            viewUpdate();
        }
    }

    @Override
    public void windowClosing(WindowEvent e) {
        File f = new File("Book.data");
        if (booklist.isEmpty()){
            System.out.println("No data");
            return;
        }
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(f))){
            out.writeObject(booklist);
            System.out.println("Saved");
        }
        catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } 
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {
        File f = new File("Book.data");
        if (!f.exists()){
            view.frame.dispose();
            System.out.println("File not found");
            return;
        }
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(f))){
            ArrayList<Book> list = (ArrayList<Book>)in.readObject();
            booklist = list;
        }
        catch (EOFException ex){
            System.out.println("EOF");
            booklist = new ArrayList();
        }
        catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } 
        catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        finally{
            viewUpdate();
        }
    }
}
