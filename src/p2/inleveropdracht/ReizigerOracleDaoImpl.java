package p2.inleveropdracht;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ReizigerOracleDaoImpl extends OracleBaseDao implements ReizigerDao {
	
	OVChipkaartOracleDaoImpl oDao = new OVChipkaartOracleDaoImpl();

	private static ArrayList<Reiziger> deReizigers = new ArrayList<Reiziger>();

	public ReizigerOracleDaoImpl() {
		getConnection();
	}

	public List<Reiziger> findAll() {
		try {
			
			Statement stmt = conn.createStatement();
			String strQuery = "SELECT * FROM REIZIGER";
			ResultSet myresult = stmt.executeQuery(strQuery);
			while (myresult.next()) {
				Reiziger reiziger = new Reiziger(myresult.getString("ACHTERNAAM"), 
												myresult.getDate("GEBORTEDATUM"),
												myresult.getInt("REIZIGERID"), 
												myresult.getString("VOORLETTERS"),
												myresult.getString("TUSSENVOEGSEL"));
												
				deReizigers.add(reiziger);
			}
			
			for(Reiziger r : deReizigers) {
				List <OVChipkaart> chipkaarten = new ArrayList <OVChipkaart>();
				chipkaarten = oDao.findByReiziger(r);
				r.setChipkaarten(chipkaarten);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return deReizigers;

	}

	public List<Reiziger> findByGBdatum(String GBdatum) {
		ArrayList<Reiziger> deReizigersByGB = new ArrayList<Reiziger>();
		
		try {
			String strQuery1 = "SELECT * FROM REIZIGER WHERE GEBORTEDATUM = ?";
			PreparedStatement pstmt1 = conn.prepareStatement(strQuery1);
			pstmt1.setString(1, GBdatum);
			ResultSet myresult = pstmt1.executeQuery();
			while (myresult.next()) {
				Reiziger reiziger = new Reiziger(myresult.getString("ACHTERNAAM"), 
												myresult.getDate("GEBORTEDATUM"),
												myresult.getInt("REIZIGERID"), 
												myresult.getString("VOORLETTERS"),
												myresult.getString("TUSSENVOEGSEL"));
				deReizigersByGB.add(reiziger);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return deReizigersByGB;
		
	}
	
	public Reiziger findByID(int ID) throws Exception{		
		
		Reiziger r1 = null;
		String strQuery1 = "SELECT * FROM REIZIGER WHERE REIZIGERID = ?";
		PreparedStatement pstmt1 = conn.prepareStatement(strQuery1);
		pstmt1.setInt(1, ID);
		ResultSet myresult = pstmt1.executeQuery();
		while (myresult.next()) {
			r1 = new Reiziger(myresult.getString("ACHTERNAAM"), 
							myresult.getDate("GEBORTEDATUM"),
							myresult.getInt("REIZIGERID"), 
							myresult.getString("VOORLETTERS"),
							myresult.getString("TUSSENVOEGSEL"));
		}
		return r1;
	}

	public Reiziger save(Reiziger reiziger) {
		
		
		try {
			String strQuery2 = "INSERT INTO REIZIGER(ACHTERNAAM, GEBORTEDATUM, REIZIGERID, VOORLETTERS, TUSSENVOEGSEL) VALUES(?, ?, ?, ?, ?)";
			PreparedStatement pstmt2 = conn.prepareStatement(strQuery2);
			pstmt2.setString(1, reiziger.getNaam());
			pstmt2.setDate(2, reiziger.getGBdatum());
			pstmt2.setInt(3, reiziger.getReizigerID());
			pstmt2.setString(4, reiziger.getVoorletters());
			pstmt2.setString(5, reiziger.getTussenvoegsel());
			pstmt2.executeUpdate();
			
		} catch (Exception e){
			e.printStackTrace();
		}
		return reiziger;
	}

	public Reiziger update(Reiziger reiziger) {
		try {
			String strQuery3 = "UPDATE REIZIGER SET ACHTERNAAM = ?, GEBORTEDATUM = ?, VOORLETTERS = ?, TUSSENVOEGSEL = ? WHERE REIZIGERID = ?";
			PreparedStatement pstmt3 = conn.prepareStatement(strQuery3);
			pstmt3.setString(1, reiziger.getNaam());
			pstmt3.setDate(2, reiziger.getGBdatum());
			pstmt3.setString(3, reiziger.getVoorletters());
			pstmt3.setString(4, reiziger.getTussenvoegsel());
			pstmt3.setInt(5, reiziger.getReizigerID());
			pstmt3.executeUpdate();
			
		} catch (Exception e){
			e.printStackTrace();
		}
		return reiziger;
	}

	public boolean delete(Reiziger reiziger) {
		try {
			String strQuery4 = "DELETE FROM REIZIGER WHERE REIZIGERID = ?";
			PreparedStatement pstmt4 = conn.prepareStatement(strQuery4);
			pstmt4.setInt(1, reiziger.getReizigerID());
			int result = pstmt4.executeUpdate();
			if(result > 0 ) {
				return true;
			}
			
			
		} catch (Exception e){
			e.printStackTrace();
		}
		return false;
		
	}
	
	private Reiziger fillIntoObject(ResultSet rs) throws SQLException {
		
			return new Reiziger(rs.getString(4),
								rs.getDate(5),
								rs.getInt(1),
								rs.getString(2),
								rs.getString(3)
								);
		
	}

}
