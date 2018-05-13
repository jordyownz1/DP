package p2.inleveropdracht;

public class Main2 {

	public static void main(String [] args) throws Exception{
		
		OVChipkaartDao oDao = new OVChipkaartOracleDaoImpl();
		ReizigerDao rDao = new ReizigerOracleDaoImpl();
		
		OVChipkaart o1 = new OVChipkaart(666, java.sql.Date.valueOf("2020-09-26"), 1, 31, 3);
		OVChipkaart o2 = new OVChipkaart(666, java.sql.Date.valueOf("2020-09-26"), 1, 3100, 3);
		
		Reiziger r1 = rDao.findByID(2);
		
		System.out.println("find all \n" + oDao.findAll());
		System.out.println();
		
		System.out.println("Save \n" + oDao.save(o1));
		System.out.println();
		
		System.out.println("update \n" + oDao.update(o2));
		System.out.println();
		
		System.out.println("Delete \n" + oDao.delete(o1));
		System.out.println();
		
		System.out.println("find by reiziger\n" + oDao.findByReiziger(r1) );
	}
}
