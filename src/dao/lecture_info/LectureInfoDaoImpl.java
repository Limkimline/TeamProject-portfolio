package dao.lecture_info;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import dao.JDBCUtil;
import dao.general_qna.GeneralQnaSql;
import dao.lecture.LectureDao;
import model.Lecture;
import model.Lecture_Info;
import model.Lecture_Info2;
import page.PageManager;
import page.PageRowResult;

public class LectureInfoDaoImpl implements LectureInfoDao {

	
	/*
	public List<Lecture_Info2> selectByUserno(int userno) {
		List<Lecture_Info2> lecture_info_list = new ArrayList<>();

		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;

		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.LISTEN_LECTUREINFO_LIST_ALL_SQL);
			pStatement.setInt(1, userno);
			
			resultSet = pStatement.executeQuery();

			while (resultSet.next()) {
				Lecture_Info2 lectureInfo = new Lecture_Info2();
				Lecture lecture = new Lecture();
				lectureInfo.setLecture(lecture);

				lectureInfo.setUserno(resultSet.getInt(1));
				lectureInfo.setLectureno(resultSet.getInt(2));
				lectureInfo.setInfono(resultSet.getInt(3));
				lectureInfo.setProgress(resultSet.getInt(4));
				lectureInfo.setAttendance(resultSet.getInt(5));

				lecture.setLectureno(resultSet.getInt(4));
				lecture.setName(resultSet.getString(6));
				lecture.setStartdate(resultSet.getString(7));
				lecture.setEnddate(resultSet.getString(8));
				lecture.setInt_no(resultSet.getInt(9));
				lecture.setUserno(resultSet.getInt(10));
				lecture.setImagename(resultSet.getString(11));

				lecture_info_list.add(lectureInfo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(resultSet, pStatement, connection);
		}

		return lecture_info_list;
	}
	
	
	//페이징처리하기...?
	public List<Lecture_Info2> selectByUserno2(int userno, int requestPage) {
		List<Lecture_Info2> lecture_info_list = new ArrayList<>();

		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;

		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.LISTEN_LECTUREINFO_LIST_ALL_SQL2);
			pStatement.setInt(1, userno);
			
			PageManager pm = new PageManager(requestPage);
			PageRowResult prr = pm.getPageRowResult();
			pStatement.setInt(2, prr.getRowStartNumber());
			pStatement.setInt(3, prr.getRowEndNumber()); 

			resultSet = pStatement.executeQuery();

			while (resultSet.next()) {
				Lecture_Info2 lectureInfo = new Lecture_Info2();
				Lecture lecture = new Lecture();
				lectureInfo.setLecture(lecture);

				lectureInfo.setUserno(resultSet.getInt(2));
				lectureInfo.setLectureno(resultSet.getInt(3));
				lectureInfo.setInfono(resultSet.getInt(4));
				lectureInfo.setProgress(resultSet.getInt(5));
				lectureInfo.setAttendance(resultSet.getInt(6));

				lecture.setLectureno(resultSet.getInt(3));
				lecture.setName(resultSet.getString(7));
				lecture.setStartdate(resultSet.getString(8));
				lecture.setEnddate(resultSet.getString(9));
				lecture.setInt_no(resultSet.getInt(10));
				lecture.setUserno(resultSet.getInt(11));
				lecture.setImagename(resultSet.getString(12));

				lecture_info_list.add(lectureInfo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(resultSet, pStatement, connection);
		}

		return lecture_info_list;
	}
	
	@Override
	public int countLectureInfo(String sql) {
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;

		int count = 0;
		
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.COUNT_SQL);
			pStatement.setString(1, sql);
			resultSet = pStatement.executeQuery();

			while (resultSet.next()) {
				count = resultSet.getInt("cnt");

				}
			}catch (Exception e) {
				e.printStackTrace();
			} finally {
				JDBCUtil.close(resultSet, pStatement, connection);
			}

			return count;
		}

*/
	@Override
	public List<Lecture_Info2> selectByStartdateLectureName(int userno, String startdate, String lectureName) {
		List<Lecture_Info2> lecture_info_list = new ArrayList<>();

		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;

		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.LISTEN_LECTUREINFO_LIST_BY_STARTDATE_SQL);
			pStatement.setInt(1, userno);
			pStatement.setString(2, startdate);
			pStatement.setString(3, lectureName);

			resultSet = pStatement.executeQuery();

			while (resultSet.next()) {
				Lecture_Info2 lectureInfo = new Lecture_Info2();
				Lecture lecture = new Lecture();
				lectureInfo.setLecture(lecture);

				lectureInfo.setUserno(resultSet.getInt(1));
				lectureInfo.setLectureno(resultSet.getInt(2));
				lectureInfo.setInfono(resultSet.getInt(3));
				lectureInfo.setProgress(resultSet.getInt(4));
				lectureInfo.setAttendance(resultSet.getInt(5));

				lecture.setLectureno(resultSet.getInt(2));
				lecture.setName(resultSet.getString(6));
				lecture.setStartdate(resultSet.getString(7));
				lecture.setEnddate(resultSet.getString(8));
				lecture.setInt_no(resultSet.getInt(9));
				lecture.setUserno(resultSet.getInt(10));
				lecture.setImagename(resultSet.getString(11));

				lecture_info_list.add(lectureInfo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(resultSet, pStatement, connection);
		}

		return lecture_info_list;
	}

	@Override
	public List<Lecture_Info2> selectByEnddateLectureName(int userno, String enddate, String lectureName) {
		List<Lecture_Info2> lecture_info_list = new ArrayList<>();

		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;

		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.LISTEN_LECTUREINFO_LIST_BY_ENDDATE_SQL);
			pStatement.setInt(1, userno);
			pStatement.setString(2, enddate);
			pStatement.setString(3, lectureName);

			resultSet = pStatement.executeQuery();

			while (resultSet.next()) {
				Lecture_Info2 lectureInfo = new Lecture_Info2();
				Lecture lecture = new Lecture();
				lectureInfo.setLecture(lecture);

				lectureInfo.setUserno(resultSet.getInt(1));
				lectureInfo.setLectureno(resultSet.getInt(2));
				lectureInfo.setInfono(resultSet.getInt(3));
				lectureInfo.setProgress(resultSet.getInt(4));
				lectureInfo.setAttendance(resultSet.getInt(5));

				lecture.setLectureno(resultSet.getInt(2));
				lecture.setName(resultSet.getString(6));
				lecture.setStartdate(resultSet.getString(7));
				lecture.setEnddate(resultSet.getString(8));
				lecture.setInt_no(resultSet.getInt(9));
				lecture.setUserno(resultSet.getInt(10));
				lecture.setImagename(resultSet.getString(11));

				lecture_info_list.add(lectureInfo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(resultSet, pStatement, connection);
		}

		return lecture_info_list;
	}

	@Override
	public List<Lecture_Info2> selectByStartdateEnddateLectureName(int userno, String startdate, String enddate,
			String lectureName) {
		List<Lecture_Info2> lecture_info_list = new ArrayList<>();

		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;

		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.LISTEN_LECTUREINFO_LIST_BY_STARTDATE_ENDDATE_SQL);
			pStatement.setInt(1, userno);
			pStatement.setString(2, startdate);
			pStatement.setString(3, enddate);
			pStatement.setString(4, lectureName);

			resultSet = pStatement.executeQuery();

			while (resultSet.next()) {
				Lecture_Info2 lectureInfo = new Lecture_Info2();
				Lecture lecture = new Lecture();
				lectureInfo.setLecture(lecture);

				lectureInfo.setUserno(resultSet.getInt(1));
				lectureInfo.setLectureno(resultSet.getInt(2));
				lectureInfo.setInfono(resultSet.getInt(3));
				lectureInfo.setProgress(resultSet.getInt(4));
				lectureInfo.setAttendance(resultSet.getInt(5));

				lecture.setLectureno(resultSet.getInt(2));
				lecture.setName(resultSet.getString(6));
				lecture.setStartdate(resultSet.getString(7));
				lecture.setEnddate(resultSet.getString(8));
				lecture.setInt_no(resultSet.getInt(9));
				lecture.setUserno(resultSet.getInt(10));
				lecture.setImagename(resultSet.getString(11));

				lecture_info_list.add(lectureInfo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(resultSet, pStatement, connection);
		}

		return lecture_info_list;
	}

	@Override
	public List<Lecture_Info2> selectByLectureName(int userno, String lectureName) {
		List<Lecture_Info2> lecture_info_list = new ArrayList<>();

		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;

		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.LISTEN_LECTUREINFO_LIST_BY_LECTURENAME);
			pStatement.setInt(1, userno);
			pStatement.setString(2, lectureName);

			
			resultSet = pStatement.executeQuery();

			while (resultSet.next()) {
				Lecture_Info2 lectureInfo = new Lecture_Info2();
				Lecture lecture = new Lecture();
				lectureInfo.setLecture(lecture);

				lectureInfo.setUserno(resultSet.getInt(1));
				lectureInfo.setLectureno(resultSet.getInt(2));
				lectureInfo.setInfono(resultSet.getInt(3));
				lectureInfo.setProgress(resultSet.getInt(4));
				lectureInfo.setAttendance(resultSet.getInt(5));

				lecture.setLectureno(resultSet.getInt(2));
				lecture.setName(resultSet.getString(6));
				lecture.setStartdate(resultSet.getString(7));
				lecture.setEnddate(resultSet.getString(8));
				lecture.setInt_no(resultSet.getInt(9));
				lecture.setUserno(resultSet.getInt(10));
				lecture.setImagename(resultSet.getString(11));

				lecture_info_list.add(lectureInfo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(resultSet, pStatement, connection);
		}

		return lecture_info_list;
	}


	//---------------------------------------------
	

	@Override
	public List<Lecture_Info2> selectByLectureName2(int userno, String lectureName, int requestPage) {
		List<Lecture_Info2> lecture_info_list = new ArrayList<>();

		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;

		
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.LISTEN_LECTUREINFO_LIST_BY_LECTURENAME2);
			pStatement.setInt(1, userno);
			pStatement.setString(2, lectureName);

			PageManager pm = new PageManager(requestPage);
			PageRowResult prr = pm.getPageRowResult();
			pStatement.setInt(3, prr.getRowStartNumber());
			pStatement.setInt(4, prr.getRowEndNumber()); 
			resultSet = pStatement.executeQuery();

			while (resultSet.next()) {
				Lecture_Info2 lectureInfo = new Lecture_Info2();
				Lecture lecture = new Lecture();
				lectureInfo.setLecture(lecture);

				lectureInfo.setUserno(resultSet.getInt(2));
				lectureInfo.setLectureno(resultSet.getInt(3));
				lectureInfo.setInfono(resultSet.getInt(4));
				lectureInfo.setProgress(resultSet.getInt(5));
				lectureInfo.setAttendance(resultSet.getInt(6));

				lecture.setLectureno(resultSet.getInt(3));
				lecture.setName(resultSet.getString(7));
				lecture.setStartdate(resultSet.getString(8));
				lecture.setEnddate(resultSet.getString(9));
				lecture.setInt_no(resultSet.getInt(10));
				lecture.setUserno(resultSet.getInt(11));
				lecture.setImagename(resultSet.getString(12));

				lecture_info_list.add(lectureInfo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(resultSet, pStatement, connection);
		}

		return lecture_info_list;
	}

	@Override
	public List<Lecture_Info2> selectByStartdateLectureName2(int userno, String startdate, String lectureName,
			int requestPage) {
		List<Lecture_Info2> lecture_info_list = new ArrayList<>();

		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;

		
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.LISTEN_LECTUREINFO_LIST_BY_STARTDATE_SQL2);
			pStatement.setInt(1, userno);
			pStatement.setString(2, startdate);
			pStatement.setString(3, lectureName);

			PageManager pm = new PageManager(requestPage);
			PageRowResult prr = pm.getPageRowResult();
			pStatement.setInt(4, prr.getRowStartNumber());
			pStatement.setInt(5, prr.getRowEndNumber()); 
			resultSet = pStatement.executeQuery();

			while (resultSet.next()) {
				Lecture_Info2 lectureInfo = new Lecture_Info2();
				Lecture lecture = new Lecture();
				lectureInfo.setLecture(lecture);

				lectureInfo.setUserno(resultSet.getInt(2));
				lectureInfo.setLectureno(resultSet.getInt(3));
				lectureInfo.setInfono(resultSet.getInt(4));
				lectureInfo.setProgress(resultSet.getInt(5));
				lectureInfo.setAttendance(resultSet.getInt(6));

				lecture.setLectureno(resultSet.getInt(3));
				lecture.setName(resultSet.getString(7));
				lecture.setStartdate(resultSet.getString(8));
				lecture.setEnddate(resultSet.getString(9));
				lecture.setInt_no(resultSet.getInt(10));
				lecture.setUserno(resultSet.getInt(11));
				lecture.setImagename(resultSet.getString(12));

				lecture_info_list.add(lectureInfo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(resultSet, pStatement, connection);
		}

		return lecture_info_list;
	}

	@Override
	public List<Lecture_Info2> selectByEnddateLectureName2(int userno, String enddate, String lectureName,
			int requestPage) {
		List<Lecture_Info2> lecture_info_list = new ArrayList<>();

		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;

		
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.LISTEN_LECTUREINFO_LIST_BY_ENDDATE_SQL2);
			pStatement.setInt(1, userno);
			pStatement.setString(2, enddate);
			pStatement.setString(3, lectureName);

			PageManager pm = new PageManager(requestPage);
			PageRowResult prr = pm.getPageRowResult();
			pStatement.setInt(4, prr.getRowStartNumber());
			pStatement.setInt(5, prr.getRowEndNumber()); 
			resultSet = pStatement.executeQuery();

			while (resultSet.next()) {
				Lecture_Info2 lectureInfo = new Lecture_Info2();
				Lecture lecture = new Lecture();
				lectureInfo.setLecture(lecture);

				lectureInfo.setUserno(resultSet.getInt(2));
				lectureInfo.setLectureno(resultSet.getInt(3));
				lectureInfo.setInfono(resultSet.getInt(4));
				lectureInfo.setProgress(resultSet.getInt(5));
				lectureInfo.setAttendance(resultSet.getInt(6));

				lecture.setLectureno(resultSet.getInt(3));
				lecture.setName(resultSet.getString(7));
				lecture.setStartdate(resultSet.getString(8));
				lecture.setEnddate(resultSet.getString(9));
				lecture.setInt_no(resultSet.getInt(10));
				lecture.setUserno(resultSet.getInt(11));
				lecture.setImagename(resultSet.getString(12));

				lecture_info_list.add(lectureInfo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(resultSet, pStatement, connection);
		}

		return lecture_info_list;
	}

	@Override
	public List<Lecture_Info2> selectByStartdateEnddateLectureName2(int userno, String startdate, String enddate,
			String lectureName, int requestPage) {
		List<Lecture_Info2> lecture_info_list = new ArrayList<>();

		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;

		
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.LISTEN_LECTUREINFO_LIST_BY_STARTDATE_ENDDATE_SQL2);
			pStatement.setInt(1, userno);
			pStatement.setString(2, startdate);
			pStatement.setString(3, enddate);
			pStatement.setString(4, lectureName);

			PageManager pm = new PageManager(requestPage);
			PageRowResult prr = pm.getPageRowResult();
			pStatement.setInt(5, prr.getRowStartNumber());
			pStatement.setInt(6, prr.getRowEndNumber()); 
			resultSet = pStatement.executeQuery();

			while (resultSet.next()) {
				Lecture_Info2 lectureInfo = new Lecture_Info2();
				Lecture lecture = new Lecture();
				lectureInfo.setLecture(lecture);

				lectureInfo.setUserno(resultSet.getInt(2));
				lectureInfo.setLectureno(resultSet.getInt(3));
				lectureInfo.setInfono(resultSet.getInt(4));
				lectureInfo.setProgress(resultSet.getInt(5));
				lectureInfo.setAttendance(resultSet.getInt(6));

				lecture.setLectureno(resultSet.getInt(3));
				lecture.setName(resultSet.getString(7));
				lecture.setStartdate(resultSet.getString(8));
				lecture.setEnddate(resultSet.getString(9));
				lecture.setInt_no(resultSet.getInt(10));
				lecture.setUserno(resultSet.getInt(11));
				lecture.setImagename(resultSet.getString(12));

				lecture_info_list.add(lectureInfo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(resultSet, pStatement, connection);
		}

		return lecture_info_list;
	}

	@Override
	public List<Lecture_Info2> selectMyLectureByLectureName(int userno, String lectureName) {
		List<Lecture_Info2> lecture_info_list = new ArrayList<>();

		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;

		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.MY_LECTURE_LECTUREINFO_LIST_BY_LECTURENAME);
			pStatement.setInt(1, userno);
			pStatement.setInt(2, userno);
			pStatement.setString(3, lectureName);
			
			
			resultSet = pStatement.executeQuery();

			while (resultSet.next()) {
				Lecture_Info2 lectureInfo = new Lecture_Info2();
				Lecture lecture = new Lecture();
				lectureInfo.setLecture(lecture);

				lectureInfo.setProgress(resultSet.getInt(1));
				lectureInfo.setLectureno(resultSet.getInt(2));
				lecture.setName(resultSet.getString(3));
				lecture.setStartdate(resultSet.getString(4));
				lecture.setEnddate(resultSet.getString(5));
				lecture.setImagename(resultSet.getString(6));
				
				lecture.setLectureno(resultSet.getInt(2));
				lecture.setUsername(resultSet.getString(8));
				lecture.setInt_no(resultSet.getInt(9));
				lecture.setRec_cnt(resultSet.getInt(10));
				lecture.setReq_cnt(resultSet.getInt(11));
				lecture_info_list.add(lectureInfo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(resultSet, pStatement, connection);
		}

		return lecture_info_list;
	}

	@Override
	public List<Lecture_Info2> selectMyLectureByLectureName2(int userno, String lectureName, int requestPage) {
		List<Lecture_Info2> lecture_info_list = new ArrayList<>();

		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;

		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.MY_LECTURE_LECTUREINFO_LIST_BY_LECTURENAME2);
			pStatement.setInt(1, userno);
			pStatement.setInt(2, userno);
			pStatement.setString(3, lectureName);
			
			PageManager pm = new PageManager(requestPage);
			PageRowResult prr = pm.getPageRowResult();
			pStatement.setInt(4, prr.getRowStartNumber());
			pStatement.setInt(5, prr.getRowEndNumber()); 
			
			
			resultSet = pStatement.executeQuery();

			while (resultSet.next()) {
				Lecture_Info2 lectureInfo = new Lecture_Info2();
				Lecture lecture = new Lecture();
				lectureInfo.setLecture(lecture);

				lectureInfo.setProgress(resultSet.getInt(2));
				lectureInfo.setLectureno(resultSet.getInt(3));
				lecture.setName(resultSet.getString(4));
				lecture.setStartdate(resultSet.getString(5));
				lecture.setEnddate(resultSet.getString(6));
				lecture.setImagename(resultSet.getString(7));
				
				lecture.setLectureno(resultSet.getInt(3));
				lecture.setUsername(resultSet.getString(9));
				lecture.setInt_no(resultSet.getInt(10));
				lecture.setRec_cnt(resultSet.getInt(11));
				lecture.setReq_cnt(resultSet.getInt(12));
				lecture_info_list.add(lectureInfo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(resultSet, pStatement, connection);
		}

		return lecture_info_list;
	}
	
	@Override
	public List<Lecture_Info2> selectMyLectureByLectureNameStartdate(int userno, String lectureName, String startdate) {
		List<Lecture_Info2> lecture_info_list = new ArrayList<>();

		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;

		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.MY_LECTURE_LECTUREINFO_LIST_BY_LECTURENAME_STARTDATE);
			pStatement.setInt(1, userno);
			pStatement.setInt(2, userno);
			pStatement.setString(3, lectureName);
			pStatement.setString(4, startdate);
			
			resultSet = pStatement.executeQuery();

			while (resultSet.next()) {
				Lecture_Info2 lectureInfo = new Lecture_Info2();
				Lecture lecture = new Lecture();
				lectureInfo.setLecture(lecture);

				lectureInfo.setProgress(resultSet.getInt(1));
				lectureInfo.setLectureno(resultSet.getInt(2));
				lecture.setName(resultSet.getString(3));
				lecture.setStartdate(resultSet.getString(4));
				lecture.setEnddate(resultSet.getString(5));
				lecture.setImagename(resultSet.getString(6));
				
				lecture.setLectureno(resultSet.getInt(2));
				lecture.setUsername(resultSet.getString(8));
				lecture.setInt_no(resultSet.getInt(9));
				lecture.setRec_cnt(resultSet.getInt(10));
				lecture.setReq_cnt(resultSet.getInt(11));
				lecture_info_list.add(lectureInfo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(resultSet, pStatement, connection);
		}

		return lecture_info_list;
	}

	@Override
	public List<Lecture_Info2> selectMyLectureByLectureNameStartdate2(int userno, String lectureName, String startdate,
			int requestPage) {
		List<Lecture_Info2> lecture_info_list = new ArrayList<>();

		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;

		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.MY_LECTURE_LECTUREINFO_LIST_BY_LECTURENAME_STARTDATE2);
			pStatement.setInt(1, userno);
			pStatement.setInt(2, userno);
			pStatement.setString(3, lectureName);
			pStatement.setString(4, startdate);
			
			PageManager pm = new PageManager(requestPage);
			PageRowResult prr = pm.getPageRowResult();
			pStatement.setInt(5, prr.getRowStartNumber());
			pStatement.setInt(6, prr.getRowEndNumber()); 
			
			
			resultSet = pStatement.executeQuery();

			while (resultSet.next()) {
				Lecture_Info2 lectureInfo = new Lecture_Info2();
				Lecture lecture = new Lecture();
				lectureInfo.setLecture(lecture);

				lectureInfo.setProgress(resultSet.getInt(2));
				lectureInfo.setLectureno(resultSet.getInt(3));
				lecture.setName(resultSet.getString(4));
				lecture.setStartdate(resultSet.getString(5));
				lecture.setEnddate(resultSet.getString(6));
				lecture.setImagename(resultSet.getString(7));
				
				lecture.setLectureno(resultSet.getInt(3));
				lecture.setUsername(resultSet.getString(9));
				lecture.setInt_no(resultSet.getInt(10));
				lecture.setRec_cnt(resultSet.getInt(11));
				lecture.setReq_cnt(resultSet.getInt(12));
				lecture_info_list.add(lectureInfo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(resultSet, pStatement, connection);
		}

		return lecture_info_list;
	}
	
	@Override
	public List<Lecture_Info2> selectMyLectureByLectureNameEnddate(int userno, String lectureName, String enddate) {
		List<Lecture_Info2> lecture_info_list = new ArrayList<>();

		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;

		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.MY_LECTURE_LECTUREINFO_LIST_BY_LECTURENAME_ENDDATE);
			pStatement.setInt(1, userno);
			pStatement.setInt(2, userno);
			pStatement.setString(3, lectureName);
			pStatement.setString(4, enddate);
			
			resultSet = pStatement.executeQuery();

			while (resultSet.next()) {
				Lecture_Info2 lectureInfo = new Lecture_Info2();
				Lecture lecture = new Lecture();
				lectureInfo.setLecture(lecture);

				lectureInfo.setProgress(resultSet.getInt(1));
				lectureInfo.setLectureno(resultSet.getInt(2));
				lecture.setName(resultSet.getString(3));
				lecture.setStartdate(resultSet.getString(4));
				lecture.setEnddate(resultSet.getString(5));
				lecture.setImagename(resultSet.getString(6));
				
				lecture.setLectureno(resultSet.getInt(2));
				lecture.setUsername(resultSet.getString(8));
				lecture.setInt_no(resultSet.getInt(9));
				lecture.setRec_cnt(resultSet.getInt(10));
				lecture.setReq_cnt(resultSet.getInt(11));
				lecture_info_list.add(lectureInfo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(resultSet, pStatement, connection);
		}

		return lecture_info_list;
	}

	@Override
	public List<Lecture_Info2> selectMyLectureByLectureNameEnddate2(int userno, String lectureName, String enddate,
			int requestPage) {
		List<Lecture_Info2> lecture_info_list = new ArrayList<>();

		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;

		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.MY_LECTURE_LECTUREINFO_LIST_BY_LECTURENAME_ENDDATE2);
			pStatement.setInt(1, userno);
			pStatement.setInt(2, userno);
			pStatement.setString(3, lectureName);
			pStatement.setString(4, enddate);
			
			PageManager pm = new PageManager(requestPage);
			PageRowResult prr = pm.getPageRowResult();
			pStatement.setInt(5, prr.getRowStartNumber());
			pStatement.setInt(6, prr.getRowEndNumber()); 
			
			
			resultSet = pStatement.executeQuery();

			while (resultSet.next()) {
				Lecture_Info2 lectureInfo = new Lecture_Info2();
				Lecture lecture = new Lecture();
				lectureInfo.setLecture(lecture);

				lectureInfo.setProgress(resultSet.getInt(2));
				lectureInfo.setLectureno(resultSet.getInt(3));
				lecture.setName(resultSet.getString(4));
				lecture.setStartdate(resultSet.getString(5));
				lecture.setEnddate(resultSet.getString(6));
				lecture.setImagename(resultSet.getString(7));
				
				lecture.setLectureno(resultSet.getInt(3));
				lecture.setUsername(resultSet.getString(9));
				lecture.setInt_no(resultSet.getInt(10));
				lecture.setRec_cnt(resultSet.getInt(11));
				lecture.setReq_cnt(resultSet.getInt(12));
				lecture_info_list.add(lectureInfo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(resultSet, pStatement, connection);
		}

		return lecture_info_list;
	}
	
	@Override
	public List<Lecture_Info2> selectMyLectureByLectureNameStartdateEnddate(int userno, String lectureName,
			String startdate, String enddate) {
		List<Lecture_Info2> lecture_info_list = new ArrayList<>();

		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;

		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.MY_LECTURE_LECTUREINFO_LIST_BY_LECTURENAME_STARTDATE_ENDDATE);
			pStatement.setInt(1, userno);
			pStatement.setInt(2, userno);
			pStatement.setString(3, lectureName);
			pStatement.setString(4, startdate);
			pStatement.setString(5, enddate);
			
			resultSet = pStatement.executeQuery();

			while (resultSet.next()) {
				Lecture_Info2 lectureInfo = new Lecture_Info2();
				Lecture lecture = new Lecture();
				lectureInfo.setLecture(lecture);

				lectureInfo.setProgress(resultSet.getInt(1));
				lectureInfo.setLectureno(resultSet.getInt(2));
				lecture.setName(resultSet.getString(3));
				lecture.setStartdate(resultSet.getString(4));
				lecture.setEnddate(resultSet.getString(5));
				lecture.setImagename(resultSet.getString(6));
				
				lecture.setLectureno(resultSet.getInt(2));
				lecture.setUsername(resultSet.getString(8));
				lecture.setInt_no(resultSet.getInt(9));
				lecture.setRec_cnt(resultSet.getInt(10));
				lecture.setReq_cnt(resultSet.getInt(11));
				lecture_info_list.add(lectureInfo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(resultSet, pStatement, connection);
		}

		return lecture_info_list;
	}

	@Override
	public List<Lecture_Info2> selectMyLectureByLectureNameStartdateEnddate2(int userno, String lectureName,
			String startdate, String enddate, int requestPage) {
		List<Lecture_Info2> lecture_info_list = new ArrayList<>();

		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;

		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.MY_LECTURE_LECTUREINFO_LIST_BY_LECTURENAME_STARTDATE_ENDDATE2);
			pStatement.setInt(1, userno);
			pStatement.setInt(2, userno);
			pStatement.setString(3, lectureName);
			pStatement.setString(4, startdate);
			pStatement.setString(5, enddate);
			
			PageManager pm = new PageManager(requestPage);
			PageRowResult prr = pm.getPageRowResult();
			pStatement.setInt(6, prr.getRowStartNumber());
			pStatement.setInt(7, prr.getRowEndNumber()); 
			
			
			resultSet = pStatement.executeQuery();

			while (resultSet.next()) {
				Lecture_Info2 lectureInfo = new Lecture_Info2();
				Lecture lecture = new Lecture();
				lectureInfo.setLecture(lecture);

				lectureInfo.setProgress(resultSet.getInt(2));
				lectureInfo.setLectureno(resultSet.getInt(3));
				lecture.setName(resultSet.getString(4));
				lecture.setStartdate(resultSet.getString(5));
				lecture.setEnddate(resultSet.getString(6));
				lecture.setImagename(resultSet.getString(7));
				
				lecture.setLectureno(resultSet.getInt(3));
				lecture.setUsername(resultSet.getString(9));
				lecture.setInt_no(resultSet.getInt(10));
				lecture.setRec_cnt(resultSet.getInt(11));
				lecture.setReq_cnt(resultSet.getInt(12));
				lecture_info_list.add(lectureInfo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(resultSet, pStatement, connection);
		}

		return lecture_info_list;
	}

	@Override
	public void insert(int userNo, int lectureNo) {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = JDBCUtil.getConnection();
			ps = conn.prepareStatement(Sql.INSERT_ENROLL_INFO);
			
			ps.setInt(1, userNo);
			ps.setInt(2, lectureNo);
			
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(null, ps, conn);
		}

	}

	@Override
	public void codeUpdate(String id, String code) {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = JDBCUtil.getConnection();
			ps = conn.prepareStatement(Sql.MEMBER_CODE_UPDATE);
			
			ps.setString(1, code);
			ps.setString(2, id);
			
			ps.executeUpdate();			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(null, ps, conn);
			System.out.println("성공적으로 코드가 등록되었습니다.");
		}
		
	}

	@Override
	public String codeSearch(String id, String code) {
		String result = null;
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn= JDBCUtil.getConnection();
			ps = conn.prepareStatement(Sql.MEMBER_SELECT_CODE);
			
			ps.setString(1, id);
			ps.setString(2, code);
			
			rs= ps.executeQuery();
			if(rs.next()) {
				if(Integer.parseInt(rs.getString("COUNT")) == 1) {
					result = "Y";
				} else {
					result = "N";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs, ps, conn);
		}
		
		return result;
	}

	@Override
	public void updateAuthYN(String id) {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = JDBCUtil.getConnection();
			ps = conn.prepareStatement(Sql.MEMBER_AUTHYN_UPDATE);
			
			ps.setString(1, id);
			
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(null, ps, conn);
			System.out.println("인증정보 저장");
		}
		
	}
	
	@Override
	public void delete(int infono) {
		Connection connection = null;
		PreparedStatement pStatement = null;
		
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.DELETE_LECTUREINFONO_BY_INFONO);
			pStatement.setInt(1, infono);
			
			pStatement.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			JDBCUtil.close(null, pStatement, connection);
		}
		
	}

	@Override
	public int selectInfonoByUsernoAndLectureno(int userno, int lectureno) {
		int infono = 0 ;
		ResultSet resultSet = null;
		Connection connection = null;
		PreparedStatement pStatement = null;
		
			try {
				connection = JDBCUtil.getConnection();
				pStatement = connection.prepareStatement(Sql.SELECT_INFONO_BY_USERNO_AND_LECTURENO);
				pStatement.setInt(1, userno);
				pStatement.setInt(2, lectureno);
				resultSet = pStatement.executeQuery();
				
				while(resultSet.next()) {
					
					infono = resultSet.getInt("infono");
				
				}
				
			} catch (Exception e) {

			}finally {
				JDBCUtil.close(null, pStatement, connection);
			}
		
		
		return infono;
	}

	@Override
	public int selectInfonoByUsernoAndLectureno_ver2(int userno, int lectureno) {
		int result = 0 ;
		ResultSet resultSet = null;
		Connection connection = null;
		PreparedStatement pStatement = null;
		
			try {
				connection = JDBCUtil.getConnection();
				pStatement = connection.prepareStatement(Sql.SELECT_INFONO_BY_USERNO_AND_LECTURENO);
				pStatement.setInt(1, userno);
				pStatement.setInt(2, lectureno);
				resultSet = pStatement.executeQuery();
				
				while(resultSet.next()) {
					
					result = 1;
				
				} 
				
			} catch (Exception e) {

			}finally {
				JDBCUtil.close(null, pStatement, connection);
			}
		
		
		return result;
	}
	public void updateProgress() {
		Connection connection = null;
		PreparedStatement pStatement = null;
		
			try {
				connection = JDBCUtil.getConnection();
				pStatement = connection.prepareStatement(Sql.UPDATE_LECTUREINFO_PROGRESS);
				pStatement.executeUpdate();
				
				
				
			} catch (Exception e) {

			}finally {
				JDBCUtil.close(null, pStatement, connection);
			}
		
		
		

	}
}