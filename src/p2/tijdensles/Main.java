package p2.tijdensles;


import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;


public class Main {
	
	public static void main(String[] args) throws Exception {
		String startDate="26-09-95";
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yy");
		java.util.Date date = sdf1.parse(startDate);
		java.sql.Date sqlDate = new java.sql.Date(date.getTime()); 
		
		ReizigerDao rDao = new ReizigerOracleDaoImpl();
		
		Reiziger r1 = new Reiziger("Zenik", sqlDate, 6, "J");
		Reiziger r2 = new Reiziger("de Bruijn", sqlDate, 7, "G");
		Reiziger r3 = new Reiziger("de Bruijn", sqlDate, 7, "G, D, C");
		
		System.out.println("findAll \n" + rDao.findAll());
		System.out.println();
		
		
		System.out.println("findByGBdatum 17-09-02 \n" + rDao.findByGBdatum("17-09-02"));
		System.out.println();
		
		
		System.out.println("Save reiziger \n" + rDao.save(r2));
		System.out.println();
		
		
		System.out.println("update reiziger \n" + rDao.update(r3) );
		System.out.println();
		
		
		System.out.println("delete " + rDao.delete(r2));
		System.out.println("delete " + rDao.delete(r3));
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
