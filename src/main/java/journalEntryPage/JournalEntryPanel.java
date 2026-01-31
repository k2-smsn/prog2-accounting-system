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
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class JournalEntryPanel extends JPanel{
    
    private DatePanel datePanel;
    private JTextField descriptionField;
    private JTable lineTable;
    private DefaultTableModel tableModel;

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

        JPanel journLinesPanel = new JPanel();

        return new JScrollPane(journLinesPanel);
    }

    
    private JPanel createButtonPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        JButton addLineBtn = new JButton("Add Line");
        JButton removeLineBtn = new JButton("Remove Line");

        addLineBtn.addActionListener(e ->
                tableModel.addRow(new Object[]{"", "FROM", BigDecimal.ZERO})
        );

        removeLineBtn.addActionListener(e -> {
            int row = lineTable.getSelectedRow();
            if (row >= 0) {
                tableModel.removeRow(row);
            }
        });

        panel.add(addLineBtn);
        panel.add(removeLineBtn);

        return panel;
    }

    public LocalDate getDate() {
        return datePanel.getDate();
    }

    public String getDescription() {
        return descriptionField.getText();
    }

    public DefaultTableModel getLineModel() {
        return tableModel;
    }
}

