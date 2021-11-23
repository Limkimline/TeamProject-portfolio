package dao.review;

public class ReviewSql {

	public static final String REVIEW_SElECT_BY_LECTURENO_SQL 
	="select content,score,id,writedate from member m inner join(select r.content,r.score,r.writedate,l.userno,l.lectureno from LECTURE_INFO l inner join REVIEW r on l.infono=r.infono where l.lectureno=?) ee on m.userno= ee.userno";
	

	public static final String REVIEW_INSERT_BY_INFONO_SQL
	= "INSERT INTO REVIEW (INFONO,CONTENT,SCORE,WRITEDATE ) VALUES (?, ? , ?,sysdate)";
	
	
	public static final String REVIEW_SElECT_BY_LECTURENO_TO_PAGE_SQL 
	="select  rownum rn,content,score,id,writedate" + 
			"				from " + 
			"				(" + 
			"				select rownum rn, content,score,id,writedate" + 
			"				from" + 
			"				(" + 
			"				select    content,score,id,writedate from  member m inner join " + 
			"				(select r.content,r.score,r.writedate,l.userno,l.lectureno from LECTURE_INFO l  inner join REVIEW r on l.infono=r.infono where l.lectureno=? )ee " + 
			"				 on m.userno= ee.userno  order by writedate desc " + 
			"				 )" + 
			"				 )" + 
			"				where rn between ? and ?";
	
	


	
	public static final String REVIEW_COUNT_BY_LECTURENO_SQL = "SELECT COUNT(*) AS CNT FROM (select content,score,id,writedate from member m inner join(select r.content,r.score,r.writedate,l.userno,l.lectureno from LECTURE_INFO l inner join REVIEW r on l.infono=r.infono where l.lectureno=?) ee on m.userno= ee.userno)";

	public static final String REVIEW_COUNT_BY_LECTURENO_IN_MY_SQL = "SELECT COUNT(*) AS CNT FROM (select content,score,id,writedate from member m inner join(select r.content,r.score,r.writedate,l.userno,l.lectureno from LECTURE_INFO l inner join REVIEW r on l.infono=r.infono where l.lectureno=?) ee on m.userno= ee.userno where id = ?)";

	
}

