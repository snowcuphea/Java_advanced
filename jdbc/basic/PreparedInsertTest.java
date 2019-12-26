package jdbc.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
//step1 insert�޼ҵ� �ۼ��ؼ� �ڵ� ����
//step2 main�޼ҵ忡 insert�޼ҵ� ȣ��
//step3 insert �޼ҵ� ���ο��� �ڿ��ݳ��ϵ��� ó��
//step4 �ܺο��� ���� �Է¹޾� ó���ϵ��� ����


public class PreparedInsertTest {
	public static void main(String[] args) {
		
		Scanner key = new Scanner(System.in);
		PreparedInsertTest obj = new PreparedInsertTest();
		System.out.println("********�Խñ� ���*******");
		
		System.out.println("���̵�:");
		String id = key.next();
		System.out.println("����:");
		String title = key.next();
		System.out.println("����:");
		String content = key.next();
		
		System.out.println();
		
		obj.insert(id,title,content);
	}
	
	public void insert(String id, String title, String content) {
		String url = "jdbc:oracle:thin:@70.12.115.53:1521:xe";
		String user = "min";
		String password = "pw";
		Connection con = null;
		PreparedStatement stmt = null;
		
		/*//������ sql ���� �� ���ֱ� 
		String sql = "insert into tb_board values(board_seq.nextval,'"+
		id+"','" + title+"','"+content+"',sysdate,0)"; //���� ����ؼ��� �Ⱦ�
	*/
		//����SQL �ܺο��� ���� �޾ƿ´�. preparedStatement��� (<->����SQL�� �� ���ִ°�statement���)
		String sql = "insert into tb_board values(board_seq.nextval,?,?,?,sysdate,0)";
		//�ܺο��� ���� �� ����ǥ ó��
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url,user,password);
			
			//1. PreparedStatement ����
			stmt = con.prepareStatement(sql);
			
			///2. ?�� �� �����ϱ�
			stmt.setString(1,id);
			stmt.setString(2, title);
			stmt.setString(3, content);
		
			//3. �����ϱ�
			int result = stmt.executeUpdate();
			
			System.out.println(result + "�� �� ���Լ���");
			
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();// ��������
			System.out.println("���� ���� : " + e.getMessage());
		}finally {
			try {
				if(stmt!=null) stmt.close();
				if(con!=null) stmt.close();
				
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	
	
	
	}


}

