package dao.manager;

import model.Manager;

public interface ManagerDao {

	Manager ManagerSelectByManagerNo(int managerNo);
}
