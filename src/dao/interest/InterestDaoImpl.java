package dao.interest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.JDBCUtil;
import model.Interest;


public class InterestDaoImpl implements InterestDao{

	@Override
	public List<Interest> selectAll() {
		
		List<Interest> interestList = new ArrayList<>();
		
		Connection connection = null;
		PreparedStatement pStatement= null;
		ResultSet resultSet= null;
		
		try {
			connection= JDBCUtil.getConnection();
			pStatement= connection.prepareStatement(Sql.INTEREST_SELECT_ALL_SQL);
			resultSet= pStatement.executeQuery();
			
			while(resultSet.next()) {
			
				 Interest interest= new Interest();		 
				 interest.setInt_no(resultSet.getInt("int_no"));
				 interest.setInt_name(resultSet.getString("int_name"));
				
				interestList.add(interest);

			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(resultSet, pStatement, connection);
		}
		return interestList;
	}

	
}
