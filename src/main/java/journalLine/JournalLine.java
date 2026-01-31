/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package journalLine;

import java.awt.FlowLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author k2
 */
public class JournalLine extends JPanel{
    private String name;
    private String mode;
    private double amount;
    
    public JournalLine() {
        setLayout(new FlowLayout(FlowLayout.LEFT));
        buildPanel();
    }

    void buildPanel() {

        JTextField nameField = new JTextField(15);

        nameField.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) { sync(); }
            public void removeUpdate(DocumentEvent e) { sync(); }
            public void changedUpdate(DocumentEvent e) { sync(); }

            private void sync() {
                name = nameField.getText();
            }
        });

        JComboBox<String> modeCombo =
                new JComboBox<>(new String[]{"Debit", "Credit"});

        modeCombo.addActionListener(e ->
                mode = (String) modeCombo.getSelectedItem()
        );

        JTextField amountField = new JTextField(8);

        amountField.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) { sync(); }
            public void removeUpdate(DocumentEvent e) { sync(); }
            public void changedUpdate(DocumentEvent e) { sync(); }

            private void sync() {
                try {
                    amount = Double.parseDouble(amountField.getText());
                } catch (NumberFormatException ex) {
                    // do nothing or handle validation visually
                }
            }
        });

        add(nameField);
        add(modeCombo);
        add(amountField);
    }
    
    public String getName() {
        return this.name;
    }
    
    public double getAmount() {
        return this.amount;
    }
}
