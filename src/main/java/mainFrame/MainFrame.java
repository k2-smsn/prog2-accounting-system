/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainFrame;

import chartOfAccPage.ChartOfAccPanel;
import java.awt.GridBagLayout;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import journalEntryPage.JournalEntryPanel;
import landingPage.LandingPage;

/**
 *
 * @author k2
 */
public class MainFrame extends JFrame{
    private JPanel defaultPanel = new LandingPage(this);
    public ChartOfAccPanel coaPanel = new ChartOfAccPanel(this);
    public JournalEntryPanel journEntryPanel = new JournalEntryPanel(this);
    
    public MainFrame() {
        showDefault();
        
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    public void showDefault() {
        setContentPane(defaultPanel);
        revalidate();
        repaint();
    }

    public void showPanel(JPanel panel) {
        setContentPane(panel);
        revalidate();
        repaint();
    }
}
