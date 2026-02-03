/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package account;

import common.DataBase;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Math.random;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

/**
 *
 * @author k2
 */
public class Account extends JPanel{
    private String id;
    private String name;
    private String type;
    private double value;
    
    //static ArrayList<Account> accounts = common.DataBase.getAccounts();
    
    public Account(String name, String type, double value) {
        this.id = randomCode();
        this.name = name;
        this.type = type;
        this.value = value;
    }
    
    public void buildPanel() {
        removeAll();
        
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        setMaximumSize(new Dimension(Integer.MAX_VALUE, 70));
        setBorder(new EtchedBorder());
                
                
        JLabel newNameLabel = new JLabel("Name: " + this.name);
        JLabel newTypeLabel = new JLabel("Type: " + this.type);
        JLabel newValueLabel = new JLabel("Value: " + Double.toString(this.value));
        
        JButton newDelBtn = new JButton("X");
        newDelBtn.addActionListener((ActionEvent e) -> {
            common.DataBase.removeAcc(Account.this);
            Container parent1 = Account.this.getParent();
            if (parent1 != null) {
                parent1.remove(Account.this);
                parent1.revalidate();
                parent1.repaint();
            }
        });        
                
        add(newNameLabel);
        add(Box.createRigidArea(new Dimension(10, 0)));
        add(newTypeLabel);
        add(Box.createRigidArea(new Dimension(10, 0)));
        add(newValueLabel);
        add(Box.createHorizontalGlue());
        add(newDelBtn);
        add(Box.createRigidArea(new Dimension(10, 0)));
    }
    
    public String getId() {
        return this.id;
    }
    
    public String getName() {
        return this.name;
    }
    
    public String getType() {
        return this.type;
    }
    
    public double getValue() {
        return this.value;
    }
    
    public void setValue(String operation, double amount) {
        switch (operation) {
            case "+":
                this.value += amount;
                break;
            case "-":
                this.value -= amount;
                break;
            default:
                System.out.print("acc set value error");
                break;
        }
    }

    static String randomCode() {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder code = new StringBuilder(3);

        for (int i = 0; i < 3; i++) {
            code.append(chars.charAt(
                ThreadLocalRandom.current().nextInt(chars.length())
            ));
        }

        return code.toString();
    }
    
    @Override
    public String toString() {
        return name + " (" + type + ")";
    }

}
