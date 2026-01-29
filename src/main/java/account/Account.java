/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package account;

import java.awt.Dimension;
import javax.swing.Box;
import javax.swing.BoxLayout;
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
        
        buildPanel();
    }
    
    private void buildPanel() {
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        setMaximumSize(new Dimension(Integer.MAX_VALUE, 70));
        setBorder(new EtchedBorder());
                
                
        JLabel newNameLabel = new JLabel("Name: " + this.name);
        JLabel newTypeLabel = new JLabel("Type: " + this.type);
        JLabel newValueLabel = new JLabel("Value: " + Double.toString(this.value));
                
        add(newNameLabel);
        add(Box.createRigidArea(new Dimension(10, 0)));
        add(newTypeLabel);
        add(Box.createRigidArea(new Dimension(10, 0)));
        add(newValueLabel);
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
