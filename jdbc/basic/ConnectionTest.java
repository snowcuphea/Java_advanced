package jdbc.basic;
//JDBC : 자바로 DB연동하는 기술
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
//Java로 하는 것은 autocommit이라 저장을 따로 안해도 반영이 된다. 
public class ConnectionTest {
	
	
	
	public static void main(String[] args) {
		
		//프로토콜-"jdbc:oracle:thin:@ip:port:데이터베이스서비스명"
		// 통신규칙을 정해놓은 것 : 프로토콜
		// 127.0.0.1 == 로컬호스트 == 현재 작업중인 내 PC
		
		//연결 문자열 - 어떤 DBMS를 쓰느냐에 따라 형식이 달라진다. 
		//String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		//원격에 있는 실제 DB서버 ip
		String url = "jdbc:oracle:thin:@70.12.115.53:1521:xe";
		String user = "min";		//접속계정
		String password = "pw"; //접속 패스워드
		String sql  = "insert into tb_board values(board_seq.nextval,'jang','연습','연습',sysdate,0)";
		try {
			//1.오라클 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버로딩 성공!!");
			//2. DBMS에 연결하기 - 연결정보를 정의
			//==> DBMS에 연결하고 연결정보를 Connection타입으로 반환한다.
			Connection con = 
					DriverManager.getConnection(url, user, password);
			System.out.println("연결성공:" + con);
			//객체가 할당된 주소 나옴 
			//T4CConnection가 implements하고있다.
			
			//3.sql을 실행하기 위한 객체를 생성 - 연결정보와 연결시켜야 하므로 
			//							connection객체를 이용해서 생성
			Statement stmt = con.createStatement();
			System.out.println("SQL을 실행하기 위한 객체정보: "+stmt);
			

			//4.sql 실행하기
			int result = stmt.executeUpdate(sql);
			System.out.println(result + "개 행 삽입성공");
			
			
		}catch(ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
		}catch(SQLException e) {
			System.out.println("연결실패:"+e.getMessage());
			
			
			
		}

	}

}
