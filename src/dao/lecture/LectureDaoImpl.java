package dao.lecture;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.JDBCUtil;
import model.Lecture;
import model.Member;
import page.PageManager;
import page.PageRowResult;

public class LectureDaoImpl implements LectureDao {

	@Override
	public void insert(Lecture lecture) {
		Connection connection = null;
		PreparedStatement pStatement= null;
		
		try {
			connection= JDBCUtil.getConnection();
			pStatement= connection.prepareStatement(Sql.LECUTRE_INSERT_SQL);
			
			pStatement.setString(1, lecture.getName()); 
			pStatement.setString(2, lecture.getContent()); 
			pStatement.setString(3, lecture.getStartdate()); 
			pStatement.setString(4,  lecture.getEnddate()); 
			pStatement.setString(5, lecture.getStarttime()); 
			pStatement.setString(6, lecture.getEndtime()); 
			pStatement.setString(7, lecture.getRec_startdate()); 
			pStatement.setString(8, lecture.getRec_enddate()); 
			pStatement.setInt(9, lecture.getRec_cnt()); 
			pStatement.setString(10,lecture.getImagename());
			pStatement.setInt(11,lecture.getUserno());
			pStatement.setInt(12,lecture.getInt_no());
			
			
			pStatement.executeUpdate();

			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(null, pStatement, connection);
		}

	}

	@Override
	public void update(Lecture lecture) {
		Connection connection = null;
		PreparedStatement pStatement= null;
		
		try {
			connection= JDBCUtil.getConnection();
			pStatement= connection.prepareStatement(Sql.LECUTRE_UPDATE_SQL);
			
			pStatement.setString(1, lecture.getContent()); 
			pStatement.setString(2, lecture.getStartdate()); 
			pStatement.setString(3, lecture.getEnddate()); 
			pStatement.setString(4, lecture.getStarttime()); 
			pStatement.setString(5, lecture.getEndtime()); 
			pStatement.setString(6, lecture.getRec_startdate()); 
			pStatement.setString(7, lecture.getRec_enddate()); 
			pStatement.setInt(8, lecture.getRec_cnt()); 
			pStatement.setString(9, lecture.getImagename()); 
			pStatement.setInt(10, lecture.getInt_no()); 
			pStatement.setInt(11, lecture.getLectureno()); 
			
			pStatement.executeUpdate();

			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(null, pStatement, connection);
		}


	}

	@Override
	public void delete(int lecutreno) {
		Connection connection = null;
		PreparedStatement pStatement= null;
		
		try {
			connection= JDBCUtil.getConnection();
			pStatement= connection.prepareStatement(Sql.LECUTRE_DELTE_SQL);
			 
			pStatement.setInt(1, lecutreno); 
	
			pStatement.executeUpdate();
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}finally {
			
			JDBCUtil.close(null, pStatement, connection);
			
		}

	}

	@Override
	public List<Lecture> selectAll() {
		List<Lecture> lectureList = new ArrayList<>();
		
		Connection connection = null;
		PreparedStatement pStatement= null;
		ResultSet resultSet= null;
		
		try {
			connection= JDBCUtil.getConnection();
			pStatement= connection.prepareStatement(Sql.LECUTRE_SELECT_ALL_SQL);
			resultSet= pStatement.executeQuery();
			
			while(resultSet.next()) {
			
				Lecture lecture= new Lecture();
				
				lecture.setLectureno(resultSet.getInt("lectureno"));
				lecture.setName(resultSet.getString("name"));
				lecture.setContent(resultSet.getString("content"));
				lecture.setStartdate(resultSet.getString("startdate"));
				lecture.setEnddate(resultSet.getString("enddate"));
				lecture.setStarttime(resultSet.getString("starttime"));
				lecture.setEndtime(resultSet.getString("endtime"));
				lecture.setRec_startdate(resultSet.getString("rec_startdate"));
				lecture.setRec_enddate(resultSet.getString("rec_enddate"));
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
	public Lecture selectByLectureno(int lectureno) {
		Lecture lecture= null;
		Connection connection = null;
		PreparedStatement pStatement= null;
		ResultSet resultSet= null;
		
		try {
			connection= JDBCUtil.getConnection();
			pStatement= connection.prepareStatement(Sql.LECUTRE_SELECT_BY_LECUTRENO_SQL);
			
			pStatement.setInt(1, lectureno); 
			
			resultSet= pStatement.executeQuery();
			
			if(resultSet.next()) {
				lecture= new Lecture();
				
				lecture.setLectureno(resultSet.getInt("lectureno"));
				lecture.setName(resultSet.getString("name"));
				lecture.setContent(resultSet.getString("content"));
				lecture.setStartdate(resultSet.getString("startdate"));
				lecture.setEnddate(resultSet.getString("enddate"));
				lecture.setStarttime(resultSet.getString("starttime"));
				lecture.setEndtime(resultSet.getString("endtime"));
				lecture.setRec_startdate(resultSet.getString("rec_startdate"));
				lecture.setRec_enddate(resultSet.getString("rec_enddate"));
				lecture.setRec_cnt(resultSet.getInt("rec_cnt"));
				lecture.setReq_cnt(resultSet.getInt("req_cnt"));
				lecture.setImagename(resultSet.getString("imagename"));
				lecture.setClickcount(resultSet.getInt("clickcount"));
				lecture.setUserno(resultSet.getInt("userno"));
				lecture.setInt_no(resultSet.getInt("int_no"));
				
				/*String sql = "UPDATE LECTURE SET CLICKCOUNT = ? WHERE LECTURENO = ?";
				pStatement = connection.prepareStatement(sql);
				pStatement.setInt(1, resultSet.getInt("CLICKCOUNT")+1);
				pStatement.setInt(2, lectureno);
				pStatement.executeUpdate();*/
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(resultSet, pStatement, connection);
		}
		
		return lecture;
	}

	@Override
	public List<Lecture> selectByName(String name) {
		List<Lecture> lectureList = new ArrayList<>();
		Connection connection = null;
		PreparedStatement pStatement= null;
		ResultSet resultSet= null;
		
		try {
			connection= JDBCUtil.getConnection();
			pStatement= connection.prepareStatement(Sql.LECUTRE_SELECT_BY_NAME_SQL);
			
			pStatement.setString(1,name); 
			
			resultSet= pStatement.executeQuery();
			while(resultSet.next()) {
				Lecture lecture= new Lecture();
				
				lecture.setUsername(resultSet.getString("username"));
				lecture.setLectureno(resultSet.getInt("lectureno"));
				lecture.setName(resultSet.getString("lecturename"));
				lecture.setContent(resultSet.getString("content"));
				lecture.setStartdate(resultSet.getString("startdate").substring(0,10));
				lecture.setEnddate(resultSet.getString("enddate").substring(0,10));
				lecture.setStarttime(resultSet.getString("starttime"));
				lecture.setEndtime(resultSet.getString("endtime"));
				lecture.setRec_startdate(resultSet.getString("rec_startdate"));
				lecture.setRec_enddate(resultSet.getString("rec_enddate"));
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
	public List<Lecture> selectByInt_no(int int_no) {
		List<Lecture> lectureList = new ArrayList<>();
		Connection connection = null;
		PreparedStatement pStatement= null;
		ResultSet resultSet= null;
		
		try {
			connection= JDBCUtil.getConnection();
			pStatement= connection.prepareStatement(Sql.LECUTRE_SELECT_BY_INT_NO_SQL);
			
			pStatement.setInt(1,int_no); 
			
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
				lecture.setRec_startdate(resultSet.getString("rec_startdate"));
				lecture.setRec_enddate(resultSet.getString("rec_enddate"));
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
	public void selectClcikcount(int lectureno) {
		Connection connection = null;
		PreparedStatement pStatement= null;
		
		try {
			connection= JDBCUtil.getConnection();
			pStatement= connection.prepareStatement(Sql.LECUTRE_CLICKCOUNT_UP_SQL);
			 
			pStatement.setInt(1, lectureno); 
			pStatement.setInt(2, lectureno); 
	
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
			pStatement= connection.prepareStatement(Sql.LECUTRE_SELECT_BY_USER_INT_NO);
			
			pStatement.setInt(1,userno); 
			pStatement.setInt(2,userno); 
			
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
				lecture.setRec_startdate(resultSet.getString("rec_startdate"));
				lecture.setRec_enddate(resultSet.getString("rec_enddate"));
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
	public List<Lecture> selectAllByPopularity() {
		List<Lecture> lectureList = new ArrayList<>();
		
		Connection connection = null;
		PreparedStatement pStatement= null;
		ResultSet resultSet= null;
		
		try {
			connection= JDBCUtil.getConnection();
			pStatement= connection.prepareStatement(Sql.LECUTRE_SELECT_ALL_BY_POPULARITY_SQL);
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
				lecture.setRec_startdate(resultSet.getString("rec_startdate"));
				lecture.setRec_enddate(resultSet.getString("rec_enddate"));
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
	public List<Lecture> selectByPopularity() {
		List<Lecture> lectureList = new ArrayList<>();
		
		Connection connection = null;
		PreparedStatement pStatement= null;
		ResultSet resultSet= null;
		
		try {
			connection= JDBCUtil.getConnection();
			pStatement= connection.prepareStatement(Sql.LECUTRE_SELECT_BY_POPULARITY_SQL);
			resultSet= pStatement.executeQuery();
			
			while(resultSet.next()) {
			
				Lecture lecture= new Lecture();
				
				lecture.setLectureno(resultSet.getInt("lectureno"));
				lecture.setName(resultSet.getString("lecturename"));
				lecture.setContent(resultSet.getString("content"));
				lecture.setStartdate(resultSet.getString("startdate").substring(0,10));
				lecture.setEnddate(resultSet.getString("enddate").substring(0,10));
				lecture.setStarttime(resultSet.getString("starttime"));
				lecture.setEndtime(resultSet.getString("endtime"));
				lecture.setRec_startdate(resultSet.getString("rec_startdate"));
				lecture.setRec_enddate(resultSet.getString("rec_enddate"));
				lecture.setRec_cnt(resultSet.getInt("rec_cnt"));
				lecture.setReq_cnt(resultSet.getInt("req_cnt"));
				lecture.setClickcount(resultSet.getInt("clickcount"));
				lecture.setUserno(resultSet.getInt("userno"));
				lecture.setInt_no(resultSet.getInt("int_no"));
				lecture.setUsername(resultSet.getString("username"));
				lecture.setImagename(resultSet.getString("imagename"));
				
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
	public List<Lecture> selectByInt_no2(int int_no) {
		List<Lecture> lectureList = new ArrayList<>();
		Connection connection = null;
		PreparedStatement pStatement= null;
		ResultSet resultSet= null;
		
		try {
			connection= JDBCUtil.getConnection();
			pStatement= connection.prepareStatement(Sql.LECUTRE_SELECT_BY_INT_NO_SQL2);
			
			pStatement.setInt(1,int_no); 
			
			resultSet= pStatement.executeQuery();
			
			while(resultSet.next()) {
				Lecture lecture= new Lecture();
				
				lecture.setLectureno(resultSet.getInt("lectureno"));
				lecture.setName(resultSet.getString("lecturename"));
				lecture.setContent(resultSet.getString("content"));
				lecture.setStartdate(resultSet.getString("startdate").substring(0,10));
				lecture.setEnddate(resultSet.getString("enddate").substring(0,10));
				lecture.setStarttime(resultSet.getString("starttime"));
				lecture.setEndtime(resultSet.getString("endtime"));
				lecture.setRec_startdate(resultSet.getString("rec_startdate"));
				lecture.setRec_enddate(resultSet.getString("rec_enddate"));
				lecture.setRec_cnt(resultSet.getInt("rec_cnt"));
				lecture.setReq_cnt(resultSet.getInt("req_cnt"));
				lecture.setClickcount(resultSet.getInt("clickcount"));
				lecture.setUserno(resultSet.getInt("userno"));
				lecture.setInt_no(resultSet.getInt("int_no"));
				lecture.setUsername(resultSet.getString("username"));
				lecture.setImagename(resultSet.getString("imagename"));
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
	public int dateSeach(String startdate, String enddate, String starttime, String endtime, int userno) {
		Lecture lecture = null;
		
		int count= 1;
		
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		lecture = new Lecture();

		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.LECUTRE_SELECT_BY_DATE_SEACH_SQL);

			pStatement.setString(1, startdate);
			pStatement.setString(2, enddate);
			pStatement.setString(3, startdate);
			pStatement.setString(4, enddate);
			pStatement.setString(5, startdate);
			pStatement.setString(6, enddate);
			
			pStatement.setString(7, starttime);
			pStatement.setString(8, endtime);
			pStatement.setString(9, starttime);
			pStatement.setString(10, endtime);
			pStatement.setString(11, starttime);
			pStatement.setString(12, endtime);
			pStatement.setInt(13, userno);

			resultSet = pStatement.executeQuery();

			if (resultSet.next()) {// 이 값은 참 거짓이다.

				count= resultSet.getInt("cnt");
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(resultSet, pStatement, connection);
		}
		
		return count;
	}

	@Override
	public int lectureInfoDateSeach(String startdate, String enddate, String starttime, String endtime, int userno) {
		Lecture lecture = null;
		
		int count= 1;
		
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		lecture = new Lecture();

		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.LECUTRE_SELECT_BY_LECTURE_INFO_DATE_SEACH_SQL);
			
			pStatement.setInt(1, userno);
			pStatement.setString(2, startdate);
			pStatement.setString(3, enddate);
			pStatement.setString(4, startdate);
			pStatement.setString(5, enddate);
			pStatement.setString(6, startdate);
			pStatement.setString(7, enddate);
			pStatement.setString(8, starttime);
			pStatement.setString(9, endtime);
			pStatement.setString(10, starttime);
			pStatement.setString(11, endtime);
			pStatement.setString(12, starttime);
			pStatement.setString(13, endtime);
			
			resultSet = pStatement.executeQuery();

			if (resultSet.next()) {// 이 값은 참 거짓이다.

				count= resultSet.getInt("cnt");
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(resultSet, pStatement, connection);
		}
		
		return count;
	}

	@Override
	public List<Lecture> selectByUserInterest(int int_no, int int_no2) {
		
		List<Lecture> lectureList = new ArrayList<>();
		
		Connection connection = null;
		PreparedStatement pStatement= null;
		ResultSet resultSet= null;
		
		try {
			connection= JDBCUtil.getConnection();
			pStatement= connection.prepareStatement(Sql.LECUTRE_SELECT_BY_USER_INTEREST_SEACH_SQL);
			
			pStatement.setInt(1,int_no); 
			pStatement.setInt(2,int_no2); 

			
			
			resultSet= pStatement.executeQuery();
			
			
			while(resultSet.next()) {
			
				Lecture lecture= new Lecture();
				
				lecture.setLectureno(resultSet.getInt("lectureno"));
				lecture.setName(resultSet.getString("lecturename"));
				lecture.setContent(resultSet.getString("content"));
				lecture.setStartdate(resultSet.getString("startdate").substring(0,10));
				lecture.setEnddate(resultSet.getString("enddate").substring(0,10));
				lecture.setStarttime(resultSet.getString("starttime"));
				lecture.setEndtime(resultSet.getString("endtime"));
				lecture.setRec_startdate(resultSet.getString("rec_startdate"));
				lecture.setRec_enddate(resultSet.getString("rec_enddate"));
				lecture.setRec_cnt(resultSet.getInt("rec_cnt"));
				lecture.setReq_cnt(resultSet.getInt("req_cnt"));
				lecture.setClickcount(resultSet.getInt("clickcount"));
				lecture.setUserno(resultSet.getInt("userno"));
				lecture.setInt_no(resultSet.getInt("int_no"));
				lecture.setUsername(resultSet.getString("username"));
				lecture.setImagename(resultSet.getString("imagename"));
				
				lectureList.add(lecture);

			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(resultSet, pStatement, connection);
		}
		return lectureList;
	}
	public String selectInterestByno(int no) {
		Connection conn = null;
		PreparedStatement ps= null;
		ResultSet rs = null;
		ResultSet rs_two = null;
		
		String interest = null;
		
		try {
			conn = JDBCUtil.getConnection();
			ps = conn.prepareStatement(Sql.LECUTRE_SELECT_BY_LECUTRENO_SQL);
			
			ps.setInt(1, no);
			
			rs = ps.executeQuery();
			
			if (rs.next()) {
				String sql = "SELECT INT_NAME AS NAME FROM INTEREST WHERE INT_NO = ?";
				ps = conn.prepareStatement(sql);
				ps.setInt(1, rs.getInt("INT_NO"));
				
				rs_two = ps.executeQuery();
				
				if(rs_two.next()) {
					interest = rs_two.getString("NAME");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, ps, conn);
		}	
		
		return interest;
	}

	@Override
	public String selectMemberByno(int no) {
		Connection conn = null;
		PreparedStatement ps= null;
		ResultSet rs = null;
		
		String name = null;
		
		try {
			conn = JDBCUtil.getConnection();
			ps = conn.prepareStatement(Sql.USERNAME_BY_NO);
			
			ps.setInt(1, no);
			
			rs = ps.executeQuery();
			
			if (rs.next()) {
				name = rs.getString("NAME");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, ps, conn);
		}	
		
		return name;
	}
	@Override
	public List<Lecture> selectAll(int requestPage) {
		
		List<Lecture> lectureList= new ArrayList<>();
		Connection connection = null;
		PreparedStatement pStatement= null;
		ResultSet resultSet= null;
		
		try {
			connection= JDBCUtil.getConnection();
			pStatement= connection.prepareStatement(Sql.LECTURE_SELECT_BY_ALL_PAGE_SQL);
			//?매니저의 도움으로 셋팅
			PageManager pm = new PageManager(requestPage);
			PageRowResult prr= pm.getLecturePageRowResult();
			pStatement.setInt(1, prr.getRowStartNumber()); 
			pStatement.setInt(2, prr.getRowEndNumber()); 
			
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
				lecture.setRec_startdate(resultSet.getString("rec_startdate"));
				lecture.setRec_enddate(resultSet.getString("rec_enddate"));
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
	public List<Lecture> selectByName(String name, int requestPage) {
		List<Lecture> lectureList = new ArrayList<>();
		Connection connection = null;
		PreparedStatement pStatement= null;
		ResultSet resultSet= null;
		
		try {
			connection= JDBCUtil.getConnection();
			pStatement= connection.prepareStatement(Sql.LECTURE_SELECT_BY_NAME_PAGE_SQL);
			//?매니저의 도움으로 셋팅
			PageManager pm = new PageManager(requestPage);
			PageRowResult prr= pm.getLecturePageRowResult();
			
			pStatement.setString(1, name); 
			pStatement.setInt(2, prr.getRowStartNumber()); 
			pStatement.setInt(3, prr.getRowEndNumber()); 
			
			resultSet= pStatement.executeQuery();
			
			
			while(resultSet.next()) {
				
				Lecture lecture= new Lecture();
				
				lecture.setLectureno(resultSet.getInt("lectureno"));
				lecture.setName(resultSet.getString("lecturename"));
				lecture.setContent(resultSet.getString("content"));
				lecture.setStartdate(resultSet.getString("startdate").substring(0,10));
				lecture.setEnddate(resultSet.getString("enddate").substring(0,10));
				lecture.setStarttime(resultSet.getString("starttime"));
				lecture.setEndtime(resultSet.getString("endtime"));
				lecture.setRec_startdate(resultSet.getString("rec_startdate"));
				lecture.setRec_enddate(resultSet.getString("rec_enddate"));
				lecture.setRec_cnt(resultSet.getInt("rec_cnt"));
				lecture.setReq_cnt(resultSet.getInt("req_cnt"));
				lecture.setClickcount(resultSet.getInt("clickcount"));
				lecture.setUserno(resultSet.getInt("userno"));
				lecture.setInt_no(resultSet.getInt("int_no"));
				lecture.setUsername(resultSet.getString("username"));
				lecture.setImagename(resultSet.getString("imagename"));
				
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
	public List<Lecture> selectByInt_no2(int int_no, int requestPage) {
		List<Lecture> lectureList = new ArrayList<>();
		Connection connection = null;
		PreparedStatement pStatement= null;
		ResultSet resultSet= null;
		
		try {
			connection= JDBCUtil.getConnection();
			pStatement= connection.prepareStatement(Sql.LECTURE_SELECT_BY_INT_NO_PAGE_SQL);
			//?매니저의 도움으로 셋팅
			PageManager pm = new PageManager(requestPage);
			PageRowResult prr= pm.getLecturePageRowResult();
			
			pStatement.setInt(1, int_no); 
			pStatement.setInt(2, prr.getRowStartNumber()); 
			pStatement.setInt(3, prr.getRowEndNumber()); 
			
			resultSet= pStatement.executeQuery();
			
			
			while(resultSet.next()) {
				
				Lecture lecture= new Lecture();
				 
				lecture.setLectureno(resultSet.getInt("lectureno"));
				lecture.setName(resultSet.getString("lecturename"));
				lecture.setContent(resultSet.getString("content"));
				lecture.setStartdate(resultSet.getString("startdate").substring(0,10));
				lecture.setEnddate(resultSet.getString("enddate").substring(0,10));
				lecture.setStarttime(resultSet.getString("starttime"));
				lecture.setEndtime(resultSet.getString("endtime"));
				lecture.setRec_startdate(resultSet.getString("rec_startdate"));
				lecture.setRec_enddate(resultSet.getString("rec_enddate"));
				lecture.setRec_cnt(resultSet.getInt("rec_cnt"));
				lecture.setReq_cnt(resultSet.getInt("req_cnt"));
				lecture.setClickcount(resultSet.getInt("clickcount"));
				lecture.setUserno(resultSet.getInt("userno"));
				lecture.setInt_no(resultSet.getInt("int_no"));
				lecture.setUsername(resultSet.getString("username"));
				lecture.setImagename(resultSet.getString("imagename"));
				
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
	public void updateReqCnt(int lectureNo) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = JDBCUtil.getConnection();
			ps = conn.prepareStatement(Sql.LECUTRE_SELECT_BY_LECUTRENO_SQL);
			ps.setInt(1, lectureNo);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				String sql = "UPDATE LECTURE SET REQ_CNT = ? WHERE LECTURENO = ?";
				ps = conn.prepareStatement(sql);
				ps.setInt(1, rs.getInt("REQ_CNT")+1);
				ps.setInt(2, lectureNo);
				ps.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, ps, conn);
		}
	}

	@Override
	public Member selectTeacherByno(int no) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ResultSet rs_two = null;
		
		Member member = null;
		
		try {
			conn = JDBCUtil.getConnection();
			ps = conn.prepareStatement(Sql.TEACHER_NAME_BY_NO);
			
			ps.setInt(1, no);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				String sql = "SELECT * FROM MEMBER WHERE USERNO = ?";
				ps = conn.prepareStatement(sql);
				
				ps.setInt(1, rs.getInt("USERNO"));
				
				rs_two = ps.executeQuery();
				
				if(rs_two.next()) {
					member = new Member();
					member.setUserno(rs_two.getInt("USERNO"));
					member.setName(rs_two.getString("NAME"));
					member.setImageName(rs_two.getString("IMAGENAME"));					
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, ps, conn);
		}
		return member;
	}
}
