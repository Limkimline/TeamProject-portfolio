package dao.basket;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.JDBCUtil;
import model.Basket;
import model.Lecture;
import page.PageManager;
import page.PageRowResult;

public class BasketDaoImpl implements BasketDao{

	@Override
	public void insert(Basket basket) {
		Connection connection = null;
		PreparedStatement pStatement= null;
		
		try {
			connection= JDBCUtil.getConnection();
			pStatement= connection.prepareStatement(Sql.BASKET_INSERT);

			pStatement.setInt(1, basket.getUserno()); 
			pStatement.setInt(2, basket.getLectureno()); 

			pStatement.executeUpdate();

			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(null, pStatement, connection);
		}
		
	}

	@Override
	public void delete(int userno, int lectureno) {
		Connection connection = null;
		PreparedStatement pStatement= null;
		
		try {
			connection= JDBCUtil.getConnection();
			pStatement= connection.prepareStatement(Sql.BASKET_DELETE);
			 
			pStatement.setInt(1, userno); 
			pStatement.setInt(2, lectureno); 
	
			pStatement.executeUpdate();
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}finally {
			
			JDBCUtil.close(null, pStatement, connection);
			
		}
	}




	@Override
	public void deleteDate(int userno) {
		
		Connection connection = null;
		PreparedStatement pStatement= null;
		
		try {
			connection= JDBCUtil.getConnection();
			pStatement= connection.prepareStatement(Sql.BASKET_DATE_DELETE);
			 
			pStatement.setInt(1, userno); 
	
			pStatement.executeUpdate();
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}finally {
			
			JDBCUtil.close(null, pStatement, connection);
			
		}
		
	}
	
	
	@Override
	public List<Lecture> selectByUserno(int userno) {
		List<Lecture> lectureList = new ArrayList<>();
		Connection connection = null;
		PreparedStatement pStatement= null;
		ResultSet resultSet= null;
		
		try {
			connection= JDBCUtil.getConnection();
			pStatement= connection.prepareStatement(Sql.BASKET_SELECT_BY_USERNO);
			
			pStatement.setInt(1,userno); 
			
			resultSet= pStatement.executeQuery();
			
			while(resultSet.next()) {
				Lecture lecture= new Lecture();
				
				lecture.setLectureno(resultSet.getInt("lectureno"));
				lecture.setName(resultSet.getString("name"));
				lecture.setContent(resultSet.getString("content"));
				lecture.setStartdate(resultSet.getString("startdate").substring(0,10));
				lecture.setEnddate(resultSet.getString("enddate").substring(0,10));
				lecture.setStarttime(resultSet.getString("starttime"));
				lecture.setEndtime(resultSet.getString("endtime"));
				lecture.setRec_startdate(resultSet.getString("rec_startdate").substring(0,10));
				lecture.setRec_enddate(resultSet.getString("rec_enddate").substring(0,10));
				lecture.setRec_cnt(resultSet.getInt("rec_cnt"));
				lecture.setReq_cnt(resultSet.getInt("req_cnt"));
				lecture.setImagename(resultSet.getString("imagename"));
				lecture.setClickcount(resultSet.getInt("clickcount"));
				lecture.setUserno(resultSet.getInt("userno"));
				lecture.setInt_no(resultSet.getInt("int_no"));
				lectureList.add(lecture);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(resultSet, pStatement, connection);
		}
		
		return lectureList;
	}
	
	
	@Override
	public List<Lecture> selectByUserno(int userno, int requestPage) {
		List<Lecture> lectureList = new ArrayList<>();
		Connection connection = null;
		PreparedStatement pStatement= null;
		ResultSet resultSet= null;
		
		try {
			connection= JDBCUtil.getConnection();
			pStatement= connection.prepareStatement(Sql.BASKET_SELECT_BY_USERNO_PAGING);
			//?매니저의 도움으로 셋팅
			PageManager pm = new PageManager(requestPage);
			PageRowResult prr= pm.getBasketPageRowResult();
			
			pStatement.setInt(1, userno); 
			pStatement.setInt(2, prr.getRowStartNumber()); 
			pStatement.setInt(3, prr.getRowEndNumber()); 
			
			resultSet= pStatement.executeQuery();
			
			
			while(resultSet.next()) {
				
				Lecture lecture= new Lecture();
				
				lecture.setLectureno(resultSet.getInt("lectureno"));
				lecture.setName(resultSet.getString("name"));
				lecture.setContent(resultSet.getString("content"));
				lecture.setStartdate(resultSet.getString("startdate").substring(0,10));
				lecture.setEnddate(resultSet.getString("enddate").substring(0,10));
				lecture.setStarttime(resultSet.getString("starttime"));
				lecture.setEndtime(resultSet.getString("endtime"));
				lecture.setRec_startdate(resultSet.getString("rec_startdate").substring(0,10));
				lecture.setRec_enddate(resultSet.getString("rec_enddate").substring(0,10));
				lecture.setRec_cnt(resultSet.getInt("rec_cnt"));
				lecture.setReq_cnt(resultSet.getInt("req_cnt"));
				lecture.setImagename(resultSet.getString("imagename"));
				lecture.setClickcount(resultSet.getInt("clickcount"));
				lecture.setUserno(resultSet.getInt("userno"));
				lecture.setInt_no(resultSet.getInt("int_no"));
				lectureList.add(lecture);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(resultSet, pStatement, connection);
		}
		return lectureList;
	}
}
