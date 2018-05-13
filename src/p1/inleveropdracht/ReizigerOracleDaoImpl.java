package p1.inleveropdracht;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ReizigerOracleDaoImpl extends OracleBaseDao implements ReizigerDao{
	
	private static ArrayList<Reiziger> deReizigers = new ArrayList<Reiziger>();

	public List<Reiziger> findAll(){
		return deReizigers;
	}
	
	public List<Reiziger> findByGBdatum(String GBdatum) {
		List<Reiziger> gevondenReizigers = new ArrayList<Reiziger>();

		for (Reiziger eenReiziger : deReizigers) {
			if (eenReiziger.getGBdatum().toString().equals(GBdatum)) {
				gevondenReizigers.add(eenReiziger);
			}
		}

		return gevondenReizigers;

	}
	
	public Reiziger save(Reiziger reiziger) {
		deReizigers.add(reiziger);
		return reiziger;
	}
	
	public Reiziger update(Reiziger reiziger) {
		int indexofObject = deReizigers.indexOf(reiziger);

		if (indexofObject != -1) {
			deReizigers.set(indexofObject, reiziger);
			return reiziger;	
		} 
		else {
			return null; //geen juist object in de array gevonden
		}
	}
	
	public boolean delete(Reiziger reiziger) {
		return deReizigers.remove(reiziger);
		
	}

	
	
}
