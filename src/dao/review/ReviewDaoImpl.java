package dao.review;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import dao.JDBCUtil;
import dao.general_qna.GeneralQnaSql;
import model.General_Qna;
import model.Review;
import model.ViewReviewSelect;
import page.PageManager;
import page.PageRowResult;

public class ReviewDaoImpl implements ReviewDao{

	@Override
	public void reviewInsertByInfoNo(Review review) {
		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(ReviewSql.REVIEW_INSERT_BY_INFONO_SQL);
			
			pStatement.setInt(1, review.getInfono());
			pStatement.setString(2, review.getContent());
			pStatement.setInt(3, (int)review.getScore());
			
			pStatement.executeUpdate(); // Äõ¸® ½ÇÇà
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			JDBCUtil.close(null, pStatement, connection);
		}
	}


	
	@Override
	public List<ViewReviewSelect> reviewSelectMy() {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public List<ViewReviewSelect> selectReviewBylectureNo(int lectureNo) {
		List<ViewReviewSelect> viewReviewSelectList = new ArrayList<ViewReviewSelect>();
		ResultSet resultSet = null;
		Connection connection = null;
		PreparedStatement pStatement = null;
		
			try {
				connection = JDBCUtil.getConnection();
				pStatement = connection.prepareStatement(ReviewSql.REVIEW_SElECT_BY_LECTURENO_SQL);
				pStatement.setInt(1, lectureNo);
				
				resultSet = pStatement.executeQuery();
				
				while(resultSet.next()) {
					
					ViewReviewSelect viewReviewSelect = new ViewReviewSelect();
					
					
					viewReviewSelect .setId(resultSet.getString("id"));
					viewReviewSelect .setContent(resultSet.getString("content"));
					
					viewReviewSelect.setScore(resultSet.getInt("score"));
					
					viewReviewSelect.setWriteDate(resultSet.getString("writedate"));
				
					viewReviewSelectList.add(viewReviewSelect);
				}
				
			} catch (Exception e) {

			}finally {
				JDBCUtil.close(resultSet, pStatement, connection);
			}
		
		return viewReviewSelectList;
	
			
	}


	@Override
	public int ReviewCntByLectureno(int lectureno) {
		
		int cnt = 0 ;
		ResultSet resultSet = null;
		Connection connection = null;
		PreparedStatement pStatement = null;
		
			try {
				connection = JDBCUtil.getConnection();
				pStatement = connection.prepareStatement(ReviewSql.REVIEW_COUNT_BY_LECTURENO_SQL);
				pStatement.setInt(1, lectureno);
				resultSet = pStatement.executeQuery();
				
				while(resultSet.next()) {
					
					cnt = resultSet.getInt("cnt");
				}
			} catch (Exception e) {

			}finally {
				JDBCUtil.close(null, pStatement, connection);
			}
		
		
		return cnt;
	}


	@Override
	public List<ViewReviewSelect> selectReviewByLectureNoToPage(int requestPage, int lectureno) {
List<ViewReviewSelect> reviewList = new ArrayList<ViewReviewSelect>() ;
		
		ResultSet resultSet = null;
		Connection connection = null;
		PreparedStatement pStatement = null;
		
			try {
				connection = JDBCUtil.getConnection();
				pStatement = connection.prepareStatement(ReviewSql.REVIEW_SElECT_BY_LECTURENO_TO_PAGE_SQL);
				PageManager pm = new PageManager(requestPage);
				PageRowResult prr = pm.getQnaPageRowResult();
				pStatement.setInt(1, lectureno);
				pStatement.setInt(2, prr.getRowStartNumber());
				pStatement.setInt(3, prr.getRowEndNumber());
				
				resultSet = pStatement.executeQuery();
				
				while(resultSet.next()) {
					
					ViewReviewSelect vrs = new ViewReviewSelect();
					vrs.setContent(resultSet.getString("content"));
					vrs.setScore(resultSet.getDouble("score"));
					vrs.setId(resultSet.getString("id"));
					vrs.setWriteDate(resultSet.getString("writedate"));
					
					reviewList.add(vrs);
				}
				
			} catch (Exception e) {

			}finally {
				JDBCUtil.close(null, pStatement, connection);
			}
		
		
		return reviewList;
		
		
		
	}
	
	public List<ViewReviewSelect> selectReviewByLectureNoToDetail(int requestPage, int lectureno) {
		List<ViewReviewSelect> reviewList = new ArrayList<ViewReviewSelect>() ;

		ResultSet resultSet = null;
		Connection connection = null;
		PreparedStatement pStatement = null;
		
			try {
				connection = JDBCUtil.getConnection();
				pStatement = connection.prepareStatement(ReviewSql.REVIEW_SElECT_BY_LECTURENO_TO_PAGE_SQL);
				PageManager pm = new PageManager(1);
				PageRowResult prr = pm.getPageRowResult();
				pStatement.setInt(1, lectureno);
				pStatement.setInt(2, 1);
				pStatement.setInt(3, 5);
				
				resultSet = pStatement.executeQuery();
				
				while(resultSet.next()) {
					
					ViewReviewSelect vrs = new ViewReviewSelect();
					vrs.setContent(resultSet.getString("content"));
					vrs.setScore(resultSet.getDouble("score"));
					vrs.setId(resultSet.getString("id"));
					vrs.setWriteDate(resultSet.getString("writedate"));
					
					reviewList.add(vrs);
				}
				
			} catch (Exception e) {

			}finally {
				JDBCUtil.close(null, pStatement, connection);
			}
		
		
		return reviewList;
		
		
		
	}



}
