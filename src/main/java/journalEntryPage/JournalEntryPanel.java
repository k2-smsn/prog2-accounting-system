/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package journalEntryPage;

/**
 *
 * @author k2
 */

import java.awt.Component;
import datePanel.DatePanel;
import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import journalLine.JournalLine;

public class JournalEntryPanel extends JPanel{
    
    private DatePanel datePanel;
    private JTextField descriptionField;
    private JPanel journLinesPanel = new JPanel();

    public JournalEntryPanel() {
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
        
        descriptionField = new JTextField(30);
        descPanel.add(descriptionField);
        
        ArrayList<Component> c = new ArrayList<>(Arrays.asList(descLabel, descriptionField));
        setFont(c);
        
        descPanel.add(descLabel);
        panel.add(datePanel);
        panel.add(descPanel);

        return panel;
    }

    private JScrollPane createJournLinesPanel() {
        journLinesPanel.setLayout(new BoxLayout(journLinesPanel, BoxLayout.Y_AXIS));
        return new JScrollPane(journLinesPanel);
    }

    
    private JPanel createButtonPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        JButton addLineBtn = new JButton("Add Line");
        JButton submitBtn = new JButton("Submit");

        addLineBtn.addActionListener(e -> {
            journLinesPanel.add(new JournalLine());
            journLinesPanel.revalidate();
            journLinesPanel.repaint();
        });


        submitBtn.addActionListener(e -> {});
        
        ArrayList<Component> c = new ArrayList<>(Arrays.asList(addLineBtn, submitBtn));
        setFont(c);

        panel.add(addLineBtn);
        panel.add(submitBtn);

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
    
}

