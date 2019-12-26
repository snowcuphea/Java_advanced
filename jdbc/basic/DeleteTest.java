package jdbc.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteTest {
	public static void main(String[] args) {
		
		String url = "jdbc:oracle:thin:@70.12.115.53:1521:xe";
		String user = "min";
		String password = "pw";
		//sql 객체를 너무 많이생성하면 부담이 될 수 있으므로,
		//원본을 건드리는 StringBuffer 사용가능
		StringBuffer sql = new StringBuffer();
		sql.append("delete tb_board ");
		sql.append("where boardnum=5");

		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버로딩성공");
			Connection con = 
					DriverManager.getConnection(url,user,password);
			System.out.println("연결성공"+con);
			
			Statement stmt = con.createStatement();
			int result = stmt.executeUpdate(sql.toString());
			System.out.println(result + "개 행 삭제성공");
		}catch(ClassNotFoundException e) {
			System.out.println("로딩실패");
			
		}catch(SQLException e) {
			e.printStackTrace();// 오류추적
			System.out.println("연결 실패 : " + e.getMessage());
		}
		

	}

}
