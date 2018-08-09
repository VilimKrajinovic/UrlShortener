/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vkraji.helpers;

import com.vkraji.models.Account;
import java.nio.charset.Charset;
import java.util.Base64;

/**
 *
 * @author Vilim
 */
public class TokenDecoder {
    public static String[] decodeBasicToken(String token){
        String base64Credentials = token.substring("Basic".length()).trim();
        String credentials = new String(Base64.getDecoder().decode(base64Credentials),
                Charset.forName("UTF-8"));
        // credentials = username:password
        String[] values = credentials.split(":",2);
        return values;
    }
}
