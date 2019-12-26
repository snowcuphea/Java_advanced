package jdbc.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

//2�� boardnum�� id�� kang���� ����
public class PreparedUpdateTest {
	public static void main(String[] args) {
		
		Scanner key = new Scanner(System.in);
		System.out.println("*********�Խñ� ����********");
		
		PreparedUpdateTest obj = new PreparedUpdateTest();
		
		System.out.println("������ ID :");
		String id = key.next();
		System.out.println("��ȣ:");
		int boardnum = key.nextInt();
		
		obj.update(id,boardnum);
		

	}
	public void update(String id, int boardnum) {
		
		String url = "jdbc:oracle:thin:@70.12.115.53:1521:xe";
		String user = "min";
		String password = "pw";
		Connection con = null;
		PreparedStatement stmt = null;
		String sql = "update tb_board set id =? where boardnum =?";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
	
			con = DriverManager.getConnection(url,user,password);
			
			
			stmt = con.prepareStatement(sql);
			
			stmt.setString(1,id);
			stmt.setInt(2,boardnum);
			
			int result = stmt.executeUpdate();
			System.out.println(result + "�� �� ��������");
			
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
			
		}catch(SQLException e) {
			e.printStackTrace();// ��������
			System.out.println("���� ���� : " + e.getMessage());
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
