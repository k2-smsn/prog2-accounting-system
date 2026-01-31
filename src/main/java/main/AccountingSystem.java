/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package main;

import javax.swing.JFrame;
import journalEntryPage.JournalEntryPanel;

/**
 *
 * @author k2
 */
public class AccountingSystem {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        JournalEntryPanel journEntryPanel = new JournalEntryPanel();
        
        JFrame main = new JFrame();
        main.add(journEntryPanel);
        
        main.setVisible(true);
        main.pack();
    }
}
