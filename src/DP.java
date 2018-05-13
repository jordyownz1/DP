import java.sql.*;

public class DP {
	
	

	public static void main(String[] args) {
		try {
		Connection myConn = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe", "jordy", "1234");	
		Statement myStmt = myConn.createStatement();
		ResultSet myresult = myStmt.executeQuery("SELECT * FROM MEDEWERKERS");
		while(myresult.next()) {
			System.out.println(myresult.getString("MNR")+ " " + myresult.getString("NAAM"));
		}
				
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
