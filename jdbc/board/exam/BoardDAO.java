package jdbc.board.exam;
//DAO : Data access object

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//tb_board테이블을 액세스하는 기능이 정의된 클래스
public class BoardDAO {

	public void insert(String id, String title, String content) {
		
		Connection con = null;
		PreparedStatement stmt = null;

		
		String sql = "insert into tb_board values(board_seq.nextval,?,?,?,sysdate,0)";
	
		try {
			
			con = DBUtil.getConnect();

			// 1. PreparedStatement 생성
			stmt = con.prepareStatement(sql);

			/// 2. ?에 값 전달하기
			stmt.setString(1, id);
			stmt.setString(2, title);
			stmt.setString(3, content);

			// 3. 실행하기
			int result = stmt.executeUpdate();

			System.out.println(result + "개 행 삽입성공");

		} 
		 catch (SQLException e) {
			e.printStackTrace();// 오류추적
			System.out.println("연결 실패 : " + e.getMessage());
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (con != null)
					stmt.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public void update(String id, int boardnum) {

	
		Connection con = null;
		PreparedStatement stmt = null;
		StringBuffer sql = new StringBuffer();
		sql.append("update tb_board ");
		sql.append("set id = ? ");
		sql.append("where boardnum = ? ");

		try {
			

			con = DBUtil.getConnect();

			stmt = con.prepareStatement(sql.toString());

			stmt.setString(1, id);
			stmt.setInt(2, boardnum);

			int result = stmt.executeUpdate(); // 위에서 sql 처리 해주니까 여기엔 sql쓸필요없다.
			System.out.println(result + "개 행 수정성공");

		}  catch (SQLException e) {
			e.printStackTrace();// 오류추적
			System.out.println("연결 실패 : " + e.getMessage());
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (con != null)
					stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void delete(String boardnum) {

		
		Connection con = null;
		PreparedStatement stmt = null;

		String sql = "delete from tb_board where boardnum = ?";

		try {
			
			con = DBUtil.getConnect();

			stmt = con.prepareStatement(sql);
			
			stmt.setString(1,boardnum);

			int result = stmt.executeUpdate();

			System.out.println(result + "개 행 삭제성공");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (con != null)
					stmt.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}
	
	public void select() {
	
		String sql = "select * from tb_board";
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		try { // connection으로부터 statement로부터 resultset
	
			con = DBUtil.getConnect();

			stmt = con.createStatement();

			rs = stmt.executeQuery(sql);

			while (rs.next()) {

				System.out.print(rs.getString(1)+"\t");
				System.out.print(rs.getString(2)+"\t");
				System.out.print(rs.getString(3)+"\t");
				System.out.print(rs.getString(4)+"\t");
				System.out.print(rs.getDate(5)+"\t");
				System.out.print(rs.getInt(6)+"\t");
				System.out.println();

			}

		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { 

			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} 
			

		}
	}
	
	
}
