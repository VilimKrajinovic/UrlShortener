/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vkraji.servlets;

import com.google.gson.Gson;
import com.vkraji.commons.Commons;
import com.vkraji.helpers.Authenticator;
import com.vkraji.helpers.ResponseHelper;
import com.vkraji.helpers.TokenDecoder;
import com.vkraji.models.Account;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Vilim
 */
public class StatisticServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        String authToken = request.getHeader(Commons.AUTHORIZATION);
        if (authToken != null) {
            
            Account account = Authenticator.checkCredentials(TokenDecoder.decodeBasicToken(authToken));
            if (account != null) {
                //username from URL
                String pathInfo = request.getPathInfo().substring(1);
                if (pathInfo != null && pathInfo.equals(account.getAccountId())) {
                    Gson gson = new Gson();
                    
                    String jsonResponse = gson.toJson(ResponseHelper.getStatisticResponseObject(account));
                    response.getWriter().print(jsonResponse);
                } else {
                    response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
                }
            } else {
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
            }
        } else {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
        }
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
