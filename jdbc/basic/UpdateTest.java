package jdbc.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//2번 boardnum의 id를 kang으로 수정
public class UpdateTest {
	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@70.12.115.53:1521:xe";
		String user = "min";
		String password = "pw";
		String sql = "delete tb_board";
		sql = sql + "set id = 'kang' ";
		sql = sql + "wehre boardnum = 2";

		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버로딩성공");
			Connection con = 
					DriverManager.getConnection(url,user,password);
			System.out.println("연결성공"+con);
			
			Statement stmt = con.createStatement();
			
			int result = stmt.executeUpdate(sql);
			System.out.println(result + "개 행 수정성공");
		}catch(ClassNotFoundException e) {
			System.out.println("로딩실패");
			
		}catch(SQLException e) {
			e.printStackTrace();// 오류추적
			System.out.println("연결 실패 : " + e.getMessage());
		}

	}

}
