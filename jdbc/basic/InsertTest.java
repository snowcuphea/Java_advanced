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
		String sql = "insert into tb_board values(board_seq.nextval,'kim2','�ι�°','second',sysdate,0)";
	
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("����̹��ε� ����!");
			
			Connection concon =
					DriverManager.getConnection(url,user,password);
			System.out.println("���Ἲ��:" + concon);
			
			Statement stt = concon.createStatement();
			
			stt.executeUpdate(sql);
			System.out.println("���Լ���");
			
			
			
		}catch(ClassNotFoundException e){
			System.out.println("����̹� �ε�����");
			
		}catch(SQLException e) {
			e.printStackTrace();// ��������
			System.out.println("���� ���� : " + e.getMessage());
		}
		

	}

}

