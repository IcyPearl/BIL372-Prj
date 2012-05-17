package main;

import java.sql.*;

public class ConnectionExample {

	public static void main(String[] args) {
		 Connection conn = null;

         try
         {
             String userName = "bil372test";
             String password = "test";
             String url = "jdbc:mysql://mefu.mine.nu/bil372test";
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
            	 Statement stmt = null;
            	 String qry="select * from test";
                 try
                 {
                	 stmt=conn.createStatement();
                	 ResultSet rs = stmt.executeQuery(qry);
                	 while(rs.next())
                		 System.out.println(rs.getString("test1"));
                     conn.close ();
                     System.out.println ("Database connection terminated");
                 }
                 catch (Exception e) {/* ignore close errors */ }
             }
         }
	}

}
