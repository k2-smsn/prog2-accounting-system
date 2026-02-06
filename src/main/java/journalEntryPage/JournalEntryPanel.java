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
    private JLabel warnLabel = new JLabel();
    private MainFrame main;
    
    private ArrayList<JournalLine> JournLines = new ArrayList<>();

    public JournalEntryPanel(MainFrame main) {
        this.main = main;
        
        setLayout(new BorderLayout(10, 10)); 
        
        //ADD PANELS IN LAYOUT
        add(createHeaderPanel(), BorderLayout.NORTH);
        add(createJournLinesPanel(), BorderLayout.CENTER);
        add(createButtonPanel(), BorderLayout.SOUTH);
    }

    private JPanel createHeaderPanel() {
        JPanel panel = new JPanel(new GridLayout(2, 1, 5, 5)); //GRID LAYOUT

        datePanel = new DatePanel();

        JPanel descPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel descLabel = new JLabel("Description:");
        
        descriptionField = new JTextField(25);
        
        ArrayList<Component> c = new ArrayList<>(Arrays.asList(descLabel, descriptionField));
        setFont(c);
        
        descPanel.add(descLabel);
        descPanel.add(descriptionField); //ADD COMPONENTS
        
        panel.add(datePanel);
        panel.add(descPanel);

        return panel; //returns the header panel
    }

    private JScrollPane createJournLinesPanel() { //Create journal lines container panel
        journLinesPanel.setLayout(new BoxLayout(journLinesPanel, BoxLayout.Y_AXIS));
        return new JScrollPane(journLinesPanel); //MAKE PANEL SCROLLABLE
    }

    
    private JPanel createButtonPanel() { //create new entry button function
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        
        JButton backBtn = new JButton("<");
        JButton addLineBtn = new JButton("Add Line");
        JButton submitBtn = new JButton("Submit");
        
        backBtn.addActionListener(e -> { //BACK TO HOME FUNC
            main.showDefault();
        });
        
        addLineBtn.addActionListener(e -> {
            if(!JournLines.isEmpty()) {
                journLinesPanel.add(new JournalLine()); //INITIALIZE NEW JOURNAL LINE OBJECT TO CONTAINER
                journLinesPanel.revalidate();
                journLinesPanel.repaint();
            }
            else {
                warnLabel.setText("NO ACCOUNTS YET"); //HANDLE IF NO ACCOUNTS ARE CREATED
            }
            
        });

        submitBtn.addActionListener(e -> {
            
            try {
                getJournalLines();
                makeTransaction();

                journLinesPanel.revalidate();
                journLinesPanel.repaint();
            } 
            catch (Exception ex) { //handle submit error
                warnLabel.setText("Journal entry error");
            }
            
        });
        
        ArrayList<Component> c = new ArrayList<>(Arrays.asList(backBtn, addLineBtn, submitBtn, warnLabel));
        setFont(c);
        
        panel.add(Box.createRigidArea(new Dimension(10, 0)));
        panel.add(backBtn);
        panel.add(Box.createHorizontalGlue());
        panel.add(warnLabel); //INCLUDE WARNING LABEL
        panel.add(Box.createHorizontalGlue());
        panel.add(addLineBtn);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));
        panel.add(submitBtn);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));

        return panel;
    }
    
    //HELPER FUNCTIONS
    
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
    
    public void getJournalLines() {
        for(int i = 0; i < journLinesPanel.getComponentCount(); i++) {
            if (journLinesPanel.getComponent(i) instanceof JournalLine) {
                JournLines.add((JournalLine) journLinesPanel.getComponent(i));
            }
        }
    }
    
    public void makeTransaction() { //MAIN FUNCTION WHEN SUBMITTING
        if(JournLines.isEmpty()) {
            warnLabel.setText("NO ACCOUNTS YET"); //HANDLE IF NO ACCOUNTS ARE CREATED
            return;
        }
        
        int debitCount = 0;
        int creditCount = 0;
        
        for(int i = 0; i < JournLines.size(); i++) { // DEBIT/CREDIT VALIDATION LOOP
            if(JournLines.get(i).getMode().equals("Debit")) {
                debitCount += 1;
            }
            else {
                creditCount += 1;
            }
        }
        
        if(debitCount == creditCount) { //DEBIT/CREDIT VALIDATION
            LocalDate date = datePanel.getDate();
            String desc = descriptionField.getText();
            
            for(int i = 0; i < JournLines.size(); i++) {
                Account acc = JournLines.get(i).getAccount();
                String mode = JournLines.get(i).getMode();
                double amount = JournLines.get(i).getAmount();
                
                if(mode.equals("Debit")) {
                    acc.debit(date, desc, amount); //debit account
                    
                }
                
                else { //if it's not debit then it's credit
                    acc.credit(date, desc, amount);
                }
            }
            
            JournLines.clear(); //CLEAR JOURNAL LINES CONTAINER FOR NEW ENTRY
            journLinesPanel.removeAll();
        }
        
        else {
            warnLabel.setText("CREDIT AND DEBIT ARE NOT BALANCED");
        }
        
    }
    
}

