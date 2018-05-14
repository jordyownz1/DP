package p2.inleveropdracht;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Reiziger {
	
	private String naam;
	private Date gbdatum;
	private int reizigerID;
	private String voorletters;
	private String tussenvoegsel;
	private List<OVChipkaart> chipkaarten = new ArrayList<OVChipkaart>();
	
	public Reiziger(String nm, Date gbd, int rID, String vl, String tv) {
		naam = nm;
		gbdatum = gbd;
		reizigerID = rID;
		voorletters = vl;
		tussenvoegsel = tv;
		chipkaarten = null;
	}
	
	public Reiziger(String nm, Date gbd, int rID, String vl) {
		naam = nm;
		gbdatum = gbd;
		reizigerID = rID;
		voorletters = vl;
		chipkaarten = null;
	}
	
	public String getNaam() {
		return naam;
	}
	
	public void setNaam(String nm) {
		naam = nm;
	}
	
	public Date getGBdatum() {
		return gbdatum;
	}
	
	public void setGBdatum(Date gb) {
		gbdatum = gb;
	}
		
	public int getReizigerID() {
		return reizigerID;
	}

	public void setReizigerID(int reizigerID) {
		this.reizigerID = reizigerID;
	}

	public String getVoorletters() {
		return voorletters;
	}

	public void setVoorletters(String voorletters) {
		this.voorletters = voorletters;
	}

	public String getTussenvoegsel() {
		return tussenvoegsel;
	}

	public void setTussenvoegsel(String tussenvoegsel) {
		this.tussenvoegsel = tussenvoegsel;
	}

	public List<OVChipkaart> getChipkaarten() {
		return chipkaarten;
	}

	public void setChipkaarten(List<OVChipkaart> chipkaart){
		chipkaarten = chipkaart;
		
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reiziger other = (Reiziger) obj;
		if (reizigerID != other.reizigerID)
			return false;
		return true;
	}

	
	public String toString() {
		return "Reiziger [naam=" + naam + ", gbdatum=" + gbdatum + ", reizigerID=" + reizigerID + ", voorletters="
				+ voorletters + ", tussenvoegsel=" + tussenvoegsel + "]";
	}
	

	
	

}
