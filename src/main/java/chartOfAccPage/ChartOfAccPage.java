/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chartOfAccPage;

/**
 *
 * @author k2
 */

import account.Account;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;

public class ChartOfAccPage {
    
    static JLabel warnLabel = new JLabel("-");
    
    public static void main(String[] args) {
        //SHARED VARIABLES
        
        
        
        //MAIN FRAME
        
        JFrame mainFrame = new JFrame("Chart of Accounts");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setResizable(false);
        
        //MAIN PANEL
        
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        
        //TOP PANEL
        
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.X_AXIS));

        //NAME SECTION
        
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBorder(new LineBorder(Color.BLACK));
        nameLabel.setFont(new Font("MV Boli", Font.PLAIN, 24));

        JTextField nameField = new JTextField();
        Dimension nameFieldSize = new Dimension(170, 36);
        nameField.setPreferredSize(nameFieldSize);
        nameField.setMinimumSize(nameFieldSize);
        nameField.setMaximumSize(nameFieldSize);
        nameField.setFont(new Font("MV Boli", Font.PLAIN, 24));
        
        //VALUE SECTION
        
        //JPanel valuePanel = new JPanel();
        //valuePanel.setLayout(new BoxLayout(valuePanel, BoxLayout.X_AXIS));
        
        JLabel valueLabel = new JLabel("Value: ");
        valueLabel.setBorder(new LineBorder(Color.BLACK));
        valueLabel.setFont(new Font("MV Boli", Font.PLAIN, 24));
        valueLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        JTextField valueField = new JTextField();
        Dimension valueFieldSize = new Dimension(180, 36);
        valueField.setPreferredSize(valueFieldSize);
        valueField.setMinimumSize(valueFieldSize);
        valueField.setMaximumSize(valueFieldSize);
        valueField.setFont(new Font("MV Boli", Font.PLAIN, 24));
        
        //ACCOUNTS PANEL
        
        JPanel accsPanel = new JPanel();
        accsPanel.setLayout(new BoxLayout(accsPanel, BoxLayout.Y_AXIS));
        
        //TYPE SECTION
        
        JPanel typePanel = new JPanel();
        typePanel.setLayout(new BoxLayout(typePanel, BoxLayout.X_AXIS));

        JLabel typeLabel = new JLabel("Type:");
        typeLabel.setBorder(new LineBorder(Color.BLACK));
        typeLabel.setFont(new Font("MV Boli", Font.PLAIN, 24));
        typeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        JComboBox<String> typeCombo = new JComboBox<>(new String[] 
                        {"Asset", "Liability", "Equity", "Expenses"});
        Dimension typeComboSize = new Dimension(300, 36);
        typeCombo.setPreferredSize(typeComboSize);
        typeCombo.setMinimumSize(typeComboSize);
        typeCombo.setMaximumSize(typeComboSize);
        typeCombo.setFont(new Font("MV Boli", Font.PLAIN, 24));
        
            // Submit button
           
        JButton submitBtn = new JButton("Submit");
        Dimension btnSize = new Dimension(120, 40);
        submitBtn.setPreferredSize(btnSize);
        submitBtn.setMinimumSize(btnSize);
        submitBtn.setMaximumSize(btnSize);
        submitBtn.setFont(new Font("MV Boli", Font.PLAIN, 24));
        submitBtn.setFocusable(false);
        
        submitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String newName = nameField.getText();
                    String newType = typeCombo.getSelectedItem().toString();
                    double newValue = Integer.parseInt(valueField.getText());

                    Account newAccPanel = new Account(newName, newType, newValue);

                    accsPanel.add(newAccPanel);
                    accsPanel.revalidate();
                    accsPanel.repaint();

                    System.out.print("Success");
                } catch (Exception ex) {
                    warnLabel.setText("Invalid input");
                }
                
            }
        });        
        
        //WARNING SECTION
        
        warnLabel.setHorizontalAlignment(JLabel.CENTER);

        Dimension warnSize = new Dimension(300, 36);
        warnLabel.setPreferredSize(warnSize);
        warnLabel.setMinimumSize(warnSize);
        warnLabel.setMaximumSize(warnSize);

        warnLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        warnLabel.setFont(new Font("MV Boli", Font.PLAIN, 24));

        //ADDING SECTION
        //NAME ADDING
        
        topPanel.add(Box.createHorizontalGlue());
        topPanel.add(nameLabel);
        topPanel.add(Box.createRigidArea(new Dimension(10, 0)));
        topPanel.add(nameField);
        topPanel.add(Box.createRigidArea(new Dimension(10, 0)));
        topPanel.add(valueLabel);
        topPanel.add(Box.createRigidArea(new Dimension(10, 0)));
        topPanel.add(valueField);
        topPanel.add(Box.createHorizontalGlue());
        
        //TYPE ADDING
        
        typePanel.add(Box.createHorizontalGlue());
        typePanel.add(typeLabel);
        typePanel.add(Box.createRigidArea(new Dimension(10, 0)));
        typePanel.add(typeCombo);
        typePanel.add(Box.createRigidArea(new Dimension(30, 0)));
        typePanel.add(submitBtn);
        typePanel.add(Box.createHorizontalGlue());
        
        //MAIN PANEL ADDING
        
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        mainPanel.add(topPanel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        mainPanel.add(typePanel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        mainPanel.add(warnLabel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 90)));
        mainPanel.add(accsPanel);
        
        
        
        //MAIN FRAME SETUP

        mainFrame.setContentPane(mainPanel);
        mainFrame.setSize(720, 720);
        mainFrame.setVisible(true);

        
        
    }
    
}

//Next should be exception handling
//sql
//another feature