package p2.inleveropdracht;

import java.sql.Date;

public class OVChipkaart {
	private int kaartnummer;
	private Date geldigTot;
	private int klasse;
	private double saldo;
	private int reizigerID;
	private Reiziger reiziger;
	
	
	public OVChipkaart(int knr, Date gt, int kl, double sld, Reiziger r){
		kaartnummer = knr;
		geldigTot = gt;
		klasse = kl;
		saldo = sld;
		reiziger = r;
		
	}
	
	public OVChipkaart(int knr, Date gt, int kl, double sld, int rID){
		kaartnummer = knr;
		geldigTot = gt;
		klasse = kl;
		saldo = sld;
		reizigerID = rID;
		
	}
	
	public OVChipkaart(int knr, Date gt, int kl, int rID){
		kaartnummer = knr;
		geldigTot = gt;
		klasse = kl;
		saldo = 0.0;
		reizigerID = rID;
	}

	public int getKaartnummer() {
		return kaartnummer;
	}

	public void setKaartnummer(int kaartnummer) {
		this.kaartnummer = kaartnummer;
	}

	public Date getGeldigTot() {
		return geldigTot;
	}

	public void setGeldigTot(Date geldigTot) {
		this.geldigTot = geldigTot;
	}

	public int getKlasse() {
		return klasse;
	}

	public void setKlasse(int klasse) {
		this.klasse = klasse;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public int getReizigerID() {
		return reizigerID;
	}

	public void setReizigerID(int reizigerID) {
		this.reizigerID = reizigerID;
	}
	
	public Reiziger getReiziger() {
		return reiziger;
	}

	public void setReiziger(Reiziger reiziger) {
		this.reiziger = reiziger;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OVChipkaart other = (OVChipkaart) obj;
		if (kaartnummer != other.kaartnummer)
			return false;
		if (reizigerID != other.reizigerID)
			return false;
		return true;
	}

	public String toString() {
		return "OVChipkaart [kaartnummer=" + kaartnummer + ", geldigTot=" + geldigTot + ", klasse=" + klasse
				+ ", saldo=" + saldo + ", reizigerID=" + reizigerID + ", reiziger=" + reiziger + "]";
	}
	
	

}
