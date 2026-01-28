/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chartOfAccPage;

/**
 *
 * @author k2
 */

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class ChartOfAccPage {
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
        
        //NAME SECTION
        
        JPanel namePanel = new JPanel();
        namePanel.setLayout(new BoxLayout(namePanel, BoxLayout.X_AXIS));

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
        
        JLabel valueLabel = new JLabel("Amount: ");
        valueLabel.setBorder(new LineBorder(Color.BLACK));
        valueLabel.setFont(new Font("MV Boli", Font.PLAIN, 24));
        valueLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        JTextField valueField = new JTextField();
        Dimension valueFieldSize = new Dimension(180, 36);
        valueField.setPreferredSize(valueFieldSize);
        valueField.setMinimumSize(valueFieldSize);
        valueField.setMaximumSize(valueFieldSize);
        valueField.setFont(new Font("MV Boli", Font.PLAIN, 24));
        
        
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
        
        submitBtn.addActionListener(e -> {
            String newName = nameField.getText();
            String newType = typeCombo.getSelectedItem().toString();
        });
        
        //ACCOUNTS PANEL
        
        JPanel accsPanel = new JPanel();
        accsPanel.setLayout(new BoxLayout(namePanel, BoxLayout.Y_AXIS));
        

        //ADDING SECTION
        //NAME ADDING
        
        namePanel.add(Box.createHorizontalGlue());
        namePanel.add(nameLabel);
        namePanel.add(Box.createRigidArea(new Dimension(10, 0)));
        namePanel.add(nameField);
        namePanel.add(Box.createRigidArea(new Dimension(10, 0)));
        namePanel.add(valueLabel);
        namePanel.add(Box.createRigidArea(new Dimension(10, 0)));
        namePanel.add(valueField);
        namePanel.add(Box.createHorizontalGlue());
        
        //TYPE ADDING
        
        typePanel.add(Box.createHorizontalGlue());
        typePanel.add(typeLabel);
        typePanel.add(Box.createRigidArea(new Dimension(10, 0)));
        typePanel.add(typeCombo);
        typePanel.add(Box.createRigidArea(new Dimension(30, 0)));
        typePanel.add(submitBtn);
        typePanel.add(Box.createHorizontalGlue());
        
        //MAIN PANEL ADDING

        mainPanel.add(namePanel);
        namePanel.add(Box.createRigidArea(new Dimension(0, 90)));
        mainPanel.add(typePanel);
        
        //MAIN FRAME SETUP

        mainFrame.setContentPane(mainPanel);
        mainFrame.setSize(720, 720);
        mainFrame.setVisible(true);

        
        
    }
    
}

//Next should be submit button functionality
    //- account panel class
    //- dynamic creation