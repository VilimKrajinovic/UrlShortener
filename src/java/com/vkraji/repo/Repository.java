/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vkraji.repo;

import com.vkraji.models.Account;
import com.vkraji.models.LongUrl;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Vilim
 */
public class Repository {
    private static List<Account> registeredAccounts;
    
    static{
        registeredAccounts = new ArrayList<>();
    }
    
    public static List<Account> getAccounts(){
        return registeredAccounts;
    }
    
    public static LongUrl getLongUrlForUrlCode(String urlCode){
        LongUrl returnValue = null;
        for (Account account : registeredAccounts) {
            returnValue = account.getShortenedUrls().get(urlCode);
            if(returnValue != null){
                break;
            }
        }
        return returnValue;
    }
    
    public static Boolean addAccount(Account account){
        if(!checkIfAccountExists(account)){
            account.generatePassword();
            registeredAccounts.add(account);
            return true;
        }else{
            return false;
        }
    }

    private static Boolean checkIfAccountExists(Account account) {
        Boolean exists = false;
        for (Account registeredAccount : registeredAccounts) {
            if(account.getAccountId().equals(registeredAccount.getAccountId())){
                exists = true;
            }
        }
        return exists;
    }
    
    public static Account getAccountForCredentials(String[] credentials){
        
        Account toVerify = new Account(credentials);
        
        for (Account account : registeredAccounts) {
            if(account.equals(toVerify)){
                return account;
            }
        }
        return null;
    }
    
}
