package p1.inleveropdracht;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public interface ReizigerDao {
	
	public List<Reiziger> findAll();
	public List<Reiziger> findByGBdatum(String gbDatum);
	public Reiziger save(Reiziger reiziger);
	public Reiziger update(Reiziger reiziger);
	public boolean delete(Reiziger reiziger);
	public void closeConnection();
		

}
