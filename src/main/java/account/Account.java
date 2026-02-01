/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package account;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    private String name;
    private String type;
    private double value;
    
    public Account(String name, String type, double value) {
        this.name = name;
        this.type = type;
        this.value = value;
        
        //buildPanel();
    }
    
    public void buildPanel() {
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        setMaximumSize(new Dimension(Integer.MAX_VALUE, 70));
        setBorder(new EtchedBorder());
                
                
        JLabel newNameLabel = new JLabel("Name: " + this.name);
        JLabel newTypeLabel = new JLabel("Type: " + this.type);
        JLabel newValueLabel = new JLabel("Value: " + Double.toString(this.value));
        
        JButton newDelBtn = new JButton("X");
        newDelBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                   Container parent = Account.this.getParent();
                    if (parent != null) {
                        parent.remove(Account.this);
                        parent.revalidate();
                        parent.repaint();
                    }
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
    
    public String getName() {
        return this.name;
    }
    
    public String getType() {
        return this.type;
    }
    
    public double getValue() {
        return this.value;
    }
}
