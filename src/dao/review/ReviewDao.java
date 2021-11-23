package dao.review;

import java.util.List;

import model.General_Qna;
import model.Review;
import model.ViewReviewSelect;

public interface ReviewDao {

	void reviewInsertByInfoNo(Review review);
	
	List<ViewReviewSelect> selectReviewBylectureNo(int lectureNo);
	List<ViewReviewSelect> reviewSelectMy();
	
	List<ViewReviewSelect> selectReviewByLectureNoToPage( int requestPage,int lectureno );
	
	List<ViewReviewSelect> selectReviewByLectureNoToDetail( int requestPage,int lectureno );
	int ReviewCntByLectureno(int lectureno);
	
}
