package page;

public interface PageDao {
	
	int getCount(String sql);
	int getCount(String sql,String name);
	int getCount(String sql,int int_no);
	int getCount(int userno);
}
