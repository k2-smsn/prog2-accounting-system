/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ledgerPage;

import account.Account;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import mainFrame.MainFrame;

/**
 *
 * @author k2
 */
public class ledgerPanel extends JPanel {
    private MainFrame main;
    private JLabel totalLabel;
    private JComboBox accCombo;
    private JTable table;
    private DefaultTableModel tableModel;
    
    public ledgerPanel(MainFrame main) {
        this.main = main;
        setLayout(new BorderLayout());
        
        createNorthPanel();
        createCenterPanel();
        createFooter();
        
        updatTable();
    }
    
    private void createNorthPanel() {
        JPanel northPanel = new JPanel();
        northPanel.setLayout(new BoxLayout(northPanel, BoxLayout.X_AXIS));
        
        accCombo = new JComboBox(common.DataBase.getAccounts().toArray(new Account[0]));
        accCombo.setFont(new Font("MV Boli", Font.PLAIN, 24));
        
        accCombo.addActionListener(e -> {
            updatTable();
        });
        
        totalLabel = new JLabel("Bayag");
        totalLabel.setFont(new Font("MV Boli", Font.PLAIN, 24));
        
        northPanel.add(Box.createRigidArea(new Dimension(10, 0)));
        northPanel.add(accCombo);
        northPanel.add(Box.createHorizontalGlue());
        northPanel.add(totalLabel);
        northPanel.add(Box.createRigidArea(new Dimension(10, 0)));
        
        add(northPanel, BorderLayout.NORTH);
    }
    
    private void createCenterPanel() {
        String[] columns = {"Date", "Description", "Debit", "Credit"};
        tableModel = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // make read only
            }
        };
        
        table = new JTable(tableModel);
        table.setFont(new Font("MV Boli", Font.PLAIN, 24));
        table.setRowHeight(22); 
        table.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 20));


        
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);
    }
    
    private void createFooter() {
        JPanel footerPanel = new JPanel();
        footerPanel.setLayout(new BoxLayout(footerPanel, BoxLayout.X_AXIS));
        
        JButton backBtn = new JButton("<");
        backBtn.setFont(new Font("MV Boli", Font.PLAIN, 24));
        
        backBtn.addActionListener(e -> {
            main.showDefault();
        });
        
        footerPanel.add(Box.createRigidArea(new Dimension(10, 10)));
        footerPanel.add(backBtn);
        footerPanel.add(Box.createHorizontalGlue());
        
        add(footerPanel, BorderLayout.SOUTH);
    }
    
    private void updatTable() {
        tableModel.setRowCount(0); // clear existing rows

        Account selectedAccount = (Account) accCombo.getSelectedItem();
        if (selectedAccount == null) return;
        
        double total = 0;
        
        ArrayList<ArrayList<String>> currentEntries = selectedAccount.getEntries();

        for (int i = 0; i < currentEntries.size(); i++) {
            //double debit = Double.parseDouble(entries.get(i).get(2));
            //double credit = Double.parseDouble(entries.get(i).get(3));
            total = selectedAccount.getValue();
            
            ArrayList<String> currentEntry = currentEntries.get(i);

            String[] row = {currentEntry.get(0), currentEntry.get(1), currentEntry.get(2), currentEntry.get(3)};
            tableModel.addRow(row);
        }

        totalLabel.setText("Total: " + total);
    }
}
