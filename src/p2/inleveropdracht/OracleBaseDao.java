package p2.inleveropdracht;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleBaseDao {
	
	private static final String DB_DRIV = "oracle.jdbc.driver.OracleDriver";
	private static final String DB_URL = "jdbc:oracle:thin:@//localhost:1521/xe";
	private static final String DB_USER = "jordy2";
	private static final String DB_PASS = "1234";
	protected static Connection conn;
	
	
	protected Connection getConnection(){
		try {
			if(conn == null) {
				conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
		
	}
	
	
	public void closeConnection(){
		try {
			if(conn != null) {
				conn.close();
			}
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		
		
	}

}