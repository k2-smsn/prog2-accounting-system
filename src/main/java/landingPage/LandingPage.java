/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package landingPage;

import chartOfAccPage.ChartOfAccPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import journalEntryPage.JournalEntryPanel;
import ledgerPage.ledgerPanel;
import mainFrame.MainFrame;
import trialBalancePage.TrialBalancePanel;

/**
 *
 * @author k2
 */
public class LandingPage extends JPanel{
    public LandingPage(MainFrame main) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        JButton coaBtn = new JButton("Chart of Accounts");
        coaBtn.addActionListener(e -> {
            main.setTitle("Chart Of Accounts");
            main.showPanel(new ChartOfAccPanel(main));
        }); 
        
        JButton journEntryBtn = new JButton("Journal Entry");
        journEntryBtn.addActionListener(e -> {
            main.setTitle("Journal Entry");
            main.showPanel(new JournalEntryPanel(main));
        }); 
        
        JButton ledgerBtn = new JButton("Ledger");
        ledgerBtn.addActionListener(e -> {
            main.setTitle("Ledger");
            main.showPanel(new ledgerPanel(main));
        }); 
        
        JButton trialBalBtn = new JButton("Trial Balance");
        trialBalBtn.addActionListener(e -> {
            main.setTitle("Trial Balance");
            main.showPanel(new TrialBalancePanel(main));
        }); 
        
        JButton reportBtn = new JButton("Financial report");
        reportBtn.addActionListener(e -> {
            
        }); 
        
        add(coaBtn);
        add(journEntryBtn);
        add(ledgerBtn);
        add(trialBalBtn);
    }
    
}
