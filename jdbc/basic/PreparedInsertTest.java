package jdbc.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
//step1 insert메소드 작성해서 코드 복사
//step2 main메소드에 insert메소드 호출
//step3 insert 메소드 내부에서 자원반납하도록 처리
//step4 외부에서 값을 입력받아 처리하도록 변경


public class PreparedInsertTest {
	public static void main(String[] args) {
		
		Scanner key = new Scanner(System.in);
		PreparedInsertTest obj = new PreparedInsertTest();
		System.out.println("********게시글 등록*******");
		
		System.out.println("아이디:");
		String id = key.next();
		System.out.println("제목:");
		String title = key.next();
		System.out.println("내용:");
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
		
		/*//변수랑 sql 문법 잘 써주기 
		String sql = "insert into tb_board values(board_seq.nextval,'"+
		id+"','" + title+"','"+content+"',sysdate,0)"; //보안 취약해서잘 안씀
	*/
		//동적SQL 외부에서 값을 받아온다. preparedStatement방식 (<->정적SQL은 다 써주는것statement방식)
		String sql = "insert into tb_board values(board_seq.nextval,?,?,?,sysdate,0)";
		//외부에서 받을 때 물음표 처리
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url,user,password);
			
			//1. PreparedStatement 생성
			stmt = con.prepareStatement(sql);
			
			///2. ?에 값 전달하기
			stmt.setString(1,id);
			stmt.setString(2, title);
			stmt.setString(3, content);
		
			//3. 실행하기
			int result = stmt.executeUpdate();
			
			System.out.println(result + "개 행 삽입성공");
			
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();// 오류추적
			System.out.println("연결 실패 : " + e.getMessage());
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

