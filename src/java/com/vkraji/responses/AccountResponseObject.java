/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vkraji.responses;

/**
 * Dummy POJO that is used for serializing data to a JSON response
 * @author Vilim
 */
public class AccountResponseObject {

    public Boolean success;
    public String description;
    public String password;

    
    public AccountResponseObject(Boolean success, String description, String password) {
        this.success = success;
        this.description = description;
        this.password = password;
    }

    public AccountResponseObject(Boolean success, String description) {
        this.success = success;
        this.description = description;
    }

    public Boolean getSuccess() {
        return success;
    }

    public String getDescription() {
        return description;
    }

    public String getPassword() {
        return password;
    }

}
