/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package journalEntryPage;

/**
 *
 * @author k2
 */

import account.Account;
import java.awt.Component;
import datePanel.DatePanel;
import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import journalLine.JournalLine;
import mainFrame.MainFrame;

public class JournalEntryPanel extends JPanel{
    
    private DatePanel datePanel;
    private JTextField descriptionField;
    private JPanel journLinesPanel = new JPanel();
    private MainFrame main;
    
    ArrayList<JournalLine> JournLines = new ArrayList<>();
    private ArrayList<Account> accountsInline = new ArrayList<>();

    public JournalEntryPanel(MainFrame main) {
        this.main = main;
        
        setLayout(new BorderLayout(10, 10));

        add(createHeaderPanel(), BorderLayout.NORTH);
        add(createJournLinesPanel(), BorderLayout.CENTER);
        add(createButtonPanel(), BorderLayout.SOUTH);
    }

    private JPanel createHeaderPanel() {
        JPanel panel = new JPanel(new GridLayout(2, 1, 5, 5));

        datePanel = new DatePanel();

        JPanel descPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel descLabel = new JLabel("Description:");
        
        descriptionField = new JTextField(25);
        
        ArrayList<Component> c = new ArrayList<>(Arrays.asList(descLabel, descriptionField));
        setFont(c);
        
        descPanel.add(descLabel);
        descPanel.add(descriptionField);
        
        panel.add(datePanel);
        panel.add(descPanel);

        return panel;
    }

    private JScrollPane createJournLinesPanel() {
        journLinesPanel.setLayout(new BoxLayout(journLinesPanel, BoxLayout.Y_AXIS));
        return new JScrollPane(journLinesPanel);
    }

    
    private JPanel createButtonPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        
        JButton backBtn = new JButton("<");
        JButton addLineBtn = new JButton("Add Line");
        JButton submitBtn = new JButton("Submit");
        
        backBtn.addActionListener(e -> {
            main.showDefault();
        });
        
        addLineBtn.addActionListener(e -> {
            journLinesPanel.add(new JournalLine());
            journLinesPanel.revalidate();
            journLinesPanel.repaint();
        });

        submitBtn.addActionListener(e -> {
            getAccountsInLines();
            makeTransaction();
            
            journLinesPanel.removeAll();
            journLinesPanel.revalidate();
            journLinesPanel.repaint();
        });
        
        ArrayList<Component> c = new ArrayList<>(Arrays.asList(backBtn, addLineBtn, submitBtn));
        setFont(c);
        
        panel.add(Box.createRigidArea(new Dimension(10, 0)));
        panel.add(backBtn);
        panel.add(Box.createHorizontalGlue());
        panel.add(addLineBtn);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));
        panel.add(submitBtn);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));

        return panel;
    }
    
    public void setFont(ArrayList<Component> comps) {
        for (int i = 0; i < comps.size(); i++) {
            comps.get(i).setFont(new Font("MV Boli", Font.PLAIN, 24));
        }
    }

    public LocalDate getDate() {
        return datePanel.getDate();
    }

    public String getDescription() {
        return descriptionField.getText();
    }
    
    public void getAccountsInLines() {
        JournLines.clear();
        for(int i = 0; i < journLinesPanel.getComponentCount(); i++) {
            if (journLinesPanel.getComponent(i) instanceof JournalLine) {
                JournLines.add((JournalLine) journLinesPanel.getComponent(i));
            }
        }
        
        /*
        accountsInline.clear();
        for(int i = 0; i < JournLines.size(); i++) {
            accountsInline.add(JournLines.get(i).getAccount());
            System.out.println(accountsInline);
        }*/
    }
    
    public void makeTransaction() {
        for(int i = 0; i < JournLines.size(); i++) {
            Account acc = JournLines.get(i).getAccount();
            String operation = JournLines.get(i).getOperation();
            double amount = JournLines.get(i).getAmount();
            acc.setValue(operation, amount);
        }
        
        /*
        for(int i = 0; i < common.DataBase.getAccounts().size(); i++) {
            Account acc = common.DataBase.getAccounts().get(i);
            System.out.println(acc.getValue());
        }
        */
        
        System.out.println(common.DataBase.getAccValues());
        
        
        JournLines.clear();
        
    }
}

