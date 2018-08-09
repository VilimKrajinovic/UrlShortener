/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vkraji.models;

/**
 *
 * @author Vilim
 */
public class LongUrl {
    private String url;
    private int redirectType;
    private int redirectCount;

    public LongUrl() {
        redirectCount = 0;
        setRedirectType(302);
    }
    
    public LongUrl(String url, int statusCode) {
        this.url = url;
        this.redirectType = statusCode;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getRedirectType() {
        return redirectType;
    }

    public void setRedirectType(int statusCode) {
        this.redirectType = statusCode;
    }

    public int getRedirectCount() {
        return redirectCount;
    }
    
    
    
    /**
     * Increments the view count by one
     */
    public void increment(){
        redirectCount++;
    }
    
    
}
