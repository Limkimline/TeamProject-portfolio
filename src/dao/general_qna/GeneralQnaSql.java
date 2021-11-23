package dao.general_qna;

public class GeneralQnaSql {

	
	public static final String GENERAL_QNA_INSERT_SQL 
	="INSERT INTO GENERAL_QNA (QNANO,SUBJECT,CONTENT,ANSWER,CLICKCOUNT,OPEN,WRITEDATE,USERNO,MANAGERNO)" + 
	 " VALUES (GENERAL_QNA_SEQ.NEXTVAL, ?, ?, NULL, 0, ?,sysdate, ?, ?)";

		public static final String GENERAL_QNA_INSERT_BY_NOMEMBER_SQL 
		="INSERT INTO GENERAL_QNA (QNANO,SUBJECT,CONTENT,ANSWER,CLICKCOUNT,OPEN,WRITEDATE,MANAGERNO)" + 
		 " VALUES (GENERAL_QNA_SEQ.NEXTVAL, ?, ?, NULL, 0, ?,sysdate, ?)";

	
	
public static final String GENERAL_QNA_SELECT_ALL_SQL 
    ="SELECT QNANO,SUBJECT,CONTENT,ANSWER,CLICKCOUNT,OPEN,WRITEDATE,USERNO,MANAGERNO FROM GENERAL_QNA ";
 
public static final String GENERAL_QNA_SELECT_BY_QNANO_SQL 
	="SELECT * FROM GENERAL_QNA WHERE QNANO = ?";

public static final String GENERAL_QNA_UPDATE_BY_QNANO
="UPDATE GENERAL_QNA SET  SUBJECT = ?, CONTENT = ? ,answer = ? , OPEN = ?  WHERE QNANO = ? ";

public static final String GENERAL_QNA_DELETE_BY_QNANO_SQL 
="DELETE GENERAL_QNA WHERE QNANO = ?";

public static final String GENERAL_QNA_COUNT_ALL_SQL = "SELECT COUNT(*) AS CNT FROM GENERAL_QNA";

public static final String GENERAL_QNA_COUNT_BY_USERNO_SQL = "SELECT COUNT(*) AS CNT FROM GENERAL_QNA WHERE USERNO = ?";

public static final String GENERAL_QNA_COUNT_BY_SUBJECT_SQL = "SELECT COUNT(*) AS CNT FROM GENERAL_QNA WHERE SUBJECT LIKE '%' || ? || '%'";

public static final String GENERAL_QNA_SElECT_ALL_TO_PAGE_SQL 
="select qnano , subject ,content,open ,writedate,clickcount,answer,userno,managerno"
+ " from (select rownum rn, gqs.* from (select * from general_qna order by qnano desc) gqs)"
+ " where rn between ? and ?";

public static final String GENERAL_QNA_SElECT_BY_USERNO_TO_PAGE_SQL 
="select qnano , subject ,content,open ,writedate,clickcount,answer,userno,managerno"
+ " from (select rownum rn, gqs.* from (select * from general_qna WHERE USERNO = ? order by qnano desc) gqs)"
+ " where rn between ? and ?";

public static final String GENERAL_QNA_SElECT_ALL_BY_SUBJECT_TO_PAGE_SQL 
="select qnano , subject ,content,open ,writedate,clickcount,answer,userno,managerno"
+ " from (select rownum rn, gqs.* from (select * from general_qna  WHERE SUBJECT LIKE '%' || ? || '%' order by qnano desc) gqs)"
+ " where rn between ? and ?";

public static final String GENERAL_QNA_UPDATE_CLICKCOUNT_BY_QNANO_SQL
	="UPDATE GENERAL_QNA SET CLICKCOUNT= ?  WHERE QNANO = ? ";


}




