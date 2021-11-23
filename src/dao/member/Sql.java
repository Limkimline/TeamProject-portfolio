
package dao.member;

public class Sql {
	
	public static final String MEMBER_SELECT_BY_USERNO_NAME_SQL = 
			"SELECT NAME FROM MEMBER WHERE USERNO = ?";
	
	public static final String MEMBER_INSERT_SQL
		="insert into MEMBER(userno,id,pwd,name,gender,phone,email,certification,imagename,int_no,int_no2) "
				+ "values(MEMBER_SEQ.nextval,?,?,?,?,?,?,?,?,?,?)";
	
	public static final String MEMBER_CNT_BY_ID = "SELECT COUNT(ID) AS CNT FROM MEMBER WHERE ID = ?";
	
	public static final String MEMBER_SELECT_ALL_SQL
		="select * from member";
	
	public static final String MEMBER_SELECT_BY_ID_PWD = "SELECT * FROM MEMBER WHERE ID = ? AND PWD = ?";
	
	public static final String MEMBER_SELECT_BY_ID_EMAIL = "SELECT COUNT(*) AS RESULTCNT FROM MEMBER WHERE ID = ? AND EMAIL = ?";
	
	public static final String MEMBER_SELECT_BY_USERNO_SQL
		="select * from member where userno= ?";
	public static final String MEMBER_SELECT_BY_ID_SQL
		="select * from member where id= ?";
	
	public static final String MEMBER_SELECT_BY_NAME_EMAIL_SQL
	="select ID from member where name= ? and email = ?";
	
	public static final String MEMBER_SELECT_BY_NAME_EMAIL_ALL_SQL
	="select * from member where name= ? and email = ?";

	public static final String MEMBER_HASH_UPDATE = "UPDATE MEMBER SET MAILHASH = ? WHERE ID = ?";
	public static final String MEMBER_PASSWORD_UPDATE = "UPDATE MEMBER SET PWD = ? WHERE MAILHASH = ?";
	
	
	
	public static final String MEMBER_UPDATE_SQL
		="update member set id=?,pwd=?,name=?,gender=?,phone=?,email=?,certification=?,imagename=?,int_no=?,int_no2=? where userno= ?";
	
	public static final String MEMBER_DELETE_MEMBERHASH = "UPDATE MEMBER SET MAILHASH = NULL WHERE MAILHASH = ?";
	public static final String MEMBER_SELECT_HASH = "SELECT COUNT(MAILHASH) AS COUNT FROM MEMBER WHERE MAILHASH = ?";
	
	public static final String MEMBER_DELTE_SQL
		="delete from member where userno= ?";
	
	public static final String MEMBER_UPDATE_CERTIFICATION_SQL
	= "update member set certification=? where userno=?";
	
	public static final String INSERT_CODE = "INSERT INTO JOINCODE VALUES(?,?)";
	public static final String SEARCH_CODE = "SELECT COUNT(*) AS COUNT FROM JOINCODE WHERE CODE = ?";
	public static final String DELETE_CODE = "DELETE FROM JOINCODE WHERE CODE = ?";

}


