package dao.lecture;

import java.util.List;

import model.Lecture;
import model.Member;

public interface LectureDao {
	void insert(Lecture lecture);
	void update(Lecture lecture);
	void delete(int lecutreno);
	void updateReqCnt(int lectureNo);
	List<Lecture> selectAll();
	Lecture selectByLectureno(int lectureno);
	List<Lecture> selectByName(String name);
	List<Lecture> selectByInt_no(int int_no);
	List<Lecture> selectByInt_no2(int int_no);
	List<Lecture> selectByUserno(int userno);
	List<Lecture> selectAllByPopularity();
	List<Lecture> selectByPopularity();
 	void selectClcikcount(int clickcount);

 	int dateSeach(String startdate, String enddate, String starttime, String endtime, int userno);
 	int lectureInfoDateSeach(String startdate, String enddate, String starttime, String endtime, int userno);
 	List<Lecture> selectByUserInterest(int int_no, int int_no2);
 	String selectInterestByno(int no);
 	String selectMemberByno(int no);
 	Member selectTeacherByno(int no);
 	
 	
 	List<Lecture> selectAll(int requestPage);
 	List<Lecture> selectByName(String name,int requestPage);
 	List<Lecture> selectByInt_no2(int int_no,int requestPage);

}