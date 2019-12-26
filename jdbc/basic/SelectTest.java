package jdbc.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectTest {
	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user = "min";
		String password = "pw";
		String sql = "select id,title,content from tb_board";
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		
		try { //connection���κ��� statement�κ��� resultset
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, user, password);
			//���� con���� ������ �����, stmt�� rs�� ��������� ���� �����̹Ƿ�
			//�ؿ� �ڿ��ݳ� finally �ʿ��� if(stmt!=null) stmt.close(); �̷������ν��ش�.
			
			stmt = con.createStatement();
			//select���� ����
			rs =  stmt.executeQuery(sql);
		//	System.out.println("rs:"+rs);
			//ResultSet�� ���ڵ尡 �����ϴ� ���� �ݺ����� ����
			while(rs.next()) {//=> ���ڵ带 ��ȸ�ϱ� ���ؼ��� 
				              //   ���ڵ尡 �� ���� �ݵ�� Ŀ���� �̵����Ѿ��Ѵ�.
				System.out.print(rs.getString(1)+"\t");
				//getString(1) ���� 1�� id�÷�
				System.out.print(rs.getString(2)+"\t");
				//getString(2)���� 2�� title�÷�
				System.out.print(rs.getString(3)+"\t");
				System.out.println(rs.getString("content")+"\t"); //���� �÷��� �ۼ� ����
				//System.out.print(rs.getDate(5)+"\t");
				//System.out.println(rs.getInt(6));

			}
			
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally { //exception�� �߻����� �ʰų� �߻��ϰų� ������ ������ ��ɹ��� ����
			
			try {
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				if(con!=null) con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
			
		}
		
	}
}






