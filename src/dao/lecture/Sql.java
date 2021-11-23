package dao.lecture;

public class Sql {
	public static final String LECUTRE_INSERT_SQL
	="INSERT INTO LECTURE(LECTURENO,NAME,CONTENT,STARTDATE,ENDDATE,STARTTIME,ENDTIME,"
			+ "REC_STARTDATE,REC_ENDDATE,REC_CNT,REQ_CNT,IMAGENAME,CLICKCOUNT,USERNO,INT_NO) "
			+ "VALUES(LECTURE_SEQ.nextval, ?, ?, TO_DATE(? , 'YYYY-MM-DD'), "
			+ "TO_DATE(? , 'YYYY-MM-DD') , ?, ?, TO_DATE(? , 'YYYY-MM-DD'), "
			+ "TO_DATE(? , 'YYYY-MM-DD'),?,0,?,0,?,?)";
	
public static final String LECUTRE_SELECT_ALL_SQL
	="select * from lecture";

public static final String LECUTRE_SELECT_ALL_BY_POPULARITY_SQL
="select * from lecture WHERE ROWNUM <= 6 ORDER BY clickcount desc";

public static final String LECUTRE_SELECT_BY_POPULARITY_SQL
="select * from \r\n" + 
		"(select l.lectureno,l.name as lecturename, m.name as username, l.startdate, l.imagename,\r\n" + 
		"		l.content, l.enddate,l.starttime,l.endtime,l.rec_startdate,l.rec_enddate,l.rec_cnt,l.req_cnt,l.clickcount,l.int_no,l.userno\r\n" + 
		"		from lecture l inner join member m on l.userno= m.userno order by clickcount desc) where ROWNUM <= 9 order by clickcount desc";

public static final String LECUTRE_SELECT_BY_LECUTRENO_SQL
	="select * from lecture where lectureno= ?";

public static final String LECUTRE_SELECT_BY_INT_NO_SQL
="select * from lecture where int_no= ?";

public static final String LECUTRE_SELECT_BY_USER_INT_NO
="select * from lecture where int_no in (select int_no from member where userno=?) or int_no in (select int_no2 from member where userno=?)";

public static final String LECUTRE_SELECT_BY_INT_NO_SQL2
="select * from (select l.lectureno,l.name as lecturename, m.name as username, l.startdate, l.imagename,  \r\n" + 
		"		l.content, l.enddate,l.starttime,l.endtime,l.rec_startdate,l.rec_enddate,l.rec_cnt,l.req_cnt,l.clickcount,l.int_no,l.userno\r\n" + 
		"		from lecture l inner join member m on l.userno= m.userno\r\n" + 
		"		where l.int_no= ? order by DBMS_RANDOM.RANDOM) where rownum < 10 order by clickcount desc";

public static final String LECUTRE_SELECT_BY_NAME_SQL
="select l.lectureno,l.name as lecturename,l.content ,m.name as username, l.startdate, l.imagename, l.starttime, l.endtime,l.enddate,l.userno,l.int_no,l.clickcount,"
		+ "l.rec_startdate,l.rec_enddate,l.rec_cnt,l.req_cnt"
		+ "  from lecture l inner join member m on l.userno= m.userno WHERE l.NAME LIKE '%' || ? || '% order by l.clickcount desc'";

public static final String LECUTRE_UPDATE_SQL
	="update lecture set CONTENT = ?, STARTDATE = TO_DATE(? , 'YYYY-MM-DD'), ENDDATE = TO_DATE(? , 'YYYY-MM-DD') ,STARTTIME = ? ,"
			+ " ENDTIME = ?, REC_STARTDATE = TO_DATE(? , 'YYYY-MM-DD'), REC_ENDDATE = TO_DATE(? , 'YYYY-MM-DD')," + 
			" REC_CNT = ? , REQ_CNT = 0 , IMAGENAME = ? , CLICKCOUNT = 0 , INT_NO = ? where lectureno=?";

public static final String LECUTRE_DELTE_SQL
	="delete from lecture where lectureno= ?";

public static final String LECUTRE_SELECT_BY_DATE_SEACH_SQL
="select count(*) as cnt from\r\n" + 
		"(select * from lecture where\r\n" + 
		"((enddate BETWEEN TO_DATE(?, 'YYYY-MM-DD') and TO_DATE(?, 'YYYY-MM-DD')) or\r\n" + 
		"(TO_DATE(?, 'YYYY-MM-DD') BETWEEN startdate and enddate) or \r\n" + 
		"(TO_DATE(?, 'YYYY-MM-DD') BETWEEN startdate and enddate)\r\n" + 
		"or (startdate BETWEEN TO_DATE(? , 'YYYY-MM-DD') and TO_DATE( ? , 'YYYY-MM-DD'))))\r\n" + 
		"where ((starttime BETWEEN  ? and ?) or (endtime BETWEEN  ? and ? ) \r\n" + 
		"or (? BETWEEN starttime and endtime) or (? BETWEEN starttime and endtime))\r\n" + 
		"and userno=?";

public static final String LECUTRE_SELECT_BY_LECTURE_INFO_DATE_SEACH_SQL
="select count(*) as cnt from\r\n" + 
		"(select * from \r\n" + 
		"(select * from lecture where lectureno in\r\n" + 
		"(select lectureno from lecture_info where userno=?))\r\n" + 
		"where ((enddate BETWEEN TO_DATE(?, 'YYYY-MM-DD') and TO_DATE(?, 'YYYY-MM-DD')) \r\n" + 
		"or (startdate BETWEEN TO_DATE(?, 'YYYY-MM-DD') and TO_DATE(?, 'YYYY-MM-DD'))\r\n" + 
		"or (TO_DATE(?, 'YYYY-MM-DD') BETWEEN startdate and enddate) or \r\n" + 
		"(TO_DATE(?, 'YYYY-MM-DD') BETWEEN startdate and enddate))) \r\n" + 
		"where ((starttime BETWEEN ? and ?) or (endtime BETWEEN ? and ?) or (? BETWEEN starttime and endtime) or (? BETWEEN starttime and endtime))";

public static final String LECUTRE_SELECT_BY_USER_INTEREST_SEACH_SQL
="select * from\r\n" + 
		"(select * from (select l.lectureno,l.name as lecturename, m.name as username, l.startdate, l.imagename,\r\n" + 
		"l.content, l.enddate,l.starttime,l.endtime,l.rec_startdate,l.rec_enddate,l.rec_cnt,l.req_cnt,l.clickcount,l.int_no,l.userno\r\n" + 
		"from lecture l inner join member m on l.userno= m.userno)\r\n" + 
		"where (int_no in (select int_no from interest where int_no=? or int_no=?))\r\n" + 
		"order by DBMS_RANDOM.RANDOM) where rownum < 10 order by clickcount desc";

public static final String LECUTRE_CLICKCOUNT_UP_SQL
="update lecture set CLICKCOUNT = (select CLICKCOUNT from LECTURE where lectureno=?)+1 where lectureno=?";

public static final String LECTURE_SELECT_BY_ALL_PAGE_SQL
= "select lectureno,name,content,startdate,enddate,starttime,endtime,"
		+"rec_startdate,rec_enddate,rec_cnt,req_cnt,imagename,clickcount,userno,int_no from "
		+ "(select rownum as rn, lectureos.* from " 
		+ "(select * from lecture order by lectureno desc) lectureos) "
		+ " where rn between ? and ? order by clickcount desc";

public static final String LECTURE_SELECT_BY_NAME_PAGE_SQL
= " select * from\r\n" + 
		"(select rownum as rn, lectureos.* from \r\n" + 
		"(select * from (select * from "
		+ "(select l.lectureno,l.name as lecturename, m.name as username, l.startdate, l.imagename,  \r\n" + 
		" l.content, l.enddate,l.starttime,l.endtime,l.rec_startdate,l.rec_enddate,l.rec_cnt,l.req_cnt,l.clickcount,l.int_no,l.userno\r\n" + 
		" from lecture l inner join member m on l.userno= m.userno) \r\n" + 
		" where lecturename LIKE '%' || ? || '%') ) lectureos)\r\n" + 
		" where rn between ? and ? order by clickcount desc";

public static final String LECTURE_SELECT_BY_INT_NO_PAGE_SQL
= "select * from\r\n" + 
		"(select rownum as rn, lectureos.* from \r\n" + 
		"(select * from (select * from \r\n" + 
		"(select l.lectureno,l.name as lecturename, m.name as username, l.startdate, l.imagename,\r\n" + 
		" l.content, l.enddate,l.starttime,l.endtime,l.rec_startdate,l.rec_enddate,l.rec_cnt,l.req_cnt,l.clickcount,l.int_no,l.userno\r\n" + 
		" from lecture l inner join member m on l.userno= m.userno)\r\n" + 
		" where int_no=? )) lectureos) \r\n" + 
		" where rn between ? and ? order by clickcount desc";


	public static final String INTEREST_BY_NO
	="SELECT * FROM INTEREST WHERE INT_NO = ?";
	
	public static final String USERNAME_BY_NO
	="SELECT * FROM MEMBER WHERE USERNO = ?";
	
	public static final String TEACHER_NAME_BY_NO
	="SELECT USERNO FROM LECTURE WHERE LECTURENO = ?";
	
	
	
	
}

