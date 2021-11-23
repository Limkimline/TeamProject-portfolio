package dao.lecture_qna;

import java.util.List;



import model.Lecture_Qna;

public interface LectureQnaDao {
	void LecturelQnaInsert(Lecture_Qna lq  );
	void LectureQnaInsertByNoMember(Lecture_Qna lq  );
	
	List<Lecture_Qna> LectrueQnaSearchByLectureno(int lectureno);

	Lecture_Qna LectureQnaSelectByQnaNo(int qnaNo);
	
	List<Lecture_Qna> selectByLectureNoToPage( int requestPage,int lectureno );
	List<Lecture_Qna> selectByLecturenoAndUsernoToPage( int requestPage,int lectureno,  int userno );
	List<Lecture_Qna> selectByLecturenoAndSubjectToPage( int requestPage, int lectureno, String subject );
	
	
	
	
	
	void LectureQnaUpdateByQnaNo(Lecture_Qna lq);

	void LectureQnaDeleteByQnano(int qnano);
	
	
	int LectureQnaCntByLectureno(int lectureno);
	int LectureQnaCntByLecturenoAndUserno(int lectureno  ,int userno);
	int LectureQnaCntByLecturenoAndSubject(int lectureno,String subject);
	
	void updateClickCount(Lecture_Qna lq);
	
}
