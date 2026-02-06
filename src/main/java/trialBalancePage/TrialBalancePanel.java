/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trialBalancePage;

import account.Account;
import java.awt.BorderLayout;
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
public class TrialBalancePanel extends JPanel {
    private MainFrame main;
    private JLabel totalLabel;
    private JComboBox accCombo;
    private JTable table;
    private DefaultTableModel tableModel;
    
    public TrialBalancePanel(MainFrame main) {
        this.main = main;
        setLayout(new BorderLayout());
            
        createCenterPanel();
        createFooter();
    }
    
    private void createCenterPanel() {
        ArrayList<Account> accounts = common.DataBase.getAccounts();

        String[] columns = {"Account", "Debit", "Credit"};
        tableModel = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        double totalDebit = 0;
        double totalCredit = 0;

        for (Account acc : accounts) { //loop through acc
            double debit = 0;
            double credit = 0; //initialize debit and credit for acc

            if (acc.getNormalSide().equals("Debit")) { //process if account's normal side is debit
                double balance = acc.getTotalDebit() - acc.getTotalCredit();
                if (balance > 0) {
                    debit = balance;
                    totalDebit += balance; //accumulate total debit
                }
            } else { //process if credit
                double balance = acc.getTotalCredit() - acc.getTotalDebit();
                if (balance > 0) {
                    credit = balance;
                    totalCredit += balance; //accumulate total credit
                }
            }

            tableModel.addRow(new Object[]{
                acc.getName(),
                String.format("%.2f", debit),
                String.format("%.2f", credit)
            });
        }

        tableModel.addRow(new Object[]{
            "TOTAL",
            String.format("%.2f", totalDebit),
            String.format("%.2f", totalCredit)
        });


        table = new JTable(tableModel);
        table.setFont(new Font("SansSerif", Font.PLAIN, 18));
        table.setRowHeight(26);
        table.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 18));

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
}