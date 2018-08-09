/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vkraji.helpers;

import com.vkraji.commons.Commons;
import java.security.SecureRandom;

/**
 *
 * @author Vilim
 */
public class StringGenerator {

    static final String ALPHANUMERIC = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    static final String ALPHABETIC = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    static SecureRandom r = new SecureRandom();

    public static String generateAlphaNumeric(int len) {
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            sb.append(ALPHANUMERIC.charAt(r.nextInt(ALPHANUMERIC.length())));
        }
        return sb.toString();
    }
    
    public static String generateShortUrlCode(int len) {
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            sb.append(ALPHABETIC.charAt(r.nextInt(ALPHABETIC.length())));
        }
        return sb.toString();
    }
    
}
