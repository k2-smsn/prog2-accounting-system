/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package journalEntryPage;

/**
 *
 * @author k2
 */

import datePanel.DatePanel;
import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import journalLine.JournalLine;

public class JournalEntryPanel extends JPanel{
    
    private DatePanel datePanel;
    private JTextField descriptionField;
    private JPanel journLinesPanel = new JPanel();

    public JournalEntryPanel() {
        setLayout(new BorderLayout(10, 10));

        add(createHeaderPanel(), BorderLayout.NORTH);
        add(createTablePanel(), BorderLayout.CENTER);
        add(createButtonPanel(), BorderLayout.SOUTH);
    }

    private JPanel createHeaderPanel() {
        JPanel panel = new JPanel(new GridLayout(2, 1, 5, 5));

        datePanel = new DatePanel();

        JPanel descPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        descPanel.add(new JLabel("Description:"));
        descriptionField = new JTextField(30);
        descPanel.add(descriptionField);

        panel.add(datePanel);
        panel.add(descPanel);

        return panel;
    }

    private JScrollPane createTablePanel() {
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

        panel.add(addLineBtn);
        panel.add(submitBtn);

        return panel;
    }

    public LocalDate getDate() {
        return datePanel.getDate();
    }

    public String getDescription() {
        return descriptionField.getText();
    }
    
}

