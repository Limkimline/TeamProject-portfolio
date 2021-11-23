package dao.general_qna;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import dao.JDBCUtil;
import model.General_Qna;
import page.PageManager;
import page.PageRowResult;
public class GeneralQnaDaoImpl implements GeneralQnaDao{

	@Override
	public void GeneralQnaInsert(General_Qna gq) {
		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(GeneralQnaSql.GENERAL_QNA_INSERT_SQL);
			
			
			pStatement.setString(1, gq.getSubject());
			pStatement.setString(2, gq.getContent());;
			pStatement.setString(3, gq.getOpen());
			pStatement.setInt(4, gq.getUserno());
			pStatement.setInt(5, gq.getManagerno());
			pStatement.executeUpdate(); // 孽府 角青
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			JDBCUtil.close(null, pStatement, connection);
		}
		
	}
	@Override
	public void GeneralQnaInsertByNoMember(General_Qna gq) {
		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(GeneralQnaSql.GENERAL_QNA_INSERT_BY_NOMEMBER_SQL);
			
			
			pStatement.setString(1, gq.getSubject());
			pStatement.setString(2, gq.getContent());;
			pStatement.setString(3, gq.getOpen());
			pStatement.setInt(4, gq.getManagerno());
			pStatement.executeUpdate(); // 孽府 角青
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			JDBCUtil.close(null, pStatement, connection);
		}
		
		
	}


	@Override
	public List<General_Qna> GeneralQnaSearchAll() {
		List<General_Qna> gqList = new ArrayList<General_Qna>() ;
		ResultSet resultSet = null;
		Connection connection = null;
		PreparedStatement pStatement = null;
		
			try {
				connection = JDBCUtil.getConnection();
				pStatement = connection.prepareStatement(GeneralQnaSql.GENERAL_QNA_SELECT_ALL_SQL);
				resultSet = pStatement.executeQuery();
				
				while(resultSet.next()) {
					
					General_Qna gq = new General_Qna();
					gq.setQnano(resultSet.getInt("qnano"));
					gq.setSubject(resultSet.getString("subject"));
					gq.setContent(resultSet.getString("content"));
					gq.setAnswer(resultSet.getString("answer"));
					gq.setClickCount(new AtomicInteger(resultSet.getInt("clickcount")));
					gq.setOpen(resultSet.getString("open"));
					gq.setWriteDate(resultSet.getString("writedate"));
					gq.setUserno(resultSet.getInt("userno"));
					gq.setManagerno(resultSet.getInt("managerno"));
					gqList.add(gq);
				}
				
			} catch (Exception e) {

			}finally {
				JDBCUtil.close(resultSet, pStatement, connection);
			}
		
		return gqList;
	
	}


	
	@Override
	public General_Qna GeneralQnaSelectByQnaNo(int qnaNo) {
		General_Qna gq = new General_Qna() ;
		ResultSet resultSet = null;
		Connection connection = null;
		PreparedStatement pStatement = null;
		
			try {
				connection = JDBCUtil.getConnection();
				pStatement = connection.prepareStatement(GeneralQnaSql.GENERAL_QNA_SELECT_BY_QNANO_SQL);
				pStatement.setInt(1, qnaNo);
				
				resultSet = pStatement.executeQuery();
				
				while(resultSet.next()) {
					
					
					gq.setQnano(resultSet.getInt("qnano"));
					gq.setSubject(resultSet.getString("subject"));
					gq.setContent(resultSet.getString("content"));
					gq.setAnswer(resultSet.getString("answer"));
					gq.setClickCount(new AtomicInteger(resultSet.getInt("clickcount")));
					gq.setOpen(resultSet.getString("open"));
					gq.setWriteDate(resultSet.getString("writedate"));
					gq.setUserno(resultSet.getInt("userno"));
					gq.setManagerno(resultSet.getInt("managerno"));
				}
				
			} catch (Exception e) {

			}finally {
				JDBCUtil.close(resultSet, pStatement, connection);
			}
		
		return gq;
	
	}
	

	
	
	@Override
	public void GeneralQnaUpdateByQnaNo (General_Qna gq) {
		Connection connection = null;
		PreparedStatement pStatement = null;
		
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(GeneralQnaSql.GENERAL_QNA_UPDATE_BY_QNANO);
			
			
			pStatement.setString(1, gq.getSubject());
			pStatement.setString(2, gq.getContent());
			pStatement.setString(3, gq.getAnswer());
			pStatement.setString(4, gq.getOpen());
			pStatement.setInt(5, gq.getQnano());
		
			pStatement.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			JDBCUtil.close(null, pStatement, connection);
		}
	
	
		
	}

	@Override
	public void GeneralQnaDeleteByQnano(int qnano) {
		Connection connection = null;
		PreparedStatement pStatement = null;
		
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(GeneralQnaSql.GENERAL_QNA_DELETE_BY_QNANO_SQL);
			
			pStatement.setInt(1, qnano);
			
			pStatement.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			JDBCUtil.close(null, pStatement, connection);
		}
	
	}



	@Override
	public List<General_Qna> selectAllToPage(int requestPage) {
		List<General_Qna> gqList = new ArrayList<General_Qna>() ;
		
		ResultSet resultSet = null;
		Connection connection = null;
		PreparedStatement pStatement = null;
		
			try {
				connection = JDBCUtil.getConnection();
				pStatement = connection.prepareStatement(GeneralQnaSql.GENERAL_QNA_SElECT_ALL_TO_PAGE_SQL);
				PageManager pm = new PageManager(requestPage);
				PageRowResult prr = pm.getQnaPageRowResult();
				pStatement.setInt(1, prr.getRowStartNumber());
				pStatement.setInt(2, prr.getRowEndNumber());
				
				resultSet = pStatement.executeQuery();
				
				while(resultSet.next()) {
					
					General_Qna gq = new General_Qna();
					gq.setQnano(resultSet.getInt("qnano"));
					gq.setSubject(resultSet.getString("subject"));
					gq.setContent(resultSet.getString("content"));
					gq.setAnswer(resultSet.getString("answer"));
					gq.setClickCount(new AtomicInteger(resultSet.getInt("clickcount")));
					gq.setOpen(resultSet.getString("open"));
					gq.setWriteDate(resultSet.getString("writedate"));
					gq.setUserno(resultSet.getInt("userno"));
					gq.setManagerno(resultSet.getInt("managerno"));
					gqList.add(gq);
				}
				
			} catch (Exception e) {

			}finally {
				JDBCUtil.close(null, pStatement, connection);
			}
		
		
		return gqList;
		
		
		
	}
	
	@Override
	public int GeneralQnaCntAll() {
		int cnt = 0 ;
		ResultSet resultSet = null;
		Connection connection = null;
		PreparedStatement pStatement = null;
		
			try {
				connection = JDBCUtil.getConnection();
				pStatement = connection.prepareStatement(GeneralQnaSql.GENERAL_QNA_COUNT_ALL_SQL);
				
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
	public int GeneralQnaCntByUserno(int userno) {
		int cnt = 0 ;
		ResultSet resultSet = null;
		Connection connection = null;
		PreparedStatement pStatement = null;
		
			try {
				connection = JDBCUtil.getConnection();
				pStatement = connection.prepareStatement(GeneralQnaSql.GENERAL_QNA_COUNT_BY_USERNO_SQL);
				pStatement.setInt(1, userno);
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
	public int GeneralQnaCntBySubject(String subject) {
		int cnt = 0 ;
		ResultSet resultSet = null;
		Connection connection = null;
		PreparedStatement pStatement = null;
		
			try {
				connection = JDBCUtil.getConnection();
				pStatement = connection.prepareStatement(GeneralQnaSql.GENERAL_QNA_COUNT_BY_SUBJECT_SQL);
				pStatement.setString(1, subject);
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
	public void updateClickCount(General_Qna gq) {
		Connection connection = null;
		PreparedStatement pStatement = null;
		
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(GeneralQnaSql.GENERAL_QNA_UPDATE_CLICKCOUNT_BY_QNANO_SQL);
			
			pStatement.setInt(1, gq.getClickCount().get());
			pStatement.setInt(2, gq.getQnano());
		
			
			pStatement.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			JDBCUtil.close(null, pStatement, connection);
		}
		
		
	}

	@Override
	public List<General_Qna> selectByUsernoToPage(int requestPage, int userno) {
	List<General_Qna> gqList = new ArrayList<General_Qna>() ;
		
		ResultSet resultSet = null;
		Connection connection = null;
		PreparedStatement pStatement = null;
		
			try {
				connection = JDBCUtil.getConnection();
				pStatement = connection.prepareStatement(GeneralQnaSql.GENERAL_QNA_SElECT_BY_USERNO_TO_PAGE_SQL);
				PageManager pm = new PageManager(requestPage);
				PageRowResult prr = pm.getQnaPageRowResult();
				pStatement.setInt(1, userno);
				pStatement.setInt(2, prr.getRowStartNumber());
				pStatement.setInt(3, prr.getRowEndNumber());
				
				resultSet = pStatement.executeQuery();
				
				while(resultSet.next()) {
					
					General_Qna gq = new General_Qna();
					gq.setQnano(resultSet.getInt("qnano"));
					gq.setSubject(resultSet.getString("subject"));
					gq.setContent(resultSet.getString("content"));
					gq.setAnswer(resultSet.getString("answer"));
					gq.setClickCount(new AtomicInteger(resultSet.getInt("clickcount")));
					gq.setOpen(resultSet.getString("open"));
					gq.setWriteDate(resultSet.getString("writedate"));
					gq.setUserno(resultSet.getInt("userno"));
					gq.setManagerno(resultSet.getInt("managerno"));
					gqList.add(gq);
				}
				
			} catch (Exception e) {

			}finally {
				JDBCUtil.close(null, pStatement, connection);
			}
		
		
		return gqList;
		
		
		
	}

	@Override
	public List<General_Qna> selectBySubjectToPage(int requestPage, String subject) {
	List<General_Qna> gqList = new ArrayList<General_Qna>() ;
		
		ResultSet resultSet = null;
		Connection connection = null;
		PreparedStatement pStatement = null;
		
			try {
				connection = JDBCUtil.getConnection();
				pStatement = connection.prepareStatement(GeneralQnaSql.GENERAL_QNA_SElECT_ALL_BY_SUBJECT_TO_PAGE_SQL);
				PageManager pm = new PageManager(requestPage);
				PageRowResult prr = pm.getQnaPageRowResult();
				pStatement.setString(1, subject);
				pStatement.setInt(2, prr.getRowStartNumber());
				pStatement.setInt(3, prr.getRowEndNumber());
				
				resultSet = pStatement.executeQuery();
				
				while(resultSet.next()) {
					
					General_Qna gq = new General_Qna();
					gq.setQnano(resultSet.getInt("qnano"));
					gq.setSubject(resultSet.getString("subject"));
					gq.setContent(resultSet.getString("content"));
					gq.setAnswer(resultSet.getString("answer"));
					gq.setClickCount(new AtomicInteger(resultSet.getInt("clickcount")));
					gq.setOpen(resultSet.getString("open"));
					gq.setWriteDate(resultSet.getString("writedate"));
					gq.setUserno(resultSet.getInt("userno"));
					gq.setManagerno(resultSet.getInt("managerno"));
					gqList.add(gq);
				}
				
			} catch (Exception e) {

			}finally {
				JDBCUtil.close(null, pStatement, connection);
			}
		
		
		return gqList;
		
	}

}

