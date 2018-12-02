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
public class reset2 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException
    {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        String email=request.getParameter("email");
        String password2=request.getParameter("psw2");
        String password3=request.getParameter("psw3");
        
        //out.println("hello");
        out.println(email);
        out.println(password2);
        out.println(password3);
        loginDAO l = new loginDAO();
        
           String result;
        
      try {
          result = l.add(email,password2,password3);
          response.sendRedirect("res.html");
      } catch (ClassNotFoundException ex) {
          Logger.getLogger(reset2.class.getName()).log(Level.SEVERE, null, ex);
      } catch (SQLException ex) {
          Logger.getLogger(reset2.class.getName()).log(Level.SEVERE, null, ex);
      }
          
             
    }
        

    

}
