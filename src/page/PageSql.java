package page;

public class PageSql {
	public static final String LECTURE_COUNT_SQL=
			"select count(*) AS cnt from lecture";
	public static final String LECTURE_COUNT_SEARCH_NAME_SQL=
			"select count(*) AS cnt from lecture where NAME LIKE '%' || ? || '%'";
	public static final String LECTURE_COUNT_SEARCH_INT_NO_SQL=
			"select count(*) AS cnt from lecture where int_no=?";
	
	public static final String BASKET_COUNT_SEARCH_INT_NO_SQL=
			"select count(*) AS cnt from lecture where lectureno in (select lectureno from basket where userno=?)";
	
}
