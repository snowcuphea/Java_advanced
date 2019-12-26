package jdbc.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertTest {
	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@70.12.115.53:1521:xe";
		String user = "min";
		String password = "pw";
		String sql = "insert into tb_board values(board_seq.nextval,'kim2','두번째','second',sysdate,0)";
	
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버로딩 성공!");
			
			Connection concon =
					DriverManager.getConnection(url,user,password);
			System.out.println("연결성공:" + concon);
			
			Statement stt = concon.createStatement();
			
			stt.executeUpdate(sql);
			System.out.println("삽입성공");
			
			
			
		}catch(ClassNotFoundException e){
			System.out.println("드라이버 로딩실패");
			
		}catch(SQLException e) {
			e.printStackTrace();// 오류추적
			System.out.println("연결 실패 : " + e.getMessage());
		}
		

	}

}

