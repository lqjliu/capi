package com.common.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLTest {
	public static void main(String[] args) {
        try {
            // The newInstance() call is a work around for some
            // broken Java implementations

            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn = 
                DriverManager.getConnection("jdbc:mysql://localhost:3306/caru?" + 
                                            "user=root&password=pass");
            System.out.println(conn);
        } catch (Exception ex) {
            ex.printStackTrace();
        	// handle the error
        }
	}

}
