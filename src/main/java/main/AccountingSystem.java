/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package main;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import landingPage.LandingPage;
import mainFrame.MainFrame;

/**
 *
 * @author k2
 */
public class AccountingSystem {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MainFrame();
        });
    }
}
