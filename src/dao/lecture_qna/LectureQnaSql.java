package dao.lecture_qna;

public class LectureQnaSql {

	public static final String LECTURE_QNA_INSERT_SQL 
	="INSERT INTO LECTURE_QNA (QNANO,SUBJECT,CONTENT,ANSWER,CLICKCOUNT,OPEN,WRITEDATE,USERNO,LECTURENO)" + 
	 " VALUES (LECTURE_QNA_SEQ.NEXTVAL, ?, ?, NULL, 0, ?,sysdate, ?, ?)";

		public static final String LECTURE_QNA_INSERT_BY_NOMEMBER_SQL 
		="INSERT INTO LECTURE_QNA (QNANO,SUBJECT,CONTENT,ANSWER,CLICKCOUNT,OPEN,WRITEDATE,LECTURENO)" + 
		 " VALUES (LECTURE_QNA_SEQ.NEXTVAL, ?, ?, NULL, 0, ?,sysdate, ?)";

	
	
		public static final String LECTURE_QNA_SELECT_BY_LECTURENO_SQL 
    ="SELECT QNANO,SUBJECT,CONTENT,ANSWER,CLICKCOUNT,OPEN,WRITEDATE,USERNO,LECTURENO FROM LECTURE_QNA  WHERE LECTURENO=?";
 
public static final String LECTURE_QNA_SELECT_BY_QNANO_SQL 
	="SELECT * FROM LECTURE_QNA WHERE QNANO = ?";

public static final String LECTURE_QNA_UPDATE_BY_QNANO
="UPDATE LECTURE_QNA SET  SUBJECT = ?, CONTENT = ? ,answer = ? , OPEN = ?  WHERE QNANO = ? ";

public static final String LECTURE_QNA_DELETE_BY_QNANO_SQL 
="DELETE LECTURE_QNA WHERE QNANO = ?";

public static final String LECTURE_QNA_COUNT_BY_LECTURENO_SQL = "SELECT COUNT(*) AS CNT FROM LECTURE_QNA WHERE LECTURENO = ?";

public static final String LECTURE_QNA_COUNT_BY_LECTURENO_AND_USERNO_SQL = "SELECT COUNT(*) AS CNT FROM LECUTRE_QNA WHERE  LECTURENO = ? AND USERNO = ?";

public static final String LECTURE_QNA_COUNT_BY_LECTURENO_AND_SUBJECT_SQL = "SELECT COUNT(*) AS CNT FROM LECTURE_QNA WHERE LECTURENO = ? AND SUBJECT LIKE '%' || ? || '%'";

						  
public static final String LECTURE_QNA_SElECT_BY_LECTURENO_TO_PAGE_SQL 
="select qnano , subject ,content,open ,writedate,clickcount,answer,userno,lectureno  from (select rownum rn, lqs.* from (select * from lecture_qna where lectureno = ? order by qnano desc) lqs) where rn between ? and ?";

public static final String LECTURE_QNA_SElECT_BY_LECTURENO_AND_USERNO_TO_PAGE_SQL 
="select qnano , subject ,content,open ,writedate,clickcount,answer,userno,lectureno"
+ " from (select rownum rn, lqs.* from (select * from lecture_qna WHERE LECTURENO=? AND USERNO = ? order by qnano desc) lqs)"
+ " where rn between ? and ?";

public static final String LECTURE_QNA_SElECT_BY_LECTURENO_AND_SUBJECT_TO_PAGE_SQL 
="select qnano , subject ,content,open ,writedate,clickcount,answer,userno,lectureno"
+ " from (select rownum rn, lqs.* from (select * from lecture_qna  WHERE LECTURENO=? AND SUBJECT LIKE '%' || ? || '%' order by qnano desc) lqs)"
+ " where rn between ? and ?";



public static final String LECTURE_QNA_UPDATE_CLICKCOUNT_BY_QNANO_SQL
="UPDATE LECTURE_QNA SET CLICKCOUNT= ?  WHERE QNANO = ? ";

}
