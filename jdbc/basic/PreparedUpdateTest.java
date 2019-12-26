package jdbc.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

//2번 boardnum의 id를 kang으로 수정
public class PreparedUpdateTest {
	public static void main(String[] args) {
		
		Scanner key = new Scanner(System.in);
		System.out.println("*********게시글 수정********");
		
		PreparedUpdateTest obj = new PreparedUpdateTest();
		
		System.out.println("수정할 ID :");
		String id = key.next();
		System.out.println("번호:");
		int boardnum = key.nextInt();
		
		obj.update(id,boardnum);
		

	}
	public void update(String id, int boardnum) {
		
		String url = "jdbc:oracle:thin:@70.12.115.53:1521:xe";
		String user = "min";
		String password = "pw";
		Connection con = null;
		PreparedStatement stmt = null;
		StringBuffer sql = new StringBuffer();
		sql.append("update tb_board ");
		sql.append("set id = ? ");
		sql.append("where boardnum = ? ");

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
	
			con = DriverManager.getConnection(url,user,password);
			

			stmt = con.prepareStatement(sql.toString());
			
			stmt.setString(1,id);
			stmt.setInt(2,boardnum);
			
			int result = stmt.executeUpdate(); //위에서 sql 처리 해주니까 여기엔 sql쓸필요없다. 
			System.out.println(result + "개 행 수정성공");
			
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
			
		}catch(SQLException e) {
			e.printStackTrace();// 오류추적
			System.out.println("연결 실패 : " + e.getMessage());
		}finally {
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
