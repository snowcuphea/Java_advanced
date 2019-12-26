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
		
		
		try { //connection으로부터 statement로부터 resultset
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, user, password);
			//만약 con에서 오류가 생기면, stmt랑 rs는 만들어지지 않은 상태이므로
			//밑에 자원반납 finally 쪽에서 if(stmt!=null) stmt.close(); 이런식으로써준다.
			
			stmt = con.createStatement();
			//select문을 실행
			rs =  stmt.executeQuery(sql);
		//	System.out.println("rs:"+rs);
			//ResultSet에 레코드가 존재하는 동안 반복문을 실행
			while(rs.next()) {//=> 레코드를 조회하기 위해서는 
				              //   레코드가 한 개라도 반드시 커서를 이동시켜야한다.
				System.out.print(rs.getString(1)+"\t");
				//getString(1) 에서 1은 id컬럼
				System.out.print(rs.getString(2)+"\t");
				//getString(2)에서 2는 title컬럼
				System.out.print(rs.getString(3)+"\t");
				System.out.println(rs.getString("content")+"\t"); //직접 컬럼명 작성 가능
				//System.out.print(rs.getDate(5)+"\t");
				//System.out.println(rs.getInt(6));

			}
			
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally { //exception이 발생하지 않거나 발생하거나 무조건 실행할 명령문을 정의
			
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






