package page;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dao.JDBCUtil;



public class PageDaoImlp implements PageDao{
	
	
	public int getCount(String sql) {

		int cnt = 0;
		Connection connection = null;
		PreparedStatement pStatement= null;
		ResultSet resultSet= null;
		
		
		try {
			connection= JDBCUtil.getConnection();
			pStatement= connection.prepareStatement(PageSql.LECTURE_COUNT_SQL);
			
			resultSet= pStatement.executeQuery();
			
			if(resultSet.next()) {

				cnt= resultSet.getInt("cnt");		
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(resultSet, pStatement, connection);
		}
		
		
		
		return cnt;
	}

	@Override
	public int getCount(String sql, String name) {
		int cnt = 0;
		Connection connection = null;
		PreparedStatement pStatement= null;
		ResultSet resultSet= null;
		
		
		try {
			connection= JDBCUtil.getConnection();
			pStatement= connection.prepareStatement(PageSql.LECTURE_COUNT_SEARCH_NAME_SQL);
			
			pStatement.setString(1, name);
			
			resultSet= pStatement.executeQuery();
			
			if(resultSet.next()) {

				cnt= resultSet.getInt("cnt");		
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(resultSet, pStatement, connection);
		}
		
		
		
		return cnt;
	}

	@Override
	public int getCount(String sql, int int_no) {
		int cnt = 0;
		Connection connection = null;
		PreparedStatement pStatement= null;
		ResultSet resultSet= null;
		
		
		try {
			connection= JDBCUtil.getConnection();
			pStatement= connection.prepareStatement(PageSql.LECTURE_COUNT_SEARCH_INT_NO_SQL);
			
			pStatement.setInt(1, int_no);
			
			resultSet= pStatement.executeQuery();
			
			if(resultSet.next()) {

				cnt= resultSet.getInt("cnt");		
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(resultSet, pStatement, connection);
		}
		
		
		
		return cnt;
	}

	@Override
	public int getCount(int userno) {
		int cnt = 0;
		Connection connection = null;
		PreparedStatement pStatement= null;
		ResultSet resultSet= null;
		
		
		try {
			connection= JDBCUtil.getConnection();
			pStatement= connection.prepareStatement(PageSql.BASKET_COUNT_SEARCH_INT_NO_SQL);
			
			pStatement.setInt(1, userno);
			
			resultSet= pStatement.executeQuery();
			
			if(resultSet.next()) {

				cnt= resultSet.getInt("cnt");	
				System.out.println("cnt:"+cnt);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(resultSet, pStatement, connection);
		}
		
		
		
		return cnt;
	}


}
