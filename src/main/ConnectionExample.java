package main;

import java.sql.*;

public class ConnectionExample {

	public static void main(String[] args) {
		 Connection conn = null;

         try
         {
             String userName = "bil372test";
             String password = "test";
             String url = "jdbc:mysql://10.10.114.143/bil372test";
             Class.forName ("com.mysql.jdbc.Driver").newInstance();
             conn = DriverManager.getConnection (url, userName, password);
             System.out.println ("Database connection established");
         }
         catch (Exception e)
         {
             System.err.println ("Cannot connect to database server");
         }
         finally
         {
             if (conn != null)
             {
                 try
                 {
                     conn.close ();
                     System.out.println ("Database connection terminated");
                 }
                 catch (Exception e) { /* ignore close errors */ }
             }
         }
	}

}
