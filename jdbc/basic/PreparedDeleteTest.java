package jdbc.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class PreparedDeleteTest {
	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		System.out.println("********게시글 삭제*******");
		PreparedDeleteTest obj = new PreparedDeleteTest();

		System.out.println("삭제할 글 번호:");
		String boardnum = key.next();

		obj.delete(boardnum);

	}

	public void delete(String boardnum) {

		String url = "jdbc:oracle:thin:@70.12.115.53:1521:xe";
		String user = "min";
		String password = "pw";
		Connection con = null;
		PreparedStatement stmt = null;

		String sql = "delete from tb_board where boardnum = ?";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버로딩성공");
			con = DriverManager.getConnection(url, user, password);

			stmt = con.prepareStatement(sql);
			
			stmt.setString(1,boardnum);

			int result = stmt.executeUpdate();

			System.out.println(result + "개 행 삭제성공");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();

		} catch (SQLException e) {
			e.printStackTrace();// 오류추적
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

}
