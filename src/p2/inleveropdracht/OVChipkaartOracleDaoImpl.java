package p2.inleveropdracht;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OVChipkaartOracleDaoImpl extends OracleBaseDao implements OVChipkaartDao{
	
	private static ArrayList<OVChipkaart> deChipkaarten = new ArrayList<OVChipkaart>();
	
	public OVChipkaartOracleDaoImpl() {
		getConnection();
	}
	
	
	public List<OVChipkaart> findByReiziger(Reiziger reiziger){
		ArrayList<OVChipkaart> chipkaartenVanReiziger = new ArrayList<OVChipkaart>();
		try {
			
			Statement stmt = conn.createStatement();
			String strQuery = "SELECT * FROM OV_CHIPKAART WHERE REIZIGERID = "+ reiziger.getReizigerID();
			ResultSet myresult = stmt.executeQuery(strQuery);
			while(myresult.next()) {
				OVChipkaart chipkaart = fillIntoObject(myresult , reiziger);
				
				chipkaartenVanReiziger.add(chipkaart);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return chipkaartenVanReiziger;
	}
	
	public List<OVChipkaart> findAll(){
		try {
			Statement stmt = conn.createStatement();
			String strQuery = "SELECT * FROM OV_CHIPKAART";
			ResultSet myresult = stmt.executeQuery(strQuery);
			while(myresult.next()) {
				OVChipkaart chipkaart = new OVChipkaart(myresult.getInt(1),
														myresult.getDate(2),
														myresult.getInt(3),
														myresult.getDouble(4),
														myresult.getInt(5));
				deChipkaarten.add(chipkaart);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return deChipkaarten;
	}

	
	public OVChipkaart save(OVChipkaart chipkaart) {
		try {
			String strQuery2 = "INSERT INTO OV_CHIPKAART(KAARTNUMMER, GELDIGTOT, KLASSE, SALDO, REIZIGERID) VALUES(?, ?, ?, ?, ?)";
			PreparedStatement pstmt2 = conn.prepareStatement(strQuery2);
			pstmt2.setInt(1, chipkaart.getKaartnummer());
			pstmt2.setDate(2, chipkaart.getGeldigTot());
			pstmt2.setInt(3, chipkaart.getKlasse());
			pstmt2.setDouble(4, chipkaart.getSaldo());
			pstmt2.setInt(5, chipkaart.getReizigerID());
			pstmt2.executeUpdate();
			
		} catch (Exception e){
			e.printStackTrace();
		}
		return chipkaart;
	
	}

	
	public OVChipkaart update(OVChipkaart chipkaart) {
		try {
			String strQuery3 = "UPDATE OV_CHIPKAART SET GELDIGTOT = ?, KLASSE = ?, SALDO = ?, REIZIGERID = ? WHERE KAARTNUMMER= ?";
			PreparedStatement pstmt3 = conn.prepareStatement(strQuery3);
			pstmt3.setDate(1, chipkaart.getGeldigTot());
			pstmt3.setInt(2, chipkaart.getKlasse());
			pstmt3.setDouble(3, chipkaart.getSaldo());
			pstmt3.setInt(4, chipkaart.getReizigerID());
			pstmt3.setInt(5, chipkaart.getKaartnummer());
			pstmt3.executeUpdate();
			
		} catch (Exception e){
			e.printStackTrace();
		}
		return chipkaart;
	}

	
	public boolean delete(OVChipkaart chipkaart) {
		try {
			String strQuery4 = "DELETE FROM OV_CHIPKAART WHERE KAARTNUMMER = ?";
			PreparedStatement pstmt4 = conn.prepareStatement(strQuery4);
			pstmt4.setInt(1, chipkaart.getKaartnummer());
			int result = pstmt4.executeUpdate();
			if(result > 0 ) {
				return true;
			} 
			
			
		} catch (Exception e){
			e.printStackTrace();
		
		}
		return false;
	}
	
	private OVChipkaart fillIntoObject(ResultSet rs, Reiziger reiziger) throws Exception{
		
			return new OVChipkaart(	rs.getInt(1),
									rs.getDate(2),
									rs.getInt(3),
									rs.getDouble(4),
									reiziger);
			
		
	}



	
}
