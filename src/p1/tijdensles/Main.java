package p1.tijdensles;

//Vergeet deze import niet
import java.sql.*;

public class Main {
	//Zorg ter voorbereiding dat je ojdbc.jar download en toevoegt aan je project.
	
	//Aanmaken van de variabelen die je connectie specificeren. In dit geval een gebruiker "harry" met password "harry"
	//Deze code gebruikt de tabel afdelingen van de casus uit het leerboek 
	private static final String DB_DRIV = "oracle.jdbc.driver.OracleDriver";
	private static final String DB_URL = "jdbc:oracle:thin:@//localhost:1521/xe";
	private static final String DB_USER = "jordy";
	private static final String DB_PASS = "1234";
	private static Connection conn;
	
	
	
	// De methode die met JDBC aan de slag gaat moet een SQLException opvangen of gooien
	public static void main(String[] args) throws SQLException{
		//Besluit welke driver je gaat gebruiken voor je verbinding		
		try {
			Class.forName(DB_DRIV).newInstance();
		} 
		catch (InstantiationException | IllegalAccessException | ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
		
//////////STATEMENT 1!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		Statement stmt = conn.createStatement();
		String strQuery1 = "SELECT * FROM CURSUSSEN";
		ResultSet myresult = stmt.executeQuery(strQuery1);
		while(myresult.next()) {
			System.out.println(myresult.getString("CODE")+ " " + myresult.getString("OMSCHRIJVING"));
		}
/////////STATEMENT 2!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		//String strQuery2 = "DELETE FROM CURSUSSEN WHERE CODE ='JOR'";
		//stmt.executeUpdate(strQuery2);
		//System.out.println("code verwijdert uit databse");
		
/////////STATEMENT 3!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		//String strQuery3 = "INSERT INTO CURSUSSEN(CODE, OMSCHRIJVING, TYPE, LENGTE) VALUES('JOR', 'IS ECHT EEN ZIEK G', 'BLD', 4)";
		//stmt.executeUpdate(strQuery3);
		//System.out.println("code toegevoegd in databse");
		
/////////STATEMENT 4!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		
		//String strQuery4 = "DELETE FROM CURSUSSEN WHERE CODE = ?";
		//PreparedStatement pstmt = conn.prepareStatement(strQuery4);
		//pstmt.setString(1, "JOR");
		//pstmt.executeUpdate();
		//System.out.println("CURSUS VERWIJDERT.\n");	//daarmee je ziet hoe ver je komt
		
/////////STATEMENT 5!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		
		//String strQuery5 = "UPDATE CURSUSSEN SET CODE = ? WHERE CODE = ?";
		//PreparedStatement pstmt2 = conn.prepareStatement(strQuery5);
		//pstmt2.setString(1, "JOD");
		//pstmt2.setString(2, "JOR");
		//pstmt2.executeUpdate();
		//System.out.println("CURSUS GEUPDATE.\n");	//daarmee je ziet hoe ver je komt

/////////STATEMENT 6!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		
		String strQuery6 = "INSERT INTO CURSUSSEN(CODE, OMSCHRIJVING, TYPE, LENGTE) VALUES(?, ?, ?, ?)";
		PreparedStatement pstmt3 = conn.prepareStatement(strQuery6);
		pstmt3.setString(1, "JOR");
		pstmt3.setString(2, "JORDY IS ECHT COOL");
		pstmt3.setString(3, "BLD");
		pstmt3.setString(4, "4");
		pstmt3.executeUpdate();
		System.out.println("CURSUS JOR TOEGEVOEGD.\n");	//daarmee je ziet hoe ver je komt
	}
}