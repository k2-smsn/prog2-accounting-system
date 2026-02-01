/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package common;

import account.Account;
import java.util.ArrayList;

/**
 *
 * @author k2
 */
public class DataBase {
    private static ArrayList<Account> accounts = new ArrayList<>();
    
    public static ArrayList<Account> getAccounts() {
        return accounts;
    }
    
    public static void addAccount(Account newAccount) {
        accounts.add(newAccount);
    }
    
    public static ArrayList<String> getAccNames() {
        ArrayList<String> accNames = new ArrayList<>();
        
        for(int i = 0; i < accounts.size(); i++) {
            accNames.add(accounts.get(i).getName());
        }
        
        return accNames;
    }
    
    public static void removeAcc(Account a) {
        for(int i = 0; i < accounts.size(); i++) {
            if(accounts.get(i).getId().equals(a.getId())) {
                accounts.remove(i);
                break;
            }
        }
    }
        
}
