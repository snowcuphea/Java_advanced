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
		System.out.println("********�Խñ� ����*******");
		PreparedDeleteTest obj = new PreparedDeleteTest();

		System.out.println("������ �� ��ȣ:");
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
			System.out.println("����̹��ε�����");
			con = DriverManager.getConnection(url, user, password);

			stmt = con.prepareStatement(sql);
			
			stmt.setString(1,boardnum);

			int result = stmt.executeUpdate();

			System.out.println(result + "�� �� ��������");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();

		} catch (SQLException e) {
			e.printStackTrace();// ��������
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
