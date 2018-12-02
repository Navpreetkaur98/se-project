/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author SONY
 */
public class loginDAO {
    public String checkInfo(String userName,String passW) throws ClassNotFoundException, SQLException
    {
        Connection con=null;
        PreparedStatement pr=null;
            String myUrl="jdbc:mysql://localhost/carpool";
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection(myUrl,"root","");
           
            String query="select * from tb1 where username=? and password=?";
            pr=con.prepareStatement(query);
            pr.setString(1,userName);
            pr.setString(2,passW);
            ResultSet rs;
            rs=pr.executeQuery();
            if(rs.next())
            {
                return "you are logged in";
            }
           
                return "incorrect data";

            
    }
    public String addData(String username,String email,String password) throws ClassNotFoundException, SQLException
    {
        Connection con=null;
        PreparedStatement pr=null;
            String myUrl="jdbc:mysql://localhost/carpool";
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection(myUrl,"root","");
           
            String query="insert into tb1(username,email,password) values(?,?,?)";
            pr=con.prepareStatement(query);
            pr.setString(1,username);
            pr.setString(2,email);
            pr.setString(3,password);
            int rs = pr.executeUpdate();
            if(rs>0)
            {
                return "data inserted successfully";
            }
            return "data not inserted";
    }
    public String add(String pickup,String dropin) throws ClassNotFoundException, SQLException
    {
        Connection con=null;
        PreparedStatement pr=null;
            String myUrl="jdbc:mysql://localhost/carpool";
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection(myUrl,"root","");
           
            String query="insert into tb2(pickup,dropin) values(?,?)";
            pr=con.prepareStatement(query);
            pr.setString(1,pickup);
            pr.setString(2,dropin);
            
            int rs = pr.executeUpdate();
            if(rs>0)
            {
                return "booked";
            }
            return "not found";
    }
    public String add(String name,String email,String message) throws ClassNotFoundException, SQLException
    {
        Connection con=null;
        PreparedStatement pr=null;
            String myUrl="jdbc:mysql://localhost/carpool";
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection(myUrl,"root","");
           
            String query="insert into tb3(name,email,message) values(?,?,?)";
            pr=con.prepareStatement(query);
            pr.setString(1,name);
            pr.setString(2,email);
             pr.setString(3,message);
            
            int rs = pr.executeUpdate();
            if(rs>0)
            {
                return "mail sent";
            }
            return "incorrect data";
    }
     public String add1(String email,String password2,String password3) throws ClassNotFoundException, SQLException
    {
        Connection con=null;
        PreparedStatement pr=null;
            String myUrl="jdbc:mysql://localhost/carpool";
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection(myUrl,"root","");
           
            String query="insert into tb4(email,password2,password3) values(?,?,?)";
            pr=con.prepareStatement(query);
            pr.setString(1,email);
            pr.setString(2,password2);
             pr.setString(3,password3);
            
            int rs = pr.executeUpdate();
            if(rs>0)
            {
                return "reset";
            }
            return "incorrect";
    }
    public static void main(String args[]) throws ClassNotFoundException, SQLException
    {
        loginDAO l = new loginDAO();
        String result = l.addData("manish", "asdfasdf","manish123");
        System.out.println(result);
    }
    
}











    

