package p1.inleveropdracht;

import java.sql.Connection;
import java.sql.DriverManager;

public class OracleBaseDao {
	
	private static final String DB_DRIV = "oracle.jdbc.driver.OracleDriver";
	private static final String DB_URL = "jdbc:oracle:thin:@//localhost:1521/xe";
	private static final String DB_USER = "jordy";
	private static final String DB_PASS = "1234";
	private static Connection conn;
	
	protected void getConnection() {
		try {
			Class.forName(DB_DRIV).newInstance();
			
		} 
		catch (InstantiationException | IllegalAccessException | ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public void closeConnection() {
		try {
			conn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}
}
