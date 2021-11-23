
package dao.member;

import java.util.List;

import model.Member;

public interface MemberDao {
	
	void insert(Member member);
	
	void update(Member member);
	void updatePwd(String pwd, String hash);
	void hashUpdate(String id, String hash);
	
	void hashDelete(String hash);
	void delete(int userno);
	
	Member selectUser(String id, String pwd);
	String hashSearch(String hash);
	String selectByNameEmail(String name, String email);
	Member selectByUserno(int userno);
	Member selectById(String id);
	String selectByIDEmail(String id, String email);
	
	void insertCode(String email,String code);
	String searchCode(String code);
	void deleteCode(String code);
	
	int searchCount(String id);

	List<Member> selectAll();
	List<String> selectIdList(String name, String email);
	void update_certification(Member member);
	
}
