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
public class contact2 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
  public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException
    {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        String name=request.getParameter("name");
        String email=request.getParameter("email");
        String message=request.getParameter("message");
        
        //out.println("hello");
        out.println(name);
        out.println(email);
        out.println(message);
        loginDAO l = new loginDAO();
        
           String result;
        
      try {
          result = l.add(name,email,message);
          response.sendRedirect("cont.html");
      } catch (ClassNotFoundException ex) {
          Logger.getLogger(contact2.class.getName()).log(Level.SEVERE, null, ex);
      } catch (SQLException ex) {
          Logger.getLogger(contact2.class.getName()).log(Level.SEVERE, null, ex);
      }
          
             
    }
        

    

}
