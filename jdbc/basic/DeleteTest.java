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
		//sql ��ü�� �ʹ� ���̻����ϸ� �δ��� �� �� �����Ƿ�,
		//������ �ǵ帮�� StringBuffer ��밡��
		StringBuffer sql = new StringBuffer();
		sql.append("delete tb_board ");
		sql.append("where boardnum=5");

		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("����̹��ε�����");
			Connection con = 
					DriverManager.getConnection(url,user,password);
			System.out.println("���Ἲ��"+con);
			
			Statement stmt = con.createStatement();
			int result = stmt.executeUpdate(sql.toString());
			System.out.println(result + "�� �� ��������");
		}catch(ClassNotFoundException e) {
			System.out.println("�ε�����");
			
		}catch(SQLException e) {
			e.printStackTrace();// ��������
			System.out.println("���� ���� : " + e.getMessage());
		}
		

	}

}
