package p2.inleveropdracht;

import java.sql.ResultSet;
import java.util.List;

public interface OVChipkaartDao {
	
	public List<OVChipkaart> findByReiziger(Reiziger reiziger);
	public List<OVChipkaart> findAll();
	public OVChipkaart save(OVChipkaart chipkaart);
	public OVChipkaart update(OVChipkaart chipkaart);
	public boolean delete(OVChipkaart chipkaart);
	
}
