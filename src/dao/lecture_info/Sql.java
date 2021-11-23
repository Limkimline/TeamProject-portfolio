package dao.lecture_info;

public class Sql {

	/*
	public static final String LISTEN_LECTUREINFO_LIST_ALL_SQL =
			"select i.userno, i.lectureno, i.infono, i.progress, i.attendance, " + 
			"l.name, l.startdate, l.enddate, l.int_no, l.userno, l.imagename " + 
			"from lecture_info i join lecture l on i.lectureno = l.lectureno where i.userno = ? order by l.startdate desc";

	public static final String LISTEN_LECTUREINFO_LIST_ALL_SQL2 =
	"select * " +
	"from (select rownum rn, members.* from (select i.userno as userno, i.lectureno, i.infono, i.progress, i.attendance, " +
	"l.name, l.startdate, l.enddate, l.int_no, l.userno as userno2, l.imagename " +
	"from lecture_info i join lecture l on i.lectureno = l.lectureno where i.userno = ? order by l.startdate desc" +
	") members) " +
	"where rn between ? and ?";
	*/
	public static final String LISTEN_LECTUREINFO_LIST_BY_STARTDATE_SQL =
			"select i.userno, i.lectureno, i.infono, i.progress, i.attendance, " + 
			"l.name, l.startdate, l.enddate, l.int_no, l.userno, l.imagename " + 
			"from lecture_info i join lecture l on i.lectureno = l.lectureno where i.userno = ? " + 
			"and l.startdate >= to_date(?,'yyyy-MM-dd') and upper(l.name) like '%'||upper(?)||'%' order by l.startdate desc";

	public static final String LISTEN_LECTUREINFO_LIST_BY_STARTDATE_SQL2 =
			"select *\n" + 
			"from (select rownum rn, members.* from (select i.userno as userno, i.lectureno, i.infono, i.progress, i.attendance,\n" + 
			"l.name, l.startdate, l.enddate, l.int_no, l.userno as userno2, l.imagename\n" + 
			"from (select i2.userno, i.lectureno, i2.infono, i.progress, i2.attendance from\n" + 
			"(select i.lectureno, case when i.progress >=100 then 100\n" + 
			"				when i.progress <=0 then 0\n" + 
			"				else i.progress\n" + 
			"				end as progress\n" + 
			"from (select lectureno, round((sysdate-startdate)/(enddate-startdate)*100) as progress from lecture)i)i\n" + 
			"join (select * from lecture_info )i2 on i.lectureno = i2.lectureno) i join lecture l on i.lectureno = l.lectureno where i.userno = ?\n" + 
			"and l.startdate >= to_date(?,'yyyy-MM-dd') and upper(l.name) like '%'||upper(?)||'%' order by startdate desc) members)\n" + 
			"where rn between ? and ?";
	
	
	public static final String LISTEN_LECTUREINFO_LIST_BY_ENDDATE_SQL = 
			"select i.userno, i.lectureno, i.infono, i.progress, i.attendance, " + 
			"l.name, l.startdate, l.enddate, l.int_no, l.userno, l.imagename " + 
			"from lecture_info i join lecture l on i.lectureno = l.lectureno where i.userno = ? " + 
			"and l.enddate <= to_date(?,'yyyy-MM-dd') and upper(l.name) like '%'||upper(?)||'%' order by l.startdate desc";

	public static final String LISTEN_LECTUREINFO_LIST_BY_ENDDATE_SQL2 =
			"select *\n" + 
			"from (select rownum rn, members.* from (select i.userno as userno, i.lectureno, i.infono, i.progress, i.attendance,\n" + 
			"l.name, l.startdate, l.enddate, l.int_no, l.userno as userno2, l.imagename\n" + 
			"from (select i2.userno, i.lectureno, i2.infono, i.progress, i2.attendance from\n" + 
			"(select i.lectureno, case when i.progress >=100 then 100\n" + 
			"				when i.progress <=0 then 0\n" + 
			"				else i.progress\n" + 
			"				end as progress\n" + 
			"from (select lectureno, round((sysdate-startdate)/(enddate-startdate)*100) as progress from lecture)i)i\n" + 
			"join (select * from lecture_info )i2 on i.lectureno = i2.lectureno) i join lecture l on i.lectureno = l.lectureno where i.userno = ?\n" + 
			"and l.enddate <= to_date(?,'yyyy-MM-dd') and upper(l.name) like '%'||upper(?)||'%' order by startdate desc) members)\n" + 
			"where rn between ? and ?";
	
	
	public static final String LISTEN_LECTUREINFO_LIST_BY_STARTDATE_ENDDATE_SQL = 
			"select i.userno, i.lectureno, i.infono, i.progress, i.attendance, " + 
			"l.name, l.startdate, l.enddate, l.int_no, l.userno, l.imagename " + 
			"from lecture_info i join lecture l on i.lectureno = l.lectureno where i.userno = ? " + 
			"and l.startdate >= to_date(?,'yyyy-MM-dd') and l.enddate <= to_date(?,'yyyy-MM-dd') and upper(l.name) like '%'|| upper(?) ||'%' order by l.startdate desc";
	
	public static final String LISTEN_LECTUREINFO_LIST_BY_STARTDATE_ENDDATE_SQL2 =
			"select *\n" + 
			"from (select rownum rn, members.* from (select i.userno as userno, i.lectureno, i.infono, i.progress, i.attendance,\n" + 
			"l.name, l.startdate, l.enddate, l.int_no, l.userno as userno2, l.imagename\n" + 
			"from (select i2.userno, i.lectureno, i2.infono, i.progress, i2.attendance from\n" + 
			"(select i.lectureno, case when i.progress >=100 then 100\n" + 
			"				when i.progress <=0 then 0\n" + 
			"				else i.progress\n" + 
			"				end as progress\n" + 
			"from (select lectureno, round((sysdate-startdate)/(enddate-startdate)*100) as progress from lecture)i)i\n" + 
			"join (select * from lecture_info )i2 on i.lectureno = i2.lectureno) i join lecture l on i.lectureno = l.lectureno where i.userno = ?\n" + 
			"and l.startdate >= to_date(?,'yyyy-MM-dd') and l.enddate <= to_date(?,'yyyy-MM-dd') and upper(l.name) like '%'||upper(?)||'%' order by startdate desc) members)\n" + 
			"where rn between ? and ?";
	
	
	public static final String LISTEN_LECTUREINFO_LIST_BY_LECTURENAME =
			"select i.userno, i.lectureno, i.infono, i.progress, i.attendance, " + 
			"l.name, l.startdate, l.enddate, l.int_no, l.userno, l.imagename " + 
			"from lecture_info i join lecture l on i.lectureno = l.lectureno where i.userno = ? " + 
			"and upper(l.name) like '%'||upper(?)||'%' order by l.startdate desc";
	

	public static final String LISTEN_LECTUREINFO_LIST_BY_LECTURENAME2 =
			"select *\n" + 
			"from (select rownum rn, members.* from (select i.userno as userno, i.lectureno, i.infono, i.progress, i.attendance,\n" + 
			"l.name, l.startdate, l.enddate, l.int_no, l.userno as userno2, l.imagename\n" + 
			"from (select i2.userno, i.lectureno, i2.infono, i.progress, i2.attendance from\n" + 
			"(select i.lectureno, case when i.progress >=100 then 100\n" + 
			"				when i.progress <=0 then 0\n" + 
			"				else i.progress\n" + 
			"				end as progress\n" + 
			"from (select lectureno, round((sysdate-startdate)/(enddate-startdate)*100) as progress from lecture)i)i\n" + 
			"join (select * from lecture_info )i2 on i.lectureno = i2.lectureno) i join lecture l on i.lectureno = l.lectureno where i.userno = ?\n" + 
			"and upper(l.name) like '%'||upper(?)||'%' order by startdate desc) members)\n" + 
			"where rn between ? and ?";
	
	
	public static final String COUNT_SQL =
			"select count(*) as cnt from " + 
			"(?)";
	
	
	
	public static final String MY_LECTURE_LECTUREINFO_LIST_BY_LECTURENAME =
			"select case when i.progress is null then 0\r\n" + 
			"else i.progress end as progress, l.* from (select distinct progress, lectureno from lecture_info)i \r\n" + 
			"right join (select lectureno, name, startdate, enddate, imagename, userno as 강사자번호, \r\n" + 
			"(select name from member where userno = ?) as 강사이름,int_no,\r\n" + 
			"rec_cnt, req_cnt from lecture where userno=? and upper(name) like '%'||upper(?)||'%')l\r\n" + 
			"on i.lectureno = l.lectureno order by l.startdate desc";

	public static final String MY_LECTURE_LECTUREINFO_LIST_BY_LECTURENAME2 =
			"select * from\n" + 
			"(select rownum rn, i.progress, l.* from (select i.lectureno, case when i.progress >=100 then 100\n" + 
			"				when i.progress <=0 then 0\n" + 
			"				else i.progress\n" + 
			"				end as progress\n" + 
			"from (select lectureno, round((sysdate-startdate)/(enddate-startdate)*100) as progress from lecture)i )i\n" + 
			"right join (select lectureno, name, startdate, enddate, imagename, userno as 강사자번호, \n" + 
			"(select name from member where userno = ?) as 강사이름,int_no,\n" + 
			"rec_cnt, req_cnt from lecture where userno=? and upper(name) like '%'||upper(?)||'%' order by startdate desc)l\n" + 
			"on i.lectureno = l.lectureno ) where rn between ? and ? ";

	public static final String MY_LECTURE_LECTUREINFO_LIST_BY_LECTURENAME_STARTDATE =
			"select case when i.progress is null then 0\r\n" + 
			"else i.progress end as progress, l.* from (select distinct progress, lectureno from lecture_info)i \r\n" + 
			"right join (select lectureno, name, startdate, enddate, imagename, userno as 강사자번호, \r\n" + 
			"(select name from member where userno = ?) as 강사이름,int_no,\r\n" + 
			"rec_cnt, req_cnt from lecture where userno=? and upper(name) like '%'||upper(?)||'%'\r\n" + 
			"and startdate >= to_date(?,'yyyy-MM-dd'))l\r\n" + 
			"on i.lectureno = l.lectureno order by l.startdate desc";
	
	public static final String MY_LECTURE_LECTUREINFO_LIST_BY_LECTURENAME_STARTDATE2 =
			"select * from\n" + 
			"(select rownum rn, i.progress, l.* from (select i.lectureno, case when i.progress >=100 then 100\n" + 
			"				when i.progress <=0 then 0\n" + 
			"				else i.progress\n" + 
			"				end as progress\n" + 
			"from (select lectureno, round((sysdate-startdate)/(enddate-startdate)*100) as progress from lecture)i )i\n" + 
			"right join (select lectureno, name, startdate, enddate, imagename, userno as 강사자번호, \n" + 
			"(select name from member where userno = ?) as 강사이름,int_no,\n" + 
			"rec_cnt, req_cnt from lecture where userno=? and upper(name) like '%'||upper(?)||'%'\n" + 
			"and startdate >= to_date(?,'yyyy-MM-dd') order by startdate desc)l\n" + 
			"on i.lectureno = l.lectureno ) where rn between ? and ?";
	
	public static final String MY_LECTURE_LECTUREINFO_LIST_BY_LECTURENAME_ENDDATE =
			"select case when i.progress is null then 0\r\n" + 
			"else i.progress end as progress, l.* from (select distinct progress, lectureno from lecture_info)i \r\n" + 
			"right join (select lectureno, name, startdate, enddate, imagename, userno as 강사자번호, \r\n" + 
			"(select name from member where userno = ?) as 강사이름,int_no,\r\n" + 
			"rec_cnt, req_cnt from lecture where userno=? and upper(name) like '%'||upper(?)||'%'\r\n" + 
			"and enddate <= to_date(?,'yyyy-MM-dd'))l\r\n" + 
			"on i.lectureno = l.lectureno order by l.startdate desc";
	
	public static final String MY_LECTURE_LECTUREINFO_LIST_BY_LECTURENAME_ENDDATE2 =
			"select * from\n" + 
			"(select rownum rn, i.progress, l.* from (select i.lectureno, case when i.progress >=100 then 100\n" + 
			"				when i.progress <=0 then 0\n" + 
			"				else i.progress\n" + 
			"				end as progress\n" + 
			"from (select lectureno, round((sysdate-startdate)/(enddate-startdate)*100) as progress from lecture)i )i\n" + 
			"right join (select lectureno, name, startdate, enddate, imagename, userno as 강사자번호, \n" + 
			"(select name from member where userno = ?) as 강사이름,int_no,\n" + 
			"rec_cnt, req_cnt from lecture where userno=? and upper(name) like '%'||upper(?)||'%'\n" + 
			"and enddate <= to_date(?,'yyyy-MM-dd') order by startdate desc)l\n" + 
			"on i.lectureno = l.lectureno \n" + 
			") where rn between ? and ?";
	
	
	public static final String MY_LECTURE_LECTUREINFO_LIST_BY_LECTURENAME_STARTDATE_ENDDATE =
			"select case when i.progress is null then 0\r\n" + 
			"else i.progress end as progress, l.* from (select distinct progress, lectureno from lecture_info)i \r\n" + 
			"right join (select lectureno, name, startdate, enddate, imagename, userno as 강사자번호, \r\n" + 
			"(select name from member where userno = ?) as 강사이름,int_no,\r\n" + 
			"rec_cnt, req_cnt from lecture where userno=? and upper(name) like '%'||upper(?)||'%'\r\n" + 
			"and startdate >= to_date(?,'yyyy-MM-dd') and enddate <= to_date(?,'yyyy-MM-dd'))l\r\n" + 
			"on i.lectureno = l.lectureno order by l.startdate desc";
	
	public static final String MY_LECTURE_LECTUREINFO_LIST_BY_LECTURENAME_STARTDATE_ENDDATE2 =
			"select * from\n" + 
			"			(select rownum rn, i.progress, l.* from (select i.lectureno, case when i.progress >=100 then 100\n" + 
			"							when i.progress <=0 then 0\n" + 
			"							else i.progress\n" + 
			"							end as progress\n" + 
			"			from (select lectureno, round((sysdate-startdate)/(enddate-startdate)*100) as progress from lecture)i )i\n" + 
			"			right join (select lectureno, name, startdate, enddate, imagename, userno as 강사자번호, \n" + 
			"			(select name from member where userno = ?) as 강사이름,int_no,\n" + 
			"			rec_cnt, req_cnt from lecture where userno=? and upper(name) like '%'||upper(?)||'%'\n" + 
			"			and startdate >= to_date(?,'yyyy-MM-dd') and enddate <= to_date(?,'yyyy-MM-dd'))l\n" + 
			"			on i.lectureno = l.lectureno order by l.startdate desc)\n" + 
			"			where rn between ? and ?";

	public static final String INSERT_ENROLL_INFO = "INSERT INTO LECTURE_INFO VALUES (LECTURE_INFO_SEQ.NEXTVAL,0,0,?,?)";
	
	public static final String DELETE_LECTUREINFONO_BY_INFONO =
			"delete from lecture_info where infono = ?";

	public static final String MEMBER_CODE_UPDATE = "UPDATE MEMBER SET MAILHASH = ? WHERE ID = ?";
	public static final String MEMBER_SELECT_CODE = "SELECT COUNT(*) AS COUNT FROM MEMBER WHERE ID = ? AND MAILHASH = ?";
	public static final String MEMBER_AUTHYN_UPDATE = "UPDATE MEMBER SET CERTIFICATION = 'Y' WHERE ID = ?";
	
	public static final String SELECT_INFONO_BY_USERNO_AND_LECTURENO = "select infono from Lecture_info where userno = ? and lectureno = ?";
	
	public static final String UPDATE_LECTUREINFO_PROGRESS 
		= "update lecture_info l set progress = (select case when i.progress >=100 then 100\n" + 
				"				when i.progress <=0 then 0\n" + 
				"				else i.progress\n" + 
				"				end as progress2\n" + 
				"from (select lectureno, startdate, round((sysdate-startdate)/(enddate-startdate)*100)\n" + 
				"as progress from lecture)i where l.lectureno = i.lectureno) ";
}

