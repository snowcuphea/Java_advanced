package jdbc.member.exam;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jdbc.board.exam.DBUtil;

public class MemberDAOImpl implements MemberDAO {
	
	public int insert(MemberDTO member) {
		System.out.println("dto사용메소드:"+member);
		Connection con = null;
		PreparedStatement stmt = null;

		String sql = "insert into member values(?,?,?,?,?,sysdate,1000)";
		int result = 0; 
		try {
			con = DBUtil.getConnect();
			stmt = con.prepareStatement(sql);
			stmt.setString(1, member.getId());
			stmt.setString(2, member.getPass());
			stmt.setString(3, member.getName());
			stmt.setString(4, member.getAddr());
			stmt.setString(5, member.getDeptno());
			result = stmt.executeUpdate();
			System.out.println(result + "개 행 삽입성공");
		} 
		 catch (SQLException e) {
			e.printStackTrace();
			System.out.println("연결 실패 : " + e.getMessage());
		} finally {
			DBUtil.close(null,stmt,con); 
		}
		return result;
	}

	@Override
	public int update(String id, String addr) {
		Connection con = null;
		PreparedStatement stmt = null;
		int result = 0 ;
		String sql = "update member set addr = ? where id = ? ";
		try {
			con = DBUtil.getConnect();
			stmt = con.prepareStatement(sql.toString());
			stmt.setString(1, addr);
			stmt.setString(2, id);
			result = stmt.executeUpdate();
			System.out.println(result + "개 행 업데이트 성공");
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(null, stmt, con);
		}
		return result;
	}

	
	@Override
	public int delete(String id) {
		Connection con = null;
		PreparedStatement stmt = null;
		String sql = "delete from member where id = ?";
		int result = 0 ; //결과값을 저장할 변수
		try {
			con = DBUtil.getConnect();
			stmt = con.prepareStatement(sql);
			stmt.setString(1,id);
			result = stmt.executeUpdate();
			System.out.println(result + "개 행 삭제성공");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(null, stmt, con);
		}
		return result;
		
	}
	
	
	
}
