/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import servlet.loginDAO;

/**
 *
 * @author SONY
 */
public class outstation2 extends HttpServlet {

   
    public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException
    {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        String pickup=request.getParameter("pickup");
        String dropin=request.getParameter("dropin");
        
        //out.println("hello");
        out.println(pickup);
        out.println(dropin);
        loginDAO l = new loginDAO();
        
           String result;
        
        try {
            result = l.add(pickup,dropin);
            response.sendRedirect("booking.html"");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(outstation2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(outstation2.class.getName()).log(Level.SEVERE, null, ex);
        }
           
             
    }
        

    

}
