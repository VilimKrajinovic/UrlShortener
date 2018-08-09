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
import com.vkraji.helpers.StringGenerator;
import com.vkraji.helpers.TokenDecoder;
import com.vkraji.models.Account;
import com.vkraji.models.LongUrl;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Vilim
 */
public class RegisterServlet extends HttpServlet {

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
        response.getWriter().print("Please make a POST request containing a valid JSON which contains the required fields. ");
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

        String authToken = request.getHeader(Commons.AUTHORIZATION);
        if (authToken != null && authToken.startsWith("Basic")) {
            Gson gson = new Gson();

            String[] credentials = TokenDecoder.decodeBasicToken(authToken);
            LongUrl url = gson.fromJson(request.getReader(), LongUrl.class);

            Account account = Authenticator.checkCredentials(credentials);

            String jsonResponse;

            if (account != null) {

                String urlCode = StringGenerator.generateShortUrlCode(Commons.URL_CODE_LEN);
                StringBuilder sb = new StringBuilder();
                sb.append(Commons.BASE_URL);
                sb.append(urlCode);
                account.getShortenedUrls().put(urlCode, url);

                jsonResponse = gson.toJson(ResponseHelper.getRegistrationResponseObject(sb.toString()));
            } else {
                jsonResponse = "{'description':'Bad request'}";
                response.sendError(HttpServletResponse.SC_BAD_REQUEST);
            }

            response.getWriter().print(jsonResponse);
        } else {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "This servlet registers a shortened URL";
    }// </editor-fold>

}
