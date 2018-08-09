/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vkraji.helpers;

import com.vkraji.models.Account;
import com.vkraji.responses.AccountResponseObject;
import com.vkraji.models.LongUrl;
import com.vkraji.responses.RegisterResponseObject;
import com.vkraji.repo.Repository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Helper class for all the JSON responses that the server replies with
 *
 * @author Vilim
 */
public class ResponseHelper {

    /**
     * Returns a dummy object for the necessary JSON response when creating or
     * rejecting the creation of a new account
     *
     * @param account Account object that is being processed
     * @return Dummy object for JSON generation
     */
    public static AccountResponseObject getAccountCreationResponseObject(Account account) {
        if (Repository.addAccount(account)) {
            return new AccountResponseObject(true, "Your account is successfully opened", account.getPassword());
        } else {
            return new AccountResponseObject(false, "Account with that ID already exists");
        }
    }

    public static RegisterResponseObject getRegistrationResponseObject(String shortenedUrl) {
        return new RegisterResponseObject(shortenedUrl);
    }

    public static HashMap<String,Integer> getStatisticResponseObject(Account account) {
        HashMap<String, Integer > returnMap = new HashMap<>();
        
        List<LongUrl> list = new ArrayList<>(account.getShortenedUrls().values());

        list.forEach((longUrl) -> {
            returnMap.put(longUrl.getUrl(), longUrl.getRedirectCount());
        });
        return returnMap;
    }
}
