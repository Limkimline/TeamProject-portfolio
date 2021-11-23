package dao.basket;

public class Sql {
	
	public static final String BASKET_INSERT
	= "INSERT INTO BASKET(userno,lectureno) VALUES (?,?)";
	
	public static final String BASKET_SELECT_BY_USERNO
	="select * from lecture where lectureno in (select lectureno from BASKET where userno=?)";
	
	public static final String BASKET_DELETE
	="DELETE FROM BASKET WHERE USERNO=? AND LECTURENO=?";
	
	public static final String BASKET_DATE_DELETE
	="DELETE FROM BASKET WHERE USERNO=? AND LECTURENO IN\r\n" + 
			"((select LECTURENO from lecture where TO_char(sysdate,'YYYY-MM-DD') >= rec_enddate))";
	
	public static final String BASKET_SELECT_BY_USERNO_PAGING
	="select * from \r\n" + 
			"(select rownum as rn, basketos.* from \r\n" + 
			"(select * from lecture where lectureno in \r\n" + 
			"(select lectureno from basket where userno=?)) basketos)\r\n" + 
			"where rn between ? and ?";
}
