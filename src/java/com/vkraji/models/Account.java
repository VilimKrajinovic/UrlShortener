/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vkraji.models;

import com.vkraji.commons.Commons;
import com.vkraji.helpers.StringGenerator;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Vilim
 */
public class Account {
    public String accountId;
    public String password;
    
    /**
     * 
     */
    public Map<String, LongUrl> shortenedUrls;

    public Account(){
        shortenedUrls = new HashMap<>();
    }
    
    public Account(String AccountId, String password) {
        this.accountId = AccountId;
        this.password = password;
    }
    
    public Account(String[] credentials){
        this.accountId = credentials[0];
        this.password = credentials[1];
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String AccountId) {
        this.accountId = AccountId;
    }

    public String getPassword() {
        return password;
    }

    private void setPassword(String password) {
        this.password = password;
    }
    
    public void generatePassword(){
        setPassword(StringGenerator.generateAlphaNumeric(Commons.PASSWORD_LEN));
    }

    public Map<String, LongUrl> getShortenedUrls() {
        return shortenedUrls;
    }
    
    
}
