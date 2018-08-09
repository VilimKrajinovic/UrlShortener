/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vkraji.responses;

/**
 *
 * @author Vilim
 */
public class RegisterResponseObject {
    private String shortUrl;

    public RegisterResponseObject(String shortUrl) {
        this.shortUrl = shortUrl;
    }
    
    

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }
    
}
