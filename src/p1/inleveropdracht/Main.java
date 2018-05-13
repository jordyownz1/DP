package p1.inleveropdracht;


import java.sql.Date;
import java.util.List;

public class Main {
	
	public static void main(String[] args) {
		
		ReizigerDao rDao = new ReizigerOracleDaoImpl();
		
		Date d1 = new Date(387654321);
		Date d2 = new Date(687654321);
		Date d3 = new Date(987654321);
		
		Reiziger r1 = new Reiziger("Zenik", d1, 1, "J");
		Reiziger r2 = new Reiziger("Taal", d2, 2, "R");
		Reiziger r3 = new Reiziger("Linden", d3, 3, "S", "van der");
		Reiziger r4 = new Reiziger("Zenik", d1, 1, "J");
		Reiziger r5 = new Reiziger("Taal", d1, 1, "J");
		
		System.out.println("Save");
		
		rDao.save(r1);
		rDao.save(r2);
		rDao.save(r3);
		printAll(rDao);
		
		System.out.println("Delete");
		rDao.delete(r2);
		printAll(rDao);
		
		System.out.println("update");
		System.out.println(rDao.update(r5));
		printAll(rDao);
		
		System.out.println("findbyGB");
		System.out.println("find by gbdatum = d1" + rDao.findByGBdatum(d1.toString()));
		System.out.println("find by gbdatum = d2" + rDao.findByGBdatum(d2.toString()));
		System.out.println("find by gbdatum = d3" + rDao.findByGBdatum(d3.toString()));
	}

	
	
	
	
	
	
	
	private static void printAll(ReizigerDao r) {
		List<Reiziger> rList = r.findAll();
		System.out.println("Opgeslagen reizigers");
		for(Reiziger persoon : rList) {
			System.out.println(persoon);
		}
		System.out.println("\n");
	}
}
