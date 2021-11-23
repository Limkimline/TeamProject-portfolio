package dao.manager;

import model.Manager;

public class Test {

	public static void main(String[] args) {
		
		ManagerDao managerDao = new  ManagerDaoImpl();
		Manager manager = managerDao.ManagerSelectByManagerNo(1);
		
		System.out.println(manager );
	}
	
	
	
	
}
