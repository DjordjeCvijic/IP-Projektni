package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	private final static String url = "jdbc:postgresql://localhost:5432/web_museums_db";
	private final static String user = "postgres";
	private final static String password = "postgres";
	private static Connection connection=null;
	

    private static Connection connect() {
        Connection conn = null;
        try {
        	Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        return conn;
    }
    
    public static Connection getConnection() {
    	if(connection==null) {
    		connection= connect();
    	}
    	return connection;
    	
    }

}
