package jdbc.basic;
//JDBC : �ڹٷ� DB�����ϴ� ���
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
//Java�� �ϴ� ���� autocommit�̶� ������ ���� ���ص� �ݿ��� �ȴ�. 
public class ConnectionTest {
	
	
	
	public static void main(String[] args) {
		
		//��������-"jdbc:oracle:thin:@ip:port:�����ͺ��̽����񽺸�"
		// ��ű�Ģ�� ���س��� �� : ��������
		// 127.0.0.1 == ����ȣ��Ʈ == ���� �۾����� �� PC
		
		//���� ���ڿ� - � DBMS�� �����Ŀ� ���� ������ �޶�����. 
		//String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		//���ݿ� �ִ� ���� DB���� ip
		String url = "jdbc:oracle:thin:@70.12.115.53:1521:xe";
		String user = "min";		//���Ӱ���
		String password = "pw"; //���� �н�����
		String sql  = "insert into tb_board values(board_seq.nextval,'jang','����','����',sysdate,0)";
		try {
			//1.����Ŭ ����̹� �ε�
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("����̹��ε� ����!!");
			//2. DBMS�� �����ϱ� - ���������� ����
			//==> DBMS�� �����ϰ� ���������� ConnectionŸ������ ��ȯ�Ѵ�.
			Connection con = 
					DriverManager.getConnection(url, user, password);
			System.out.println("���Ἲ��:" + con);
			//��ü�� �Ҵ�� �ּ� ���� 
			//T4CConnection�� implements�ϰ��ִ�.
			
			//3.sql�� �����ϱ� ���� ��ü�� ���� - ���������� ������Ѿ� �ϹǷ� 
			//							connection��ü�� �̿��ؼ� ����
			Statement stmt = con.createStatement();
			System.out.println("SQL�� �����ϱ� ���� ��ü����: "+stmt);
			

			//4.sql �����ϱ�
			int result = stmt.executeUpdate(sql);
			System.out.println(result + "�� �� ���Լ���");
			
			
		}catch(ClassNotFoundException e) {
			System.out.println("����̹� �ε� ����");
		}catch(SQLException e) {
			System.out.println("�������:"+e.getMessage());
			
			
			
		}

	}

}
