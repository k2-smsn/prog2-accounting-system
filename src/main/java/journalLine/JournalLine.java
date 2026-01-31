/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package journalLine;

import account.Account;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JButton;
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
        
        JLabel nameLabel = new JLabel("Name: ");

        JTextField nameField = new JTextField(15);

        nameField.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) { sync(); }
            public void removeUpdate(DocumentEvent e) { sync(); }
            public void changedUpdate(DocumentEvent e) { sync(); }

            private void sync() {
                name = nameField.getText();
            }
        });
        
        JLabel modeLabel = new JLabel("Mode: ");

        JComboBox<String> modeCombo =
                new JComboBox<>(new String[]{"Debit", "Credit"});

        modeCombo.addActionListener(e ->
                mode = (String) modeCombo.getSelectedItem()
        );
        
        JLabel amountLabel = new JLabel("Amount: ");
        amountLabel.setFont(new Font("MV Boli", Font.PLAIN, 24));

        JTextField amountField = new JTextField(8);
        amountField.setFont(new Font("MV Boli", Font.PLAIN, 24));

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
        
        JButton newDelBtn = new JButton("X");
        newDelBtn.setFont(new Font("MV Boli", Font.PLAIN, 24));
        newDelBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                   Container parent = JournalLine.this.getParent();
                    if (parent != null) {
                        parent.remove(JournalLine.this);
                        parent.revalidate();
                        parent.repaint();
                    }
                }
            });        
        
        ArrayList<Component> c = new ArrayList<>(Arrays.asList(
                nameLabel,
                nameField,
                modeLabel,
                modeCombo,
                amountLabel,
                amountField
                
        ));
        
        setFont(c);
        
        add(nameLabel);
        add(nameField);
        add(modeLabel);
        add(modeCombo);
        add(amountLabel);
        add(amountField);
        add(newDelBtn);
    }
    
    public void setFont(ArrayList<Component> comps) {
        for (int i = 0; i < comps.size(); i++) {
            comps.get(i).setFont(new Font("MV Boli", Font.PLAIN, 24));
        }
    }
    
    public String getName() {
        return this.name;
    }
    
    public double getAmount() {
        return this.amount;
    }
}
