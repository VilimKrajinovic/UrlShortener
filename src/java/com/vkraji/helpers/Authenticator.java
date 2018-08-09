/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vkraji.helpers;

import com.vkraji.models.Account;
import com.vkraji.repo.Repository;

/**
 *
 * @author Vilim
 */
public class Authenticator {
    
    /**
     * Returns the sucessfuly authenticated account or null if no match was found
     * @return 
     */
    public static Account checkCredentials(String[] credentials){
        for (Account account : Repository.getAccounts()) {
            if(account.getAccountId().equals(credentials[0]) && account.getPassword().equals(credentials[1])){
                return account;
            }
        }
        return null;
    }
}
