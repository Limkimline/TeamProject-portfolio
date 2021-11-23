package dao.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dao.JDBCUtil;
import dao.member.Sql;
import model.Manager;
import model.Member;

public class ManagerDaoImpl implements ManagerDao{

	@Override
	public Manager ManagerSelectByManagerNo(int managerNo) {
		Manager manager= null;
		Connection connection = null;
		PreparedStatement pStatement= null;
		ResultSet resultSet= null;
		
		try {
			connection= JDBCUtil.getConnection();
			pStatement= connection.prepareStatement(ManagerSql.MANAGER_SELECT_BY_NO_SQL);
			
			pStatement.setInt(1, managerNo); 
			
			resultSet= pStatement.executeQuery();
			if(resultSet.next()) {
				manager= new Manager();
				
				manager.setManagerno(resultSet.getInt("managerno"));
				manager.setId(resultSet.getString("id"));
				manager.setPwd(resultSet.getString("pwd"));
				manager.setName(resultSet.getString("name"));
				manager.setPhone(resultSet.getString("phone"));
				manager.setEmail(resultSet.getString("email"));
		
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(resultSet, pStatement, connection);
		}
		
		return manager;
	}
	

}
