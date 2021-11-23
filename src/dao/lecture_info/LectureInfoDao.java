package dao.lecture_info;

import java.util.List;

import model.Lecture_Info;
import model.Lecture_Info2;

public interface LectureInfoDao {
	
	void insert(int userNo, int lectureNo);
	
	void delete(int infono);

	void updateProgress();
	//List<Lecture_Info2>  selectByUserno(int userno);
	//List<Lecture_Info2>  selectByUserno2(int userno, int requestPage);
	
	List<Lecture_Info2>  selectByStartdateLectureName(int userno, String startdate, String lectureName);
	List<Lecture_Info2>  selectByStartdateLectureName2(int userno, String startdate, String lectureName, int requestPage);
	
	List<Lecture_Info2>  selectByEnddateLectureName(int userno, String enddate, String lectureName);
	List<Lecture_Info2>  selectByEnddateLectureName2(int userno, String enddate, String lectureName, int requestPage);
	
	List<Lecture_Info2>  selectByStartdateEnddateLectureName(int userno, String startdate, String enddate, String lectureName);
	List<Lecture_Info2>  selectByStartdateEnddateLectureName2(int userno, String startdate, String enddate, String lectureName, int requestPage);
	
	List<Lecture_Info2>  selectByLectureName(int userno, String lectureName);
	List<Lecture_Info2>  selectByLectureName2(int userno, String lectureName, int requestPage);
	
	//int countLectureInfo(String sql);
	
	List<Lecture_Info2> selectMyLectureByLectureName(int userno, String lectureName);
	List<Lecture_Info2>  selectMyLectureByLectureName2(int userno, String lectureName, int requestPage);
	
	List<Lecture_Info2> selectMyLectureByLectureNameStartdate(int userno, String lectureName, String startdate);
	List<Lecture_Info2> selectMyLectureByLectureNameStartdate2(int userno, String lectureName, String startdate, int requestPage);
	
	List<Lecture_Info2> selectMyLectureByLectureNameEnddate(int userno, String lectureName, String enddate);
	List<Lecture_Info2> selectMyLectureByLectureNameEnddate2(int userno, String lectureName, String enddate, int requestPage);
	
	List<Lecture_Info2> selectMyLectureByLectureNameStartdateEnddate(int userno, String lectureName, String startdate, String enddate);
	List<Lecture_Info2> selectMyLectureByLectureNameStartdateEnddate2(int userno, String lectureName, String startdate, String enddate, int requestPage);
	
	void codeUpdate(String id, String code);
	String codeSearch(String id, String code);
	void updateAuthYN(String id);
	
	int selectInfonoByUsernoAndLectureno(int userno,int lectureno);
	int selectInfonoByUsernoAndLectureno_ver2(int userno,int lectureno);
	
	
	
	
}
