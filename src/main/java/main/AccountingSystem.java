
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package main;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import journalEntryPage.JournalEntryPanel;

/**
 *
 * @author k2
 */
public class AccountingSystem {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame mainFrame = new JFrame("Journal Entry");
            mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            mainFrame.add(new JournalEntryPanel());

            mainFrame.pack();
            mainFrame.setLocationRelativeTo(null);
            mainFrame.setVisible(true);
        });
    }
}
