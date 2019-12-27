package jdbc.member.exam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
	static {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로딩 성공");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();

		}
	}

	public static Connection getConnect() {
		// 커넥션만 만들어주는 메소드
		// 객체마다 다른 값을 받는 게 아니고, 연결하는 것이므로 static으로 설정한다.
		Connection con = null;
		String url = "jdbc:oracle:thin:@70.12.115.53:1521:xe";
		String user = "min";
		String password = "pw";

		try {
			con = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	
	public static void close(ResultSet rs, Statement stmt, 
			Connection con) {

		try {
			if (rs != null) rs.close();
			if (stmt != null) stmt.close();
			if (con != null) con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
	}

}
