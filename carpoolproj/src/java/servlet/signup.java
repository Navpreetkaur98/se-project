/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author SONY
 */
public class signup extends HttpServlet {
    
    public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException
    {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        String userName=request.getParameter("name");
        String email=request.getParameter("name2");
        String passW=request.getParameter("psw");
                String passW2=request.getParameter("psw2");

        //out.println("hello");
        out.println(userName);
        out.println(email);
        out.println(passW);
        loginDAO l = new loginDAO();
        
           String result;
        try {
            result = l.addData(userName, email, passW);
            response.sendRedirect("sgn.html");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(signup.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(signup.class.getName()).log(Level.SEVERE, null, ex);
        }
    }




