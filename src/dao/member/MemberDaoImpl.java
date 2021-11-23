package dao.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.JDBCUtil;
import model.Member;
import util.MailSend;

public class MemberDaoImpl implements MemberDao {

	@Override
	public void insert(Member member) {
		Connection conn = null;
		PreparedStatement ps = null;
		
		//System.out.println(member.getImageName());
		
		try {
			conn = JDBCUtil.getConnection();
			ps = conn.prepareStatement(Sql.MEMBER_INSERT_SQL);
			
			ps.setString(1, member.getId());
			ps.setString(2, member.getPwd());
			ps.setString(3, member.getName());
			ps.setString(4, member.getGender());
			ps.setString(5, member.getPhone());
			ps.setString(6, member.getEmail());
			ps.setString(7, member.getCertification());
			ps.setString(8, member.getImageName());
			ps.setInt(9, member.getInt_no());
			ps.setInt(10, member.getInt_no2());
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(null, ps, conn);
		}

	}

	@Override
	public void update(Member member) {
		Connection connection = null;
		PreparedStatement pStatement = null;
		
		
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.MEMBER_UPDATE_SQL);
			
			//update memo set id=?,pwd=?,name=?,gender=?,phone=?,email=?,certification=?,
			//		imagename=?,int_no=?,int_no2=? where userno= ?
			
			pStatement.setString(1, member.getId());
			pStatement.setString(2, member.getPwd());
			pStatement.setString(3, member.getName());
			pStatement.setString(4, member.getGender());
			pStatement.setString(5,member.getPhone());
			pStatement.setString(6, member.getEmail());
			pStatement.setString(7, member.getCertification());
			pStatement.setString(8, member.getImageName());
			pStatement.setInt(9, member.getInt_no());
			pStatement.setInt(10, member.getInt_no2());
			pStatement.setInt(11, member.getUserno());
			pStatement.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			JDBCUtil.close(null, pStatement, connection);
			
		}
		

	}

	@Override
	public void delete(int userno) {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = JDBCUtil.getConnection();
			ps = conn.prepareStatement(Sql.MEMBER_DELTE_SQL);
			
			ps.setInt(1, userno);
			
			ps.executeUpdate();			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(null, ps, conn);
		}

	}

	@Override
	public List<Member> selectAll() {
		List<Member> memberList = new ArrayList<>();
		
		Connection connection = null;
		PreparedStatement pStatement= null;
		ResultSet resultSet= null;
		
		try {
			connection= JDBCUtil.getConnection();
			pStatement= connection.prepareStatement(Sql.MEMBER_SELECT_ALL_SQL);
			resultSet= pStatement.executeQuery();
			
			while(resultSet.next()) {
			
				Member member= new Member();		 
				member.setUserno(resultSet.getInt("userno"));
				member.setId(resultSet.getString("id"));
				member.setPwd(resultSet.getString("pwd"));
				member.setName(resultSet.getString("name"));
				member.setGender(resultSet.getString("gender"));
				member.setPhone(resultSet.getString("phone"));
				member.setEmail(resultSet.getString("email"));
				member.setCertification(resultSet.getString("certification"));
				member.setImageName(resultSet.getString("imagename"));
				member.setInt_no(resultSet.getInt("int_no"));
				member.setInt_no2(resultSet.getInt("int_no2"));
				
				memberList.add(member);

			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(resultSet, pStatement, connection);
		}
		return memberList;
	}

	@Override
	public Member selectByUserno(int userno) {
		Member member= null;
		Connection connection = null;
		PreparedStatement pStatement= null;
		ResultSet resultSet= null;
		
		try {
			connection= JDBCUtil.getConnection();
			pStatement= connection.prepareStatement(Sql.MEMBER_SELECT_BY_USERNO_SQL);
			
			pStatement.setInt(1, userno); 
			
			resultSet= pStatement.executeQuery();
			if(resultSet.next()) {
				member= new Member();
				
				member.setUserno(resultSet.getInt("userno"));
				member.setId(resultSet.getString("id"));
				member.setPwd(resultSet.getString("pwd"));
				member.setName(resultSet.getString("name"));
				member.setGender(resultSet.getString("gender"));
				member.setPhone(resultSet.getString("phone"));
				member.setEmail(resultSet.getString("email"));
				member.setCertification(resultSet.getString("certification"));
				member.setImageName(resultSet.getString("imagename"));
				member.setInt_no(resultSet.getInt("int_no"));
				member.setInt_no2(resultSet.getInt("int_no2"));
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(resultSet, pStatement, connection);
		}
		
		return member;
	}
	
	public Member selectById(String id) {
	
		Member member= null;
		Connection connection = null;
		PreparedStatement pStatement= null;
		ResultSet resultSet= null;
		
		try {
			connection= JDBCUtil.getConnection();
			pStatement= connection.prepareStatement(Sql.MEMBER_SELECT_BY_ID_SQL);
			
			pStatement.setString(1, id); 
			
			resultSet= pStatement.executeQuery();
			if(resultSet.next()) {
				member= new Member();
				
				member.setUserno(resultSet.getInt("userno"));
				member.setId(resultSet.getString("id"));
				member.setPwd(resultSet.getString("pwd"));
				member.setName(resultSet.getString("name"));
				member.setGender(resultSet.getString("gender"));
				member.setPhone(resultSet.getString("phone"));
				member.setEmail(resultSet.getString("email"));
				member.setCertification(resultSet.getString("certification"));
				member.setImageName(resultSet.getString("imagename"));
				member.setInt_no(resultSet.getInt("int_no"));
				member.setInt_no2(resultSet.getInt("int_no2"));
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(resultSet, pStatement, connection);
		}
		
		return member;
	}
	
	@Override
	public int searchCount(String id) {
		
		int cnt = 0;
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs= null;
		
		try {
			conn = JDBCUtil.getConnection();
			ps = conn.prepareStatement(Sql.MEMBER_CNT_BY_ID);
			ps.setString(1, id);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				cnt = rs.getInt("cnt");
			}
			
		} catch (Exception e) {
			System.out.println("아이디 중복확인 실패");
		} finally {
			JDBCUtil.close(rs, ps, conn);
		}
		
		return cnt;
	}

	@Override
	public void update_certification(Member member) {
	
	
	}

	@Override
	public String selectByIDEmail(String id, String email) {
		String result = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn= JDBCUtil.getConnection();
			ps = conn.prepareStatement(Sql.MEMBER_SELECT_BY_ID_EMAIL);
			
			ps.setString(1, id); 
			ps.setString(2, email); 
			
			rs= ps.executeQuery();
			if(rs.next()) {
				//System.out.println(rs.getString("RESULTCNT"));
				if(Integer.parseInt(rs.getString("RESULTCNT")) == 1) {
					result = "Y";
				} else {
					//System.out.println("오류발생");
					result = "N";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs, ps, conn);
		}
		
		//System.out.println(result);
		
		return result;
	}

	@Override
	public void hashUpdate(String id, String hash) {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = JDBCUtil.getConnection();
			ps = conn.prepareStatement(Sql.MEMBER_HASH_UPDATE);
			
			ps.setString(1, hash);
			ps.setString(2, id);
			
			ps.executeUpdate();			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(null, ps, conn);
			System.out.println("성공적으로 해시가 등록되었습니다.");
		}
	}

	@Override
	public void hashDelete(String hash) {
		Connection conn = null;
		PreparedStatement ps = null;
		//System.out.println(hash);
		
		try {
			conn = JDBCUtil.getConnection();
			ps = conn.prepareStatement(Sql.MEMBER_DELETE_MEMBERHASH);
			
			ps.setString(1, hash);
			
			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("인증값이 유효하지 않습니다.");
		} finally {
			JDBCUtil.close(null, ps, conn);
			System.out.println("해시 삭제 완료");
		}
		
	}

	@Override
	public String hashSearch(String hash) {
		String result = null;
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn= JDBCUtil.getConnection();
			ps = conn.prepareStatement(Sql.MEMBER_SELECT_HASH);
			
			ps.setString(1, hash);
			
			rs= ps.executeQuery();
			if(rs.next()) {
				if(Integer.parseInt(rs.getString("COUNT")) == 1) {
					result = "Y";
				} else {
					result = "N";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs, ps, conn);
		}
		
		return result;
		
		
	}

	@Override
	public void updatePwd(String pwd, String hash) {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = JDBCUtil.getConnection();
			ps = conn.prepareStatement(Sql.MEMBER_PASSWORD_UPDATE);
			
			ps.setString(1, pwd);
			ps.setString(2, hash);
			
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			JDBCUtil.close(null, ps, conn);
			//System.out.println("변경 성공");
		}
		
	}

	@Override
	public String selectByNameEmail(String name, String email) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String id = null;
		
		try {
			conn = JDBCUtil.getConnection();
			ps = conn.prepareStatement(Sql.MEMBER_SELECT_BY_NAME_EMAIL_SQL);
			
			ps.setString(1,name);
			ps.setString(2,email);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				id = rs.getString("ID");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, ps, conn);
		}
		
		return id;
	}

	@Override
	public Member selectUser(String id, String pwd) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		Member member = null;
		
		try {
			conn = JDBCUtil.getConnection();
			ps = conn.prepareStatement(Sql.MEMBER_SELECT_BY_ID_PWD);
			
			ps.setString(1,id);
			ps.setString(2,pwd);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				member = new Member();
				member.setUserno(rs.getInt("USERNO"));
				member.setId(rs.getString("ID"));
				member.setName(rs.getString("NAME"));
				member.setEmail(rs.getString("EMAIL"));
				member.setImageName(rs.getString("IMAGENAME"));
				member.setCertification(rs.getString("CERTIFICATION"));
				System.out.println("로그인 계정 불러오기 성공");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("조회 실패");
		} finally {
			JDBCUtil.close(rs, ps, conn);
			
		}
		return member;
	}

	@Override
	public void insertCode(String email, String code) {
		
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = JDBCUtil.getConnection();
			ps = conn.prepareStatement(Sql.INSERT_CODE);
			
			ps.setString(1, email);
			ps.setString(2, code);
			
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(null, ps, conn);
		}

		
	}

	@Override
	public String searchCode(String code) {
		String result = null;
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			
			conn= JDBCUtil.getConnection();
			ps = conn.prepareStatement(Sql.SEARCH_CODE);
			
			ps.setString(1, code);
			
			rs= ps.executeQuery();
			
			if(rs.next()) {
				if(Integer.parseInt(rs.getString("COUNT")) == 1) {
					result = "Y";
				} else {
					result = "N";
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs, ps, conn);
		}
		
		return result;
		
	}

	@Override
	public void deleteCode(String code) {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = JDBCUtil.getConnection();
			ps = conn.prepareStatement(Sql.DELETE_CODE);
			
			ps.setString(1, code);
			
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(null, ps, conn);
		}
	}

	@Override
	public List<String> selectIdList(String name, String email) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		List<String> resultList = new ArrayList<>();
		
		
		try {
			conn = JDBCUtil.getConnection();
			ps = conn.prepareStatement(Sql.MEMBER_SELECT_BY_NAME_EMAIL_SQL);
			
			ps.setString(1, name);
			ps.setString(2, email);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				resultList.add(rs.getString("ID"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, ps, conn);
		}
		
		return resultList;
	}


}

