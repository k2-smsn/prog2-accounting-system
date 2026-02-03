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
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.Component;
import javax.swing.JScrollPane;
import landingPage.LandingPage;
import mainFrame.MainFrame;

public class ChartOfAccPanel extends JPanel{
    
    static JLabel warnLabel = new JLabel("-");
    static JPanel accsPanel = new JPanel();
    
    public ChartOfAccPanel(MainFrame main) {
        //NAME SECTION
        
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBorder(new LineBorder(Color.BLACK));

        JTextField nameField = new JTextField();
        Dimension nameFieldSize = new Dimension(170, 36);
        nameField.setPreferredSize(nameFieldSize);
        nameField.setMinimumSize(nameFieldSize);
        nameField.setMaximumSize(nameFieldSize);
        
        //VALUE SECTION
        
        JLabel valueLabel = new JLabel("Value: ");
        valueLabel.setBorder(new LineBorder(Color.BLACK));
        valueLabel.setFont(new Font("MV Boli", Font.PLAIN, 24));
        valueLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        JTextField valueField = new JTextField();
        Dimension valueFieldSize = new Dimension(180, 36);
        valueField.setPreferredSize(valueFieldSize);
        valueField.setMinimumSize(valueFieldSize);
        valueField.setMaximumSize(valueFieldSize);
        
        //NAME AND VALUE PANEL
        
        JPanel nameAndValPanel = new JPanel();
        nameAndValPanel.setLayout(new BoxLayout(nameAndValPanel, BoxLayout.X_AXIS));
        
        nameAndValPanel.add(Box.createHorizontalGlue());
        nameAndValPanel.add(nameLabel);
        nameAndValPanel.add(Box.createRigidArea(new Dimension(10, 0)));
        nameAndValPanel.add(nameField);
        nameAndValPanel.add(Box.createRigidArea(new Dimension(10, 0)));
        nameAndValPanel.add(valueLabel);
        nameAndValPanel.add(Box.createRigidArea(new Dimension(10, 0)));
        nameAndValPanel.add(valueField);
        nameAndValPanel.add(Box.createHorizontalGlue());
        
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
        
            // Submit button
           
        JButton submitBtn = new JButton("Submit");
        Dimension btnSize = new Dimension(120, 40);
        submitBtn.setPreferredSize(btnSize);
        submitBtn.setMinimumSize(btnSize);
        submitBtn.setMaximumSize(btnSize);
        submitBtn.setFocusable(false);
        
        submitBtn.addActionListener((ActionEvent e) -> {
            try {
                String newName = nameField.getText();
                String newType = typeCombo.getSelectedItem().toString();
                double newValue = Integer.parseInt(valueField.getText());
                
                Account newAccPanel = new Account(newName, newType, newValue);
                common.DataBase.addAccount(newAccPanel);
                showAccounts();
                
                nameField.setText("");
                valueField.setText("");
                
                //System.out.print(common.DataBase.getAccNames());
            } 
            catch (Exception ex) {
                warnLabel.setText("Invalid input");
            }
        });        
        
        typePanel.add(Box.createHorizontalGlue());
        typePanel.add(typeLabel);
        typePanel.add(Box.createRigidArea(new Dimension(10, 0)));
        typePanel.add(typeCombo);
        typePanel.add(Box.createRigidArea(new Dimension(30, 0)));
        typePanel.add(submitBtn);
        typePanel.add(Box.createHorizontalGlue());
        
        //WARNING SECTION
        
        warnLabel.setHorizontalAlignment(JLabel.CENTER);

        Dimension warnSize = new Dimension(300, 36);
        warnLabel.setPreferredSize(warnSize);
        warnLabel.setMinimumSize(warnSize);
        warnLabel.setMaximumSize(warnSize);

        warnLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        //ACCOUNTS PANEL
        
        accsPanel.setLayout(new BoxLayout(accsPanel, BoxLayout.Y_AXIS));
        
        //FOOTER
        
        JPanel footerPanel = new JPanel();
        footerPanel.setLayout(new BoxLayout(footerPanel, BoxLayout.X_AXIS));
        
        JButton backBtn = new JButton("<");
        
        backBtn.addActionListener(e -> {
            main.showDefault();
        });
        
        footerPanel.add(Box.createRigidArea(new Dimension(10, 10)));
        footerPanel.add(backBtn);
        footerPanel.add(Box.createHorizontalGlue());
        
        //FONT SETTING
        
        ArrayList<Component> c = new ArrayList<>(Arrays.asList(
                nameLabel,
                nameField,
                valueLabel,
                valueField,
                typeLabel,
                typeCombo,
                submitBtn,
                warnLabel,
                backBtn
                
        ));
        
        setFont(c);
        
        //MAIN PANEL LAYOUTING
        
        //NORTH PANEL
        
        JPanel northPanel = new JPanel();
        northPanel.setLayout(new BoxLayout(northPanel, BoxLayout.Y_AXIS));
        
        northPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        northPanel.add(nameAndValPanel);
        northPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        northPanel.add(typePanel);
        northPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        northPanel.add(warnLabel);
        northPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        
        //SOUTH PANEL
        
        JPanel southPanel = new JPanel();
        southPanel.setLayout(new BoxLayout(southPanel, BoxLayout.Y_AXIS));
        
        southPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        southPanel.add(footerPanel);
        southPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        
        //MAIN PANEL
        
        setLayout(new BorderLayout());
        
        add(northPanel, BorderLayout.NORTH);
        add(new JScrollPane(accsPanel), BorderLayout.CENTER);
        add(southPanel, BorderLayout.SOUTH);
        
        showAccounts();
    }
    
    public static void setFont(ArrayList<Component> comps) {
        for (int i = 0; i < comps.size(); i++) {
            comps.get(i).setFont(new Font("MV Boli", Font.PLAIN, 24));
        }
    }
    
    void showAccounts() {
        accsPanel.removeAll();
        
        for(Account acc : common.DataBase.getAccounts()) {
            acc.buildPanel();
            accsPanel.add(acc);
        }

        
        accsPanel.revalidate();
        accsPanel.repaint();
    }
    
}