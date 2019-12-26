package jdbc.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PreparedSelectTest {
	public static void main(String[] args) {

		System.out.println("*********게시글********");
		PreparedSelectTest obj = new PreparedSelectTest();
		obj.select();

	}

	public void select() {
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user = "min";
		String password = "pw";
		String sql = "select * from tb_board";
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		try { // connection으로부터 statement로부터 resultset
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, user, password);

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

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
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
