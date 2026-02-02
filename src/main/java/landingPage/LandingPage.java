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
import mainFrame.MainFrame;

/**
 *
 * @author k2
 */
public class LandingPage extends JPanel{
    public LandingPage(MainFrame main) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        JButton coaBtn = new JButton("Chart of Accounts");
        coaBtn.addActionListener(e -> {
            main.showPanel(main.coaPanel);
        }); 
        
        JButton journEntryBtn = new JButton("Journal Entry");
        journEntryBtn.addActionListener(e -> {
            main.showPanel(main.journEntryPanel);
        }); 
        
        JButton ledgerBtn = new JButton("Ledger");
        ledgerBtn.addActionListener(e -> {
            
        }); 
        
        JButton trialBalBtn = new JButton("Trial Balance");
        trialBalBtn.addActionListener(e -> {
            
        }); 
        
        JButton reportBtn = new JButton("Financial report");
        reportBtn.addActionListener(e -> {
            
        }); 
        
        add(coaBtn);
        add(journEntryBtn);
    }
    
}
