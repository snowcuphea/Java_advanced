package jdbc.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//2�� boardnum�� id�� kang���� ����
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
			System.out.println("����̹��ε�����");
			Connection con = 
					DriverManager.getConnection(url,user,password);
			System.out.println("���Ἲ��"+con);
			
			Statement stmt = con.createStatement();
			
			int result = stmt.executeUpdate(sql);
			System.out.println(result + "�� �� ��������");
		}catch(ClassNotFoundException e) {
			System.out.println("�ε�����");
			
		}catch(SQLException e) {
			e.printStackTrace();// ��������
			System.out.println("���� ���� : " + e.getMessage());
		}

	}

}
