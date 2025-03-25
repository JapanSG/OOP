/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prefinal;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author japan
 */
public class App extends WindowAdapter implements ActionListener{
    JFrame frame;
    AddItem additem;
    EditItem edititem;
    JPanel page;
    ArrayList<Item> items = new ArrayList();
    public App(){
        frame = new JFrame();
        frame.setDefaultCloseOperation(3);
        frame.addWindowListener(this);
        page = new Login(this);
        frame.setContentPane(page);
        frame.setSize(400,300);
        frame.setVisible(true);
    }

    @Override
    public void windowClosing(WindowEvent e) {
        File f = new File("jisso_shop.dat");
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(f))){
            out.writeObject(items);
        } 
        catch (FileNotFoundException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (IOException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Data Saved");
    }

    @Override
    public void windowOpened(WindowEvent e) {
        File f = new File("jisso_shop.dat");
        if (!f.exists()){
            System.out.println("jisso_shop.dat not Found");
            return;
        }
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(f))){
            items = (ArrayList<Item>)in.readObject();
        }
        catch (EOFException ex){
            items = new ArrayList();
        }
        catch (FileNotFoundException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (IOException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (ClassNotFoundException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Data Loaded");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (page instanceof Login){
            Login loginPage = (Login)page;
            String username = loginPage.loginf.getText();
            String password = loginPage.passwordf.getText();
            if (username.equals("jisoo") && password.equals("flower_me")){
                page = new Dashboard(this);
                ((Dashboard)page).updateAdd(items);
                frame.setContentPane(page);
                frame.setVisible(true);
            }
            else{
                System.out.println("Incorrect Username or Password");
            }
        }
        else{
            Dashboard dashboard = (Dashboard)page;
            Object src = e.getSource();
            if (src.equals(dashboard.add)){
                System.out.println("new Frame");
                additem = new AddItem(this);
            }
            else if (additem != null && src.equals(additem.insert)){
                System.out.println("insert");
                int Id  = Integer.parseInt(additem.center.getIdText());
                String name = additem.center.getNameText();
                double price = Double.parseDouble(additem.center.getPriceText());
                
                Item item = new Item(Id, name, price, Calendar.getInstance().getTime());
                items.add(item);
                dashboard.updateAdd(item);
                additem.dispose();
                JOptionPane.showMessageDialog(frame, "Done it");
            }
            else if (src.equals(dashboard.edit)){
                System.out.println("Edit");
                edititem = new EditItem(this);
                if (!items.isEmpty()){
                    edititem.update(items.get(0));
                }
            }
            else if (src.equals(dashboard.logout)){
                page = new Login(this);
                frame.setContentPane(page);
                frame.setVisible(true);
            }
            else if (edititem != null){
                if (src.equals(edititem.left)){
                    if (edititem.current > 0){
                        edititem.current -= 1;
                        edititem.update(items.get(edititem.current));
                    }
                }
                else if (src.equals(edititem.right)){
                    if (edititem.current < items.size()-1){
                        edititem.current += 1;
                        edititem.update(items.get(edititem.current));
                    }
                }
                else if (src.equals(edititem.close)){
                    edititem.dispose();
                }
                else if (src.equals(edititem.update)){
                    Item item = items.get(edititem.current);
                    item.setId(Integer.parseInt(edititem.grid.getIdText()));
                    item.setName(edititem.grid.getNameText());
                    item.setPrice(Double.parseDouble(edititem.grid.getPriceText()));
                    dashboard.updateRow(edititem.current, item);
                }
                else{
                    items.remove(edititem.current);
                    dashboard.updateDelete(edititem.current);
                    if (edititem.current >= items.size()){
                        edititem.current = items.size()-1;
                    }
                    edititem.dispose();
                    JOptionPane.showMessageDialog(frame, "Done it");
                }
            }
        }
    }
}
