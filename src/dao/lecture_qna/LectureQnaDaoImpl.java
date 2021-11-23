package dao.lecture_qna;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import dao.JDBCUtil;
import model.Lecture_Qna;
import page.PageManager;
import page.PageRowResult;

public class LectureQnaDaoImpl implements LectureQnaDao {

	@Override
	public void LecturelQnaInsert(Lecture_Qna lq) {
		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(LectureQnaSql.LECTURE_QNA_INSERT_SQL);
			
			
			pStatement.setString(1, lq.getSubject());
			pStatement.setString(2, lq.getContent());;
			pStatement.setString(3, lq.getOpen());
			pStatement.setInt(4, lq.getUserno());
			pStatement.setInt(5, lq.getLectureno());
			pStatement.executeUpdate(); // 孽府 角青
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			JDBCUtil.close(null, pStatement, connection);
		}
		
	}

	@Override
	public void LectureQnaInsertByNoMember(Lecture_Qna lq) {
		
		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(LectureQnaSql.LECTURE_QNA_INSERT_BY_NOMEMBER_SQL);
			
			
			pStatement.setString(1, lq.getSubject());
			pStatement.setString(2, lq.getContent());;
			pStatement.setString(3, lq.getOpen());
			pStatement.setInt(4, lq.getLectureno());
			pStatement.executeUpdate(); // 孽府 角青
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			JDBCUtil.close(null, pStatement, connection);
		}
		
		
		
	}

	@Override
	public List<Lecture_Qna> LectrueQnaSearchByLectureno(int lectureno) {
		List<Lecture_Qna> lqList = new ArrayList<Lecture_Qna>() ;
		ResultSet resultSet = null;
		Connection connection = null;
		PreparedStatement pStatement = null;
		
			try {
				connection = JDBCUtil.getConnection();
				pStatement = connection.prepareStatement(LectureQnaSql.LECTURE_QNA_SELECT_BY_LECTURENO_SQL);
				pStatement.setInt(1, lectureno);
				resultSet = pStatement.executeQuery();
				
				while(resultSet.next()) {
					
					Lecture_Qna lq = new Lecture_Qna();
					lq.setQnano(resultSet.getInt("qnano"));
					lq.setSubject(resultSet.getString("subject"));
					lq.setContent(resultSet.getString("content"));
					lq.setAnswer(resultSet.getString("answer"));
					lq.setClickCount(new AtomicInteger(resultSet.getInt("clickcount")));
					lq.setOpen(resultSet.getString("open"));
					lq.setWriteDate(resultSet.getString("writedate"));
					lq.setUserno(resultSet.getInt("userno"));
					lq.setLectureno(resultSet.getInt("lectureno"));
					lqList.add(lq);
				}
				
			} catch (Exception e) {

			}finally {
				JDBCUtil.close(resultSet, pStatement, connection);
			}
		
		return lqList;
	
	}



	@Override
	public Lecture_Qna LectureQnaSelectByQnaNo(int qnaNo) {
		Lecture_Qna lq = new Lecture_Qna() ;
		ResultSet resultSet = null;
		Connection connection = null;
		PreparedStatement pStatement = null;
		
			try {
				connection = JDBCUtil.getConnection();
				pStatement = connection.prepareStatement(LectureQnaSql.LECTURE_QNA_SELECT_BY_QNANO_SQL);
				pStatement.setInt(1, qnaNo);
				
				resultSet = pStatement.executeQuery();
				
				while(resultSet.next()) {
					
					
					lq.setQnano(resultSet.getInt("qnano"));
					lq.setSubject(resultSet.getString("subject"));
					lq.setContent(resultSet.getString("content"));
					lq.setAnswer(resultSet.getString("answer"));
					
					lq.setClickCount(new AtomicInteger(resultSet.getInt("clickcount")));
					lq.setOpen(resultSet.getString("open"));
					lq.setWriteDate(resultSet.getString("writedate"));
					lq.setUserno(resultSet.getInt("userno"));
					lq.setLectureno(resultSet.getInt("lectureno"));
				}
				
			} catch (Exception e) {

			}finally {
				JDBCUtil.close(resultSet, pStatement, connection);
			}
		
		return lq;
	}

	
	@Override
	public void LectureQnaUpdateByQnaNo(Lecture_Qna lq) {
		Connection connection = null;
		PreparedStatement pStatement = null;
		
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(LectureQnaSql.LECTURE_QNA_UPDATE_BY_QNANO);
			
			
			pStatement.setString(1, lq.getSubject());
			pStatement.setString(2, lq.getContent());
			pStatement.setString(3, lq.getAnswer());
			pStatement.setString(4, lq.getOpen());
			pStatement.setInt(5, lq.getQnano());
		
			pStatement.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			JDBCUtil.close(null, pStatement, connection);
		}
	
	}

	
	
	
	@Override
	public void LectureQnaDeleteByQnano(int qnano) {
		
		Connection connection = null;
		PreparedStatement pStatement = null;
		
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(LectureQnaSql.LECTURE_QNA_DELETE_BY_QNANO_SQL);
			
			pStatement.setInt(1, qnano);
			
			pStatement.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			JDBCUtil.close(null, pStatement, connection);
		}
	
		
	}
	
	@Override
	public List<Lecture_Qna> selectByLectureNoToPage(int requestPage ,int lectureno) {
	
	List<Lecture_Qna> lqList = new ArrayList<Lecture_Qna>() ;
		
		ResultSet resultSet = null;
		Connection connection = null;
		PreparedStatement pStatement = null;
		
			try {
				connection = JDBCUtil.getConnection();
				pStatement = connection.prepareStatement(LectureQnaSql.LECTURE_QNA_SElECT_BY_LECTURENO_TO_PAGE_SQL);
				PageManager pm = new PageManager(requestPage);
				PageRowResult prr = pm.getQnaPageRowResult();
				pStatement.setInt(1, lectureno);
				pStatement.setInt(2, prr.getRowStartNumber());
				pStatement.setInt(3, prr.getRowEndNumber());
				
				resultSet = pStatement.executeQuery();
				
				while(resultSet.next()) {
					
					Lecture_Qna lq = new Lecture_Qna();
					lq.setQnano(resultSet.getInt("qnano"));
					lq.setSubject(resultSet.getString("subject"));
					lq.setContent(resultSet.getString("content"));
					lq.setAnswer(resultSet.getString("answer"));
					lq.setClickCount(new AtomicInteger(resultSet.getInt("clickcount")));
					lq.setOpen(resultSet.getString("open"));
					lq.setWriteDate(resultSet.getString("writedate"));
					lq.setUserno(resultSet.getInt("userno"));
					lq.setLectureno(resultSet.getInt("lectureno"));
					lqList.add(lq);
				}
				
			} catch (Exception e) {

			}finally {
				JDBCUtil.close(null, pStatement, connection);
			}
		
		
		return lqList;
		
		
	
	
	}

	
	
	
	@Override
	public List<Lecture_Qna> selectByLecturenoAndUsernoToPage( int requestPage,int lectureno,  int userno ) {
		
		List<Lecture_Qna> lqList = new ArrayList<Lecture_Qna>() ;
		ResultSet resultSet = null;
		Connection connection = null;
		PreparedStatement pStatement = null;
		
			try {
				connection = JDBCUtil.getConnection();
				pStatement = connection.prepareStatement(LectureQnaSql.LECTURE_QNA_SElECT_BY_LECTURENO_AND_USERNO_TO_PAGE_SQL);
				PageManager pm = new PageManager(requestPage);
				PageRowResult prr = pm.getQnaPageRowResult();
				pStatement.setInt(1, lectureno);
				pStatement.setInt(2, userno);
				pStatement.setInt(3, prr.getRowStartNumber());
				pStatement.setInt(4, prr.getRowEndNumber());
				
				resultSet = pStatement.executeQuery();
				
				while(resultSet.next()) {
					
					Lecture_Qna lq = new Lecture_Qna();
					lq.setQnano(resultSet.getInt("qnano"));
					lq.setSubject(resultSet.getString("subject"));
					lq.setContent(resultSet.getString("content"));
					lq.setAnswer(resultSet.getString("answer"));
					lq.setClickCount(new AtomicInteger(resultSet.getInt("clickcount")));
					lq.setOpen(resultSet.getString("open"));
					lq.setWriteDate(resultSet.getString("writedate"));
					lq.setUserno(resultSet.getInt("userno"));
					lq.setLectureno(resultSet.getInt("lectureno"));
					lqList.add(lq);
				}
				
			} catch (Exception e) {

			}finally {
				JDBCUtil.close(null, pStatement, connection);
			}
		
		
		return lqList;
		
		
		
	}

	
	
	
	@Override
	public List<Lecture_Qna> selectByLecturenoAndSubjectToPage( int requestPage, int lectureno, String subject ) {
	
		List<Lecture_Qna> lqList = new ArrayList<Lecture_Qna>() ;
		ResultSet resultSet = null;
		Connection connection = null;
		PreparedStatement pStatement = null;
		
			try {
				connection = JDBCUtil.getConnection();
				pStatement = connection.prepareStatement(LectureQnaSql.LECTURE_QNA_SElECT_BY_LECTURENO_AND_SUBJECT_TO_PAGE_SQL);
				PageManager pm = new PageManager(requestPage);
				PageRowResult prr = pm.getQnaPageRowResult();
				pStatement.setInt(1, lectureno);
				pStatement.setString(2, subject);
				pStatement.setInt(3, prr.getRowStartNumber());
				pStatement.setInt(4, prr.getRowEndNumber());
				
				resultSet = pStatement.executeQuery();
				
				while(resultSet.next()) {
					
					Lecture_Qna lq = new Lecture_Qna();
					lq.setQnano(resultSet.getInt("qnano"));
					lq.setSubject(resultSet.getString("subject"));
					lq.setContent(resultSet.getString("content"));
					lq.setAnswer(resultSet.getString("answer"));
					lq.setClickCount(new AtomicInteger(resultSet.getInt("clickcount")));
					lq.setOpen(resultSet.getString("open"));
					lq.setWriteDate(resultSet.getString("writedate"));
					lq.setUserno(resultSet.getInt("userno"));
					lq.setLectureno(resultSet.getInt("lectureno"));
					lqList.add(lq);
				}
				
			} catch (Exception e) {

			}finally {
				JDBCUtil.close(null, pStatement, connection);
			}
		
		
		return lqList;
		
		
		
	}

	
	
	
	
	
	


	@Override
	public int LectureQnaCntByLectureno(int lectureno) {
		int cnt = 0 ;
		ResultSet resultSet = null;
		Connection connection = null;
		PreparedStatement pStatement = null;
		
			try {
				connection = JDBCUtil.getConnection();
				pStatement = connection.prepareStatement(LectureQnaSql.LECTURE_QNA_COUNT_BY_LECTURENO_SQL);
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
	public int LectureQnaCntByLecturenoAndUserno(int lectureno  ,int userno) {
		int cnt = 0 ;
		ResultSet resultSet = null;
		Connection connection = null;
		PreparedStatement pStatement = null;
		
			try {
				connection = JDBCUtil.getConnection();
				pStatement = connection.prepareStatement(LectureQnaSql. LECTURE_QNA_COUNT_BY_LECTURENO_AND_USERNO_SQL);
				pStatement.setInt(1, lectureno);
				pStatement.setInt(2, userno);
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
	public int LectureQnaCntByLecturenoAndSubject(int lectureno,String subject) {
		
		int cnt = 0 ;
		ResultSet resultSet = null;
		Connection connection = null;
		PreparedStatement pStatement = null;
		
			try {
				connection = JDBCUtil.getConnection();
				pStatement = connection.prepareStatement(LectureQnaSql.LECTURE_QNA_COUNT_BY_LECTURENO_AND_SUBJECT_SQL);
				pStatement.setInt(1, lectureno);
				pStatement.setString(2, subject);
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
	public void updateClickCount(Lecture_Qna lq) {
		Connection connection = null;
		PreparedStatement pStatement = null;
		
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(LectureQnaSql.LECTURE_QNA_UPDATE_CLICKCOUNT_BY_QNANO_SQL);
			
			pStatement.setInt(1, lq.getClickCount().get());
			pStatement.setInt(2, lq.getQnano());
		
			 
			pStatement.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			JDBCUtil.close(null, pStatement, connection);
		}
		
		
	}

	
}
