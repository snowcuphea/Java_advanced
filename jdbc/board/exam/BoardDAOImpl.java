package jdbc.board.exam;

//DAO : Data access object
//DB에 관련된 작업은 DAO에서만 하돠록 약속. 데이터관련 작업은 무조건 여기서 해줘야한다. 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

//tb_board테이블을 액세스하는 기능이 정의된 클래스
public class BoardDAOImpl implements BoardDAO {

	public int insert(BoardDTO board) {
		// 값을 넘기는 부분에서 sysout출력하여 확인해보자.
		System.out.println("dto사용메소드:" + board);
		Connection con = null;
		PreparedStatement stmt = null;

		String sql = "insert into tb_board values(board_seq.nextval,?,?,?,sysdate,0)";
		int result = 0; // 메소드의 실행결과가 저장될 변수
		try {
			con = DBUtil.getConnect();

			// 1. PreparedStatement 생성
			stmt = con.prepareStatement(sql);

			/// 2. ?에 값 전달하기
			stmt.setString(1, board.getId());
			stmt.setString(2, board.getTitle());
			stmt.setString(3, board.getContent());

			// 3. 실행하기 : 만약 오류가 발생한다면, try문 끝까지 못가고 catch로 가서
			// result = 0이 유지될 수 있다.
			result = stmt.executeUpdate();

			System.out.println(result + "개 행 삽입성공");

		} catch (SQLException e) {
			e.printStackTrace();// 오류추적
			System.out.println("연결 실패 : " + e.getMessage());
		} finally {
			DBUtil.close(null, stmt, con); // rs는 없으니까
		}
		return result;

	}

	public int update(String id, int boardNum) {

		Connection con = null;
		PreparedStatement stmt = null;
		StringBuffer sql = new StringBuffer();
		sql.append("update tb_board ");
		sql.append("set id = ? ");
		sql.append("where boardnum = ? ");
		int result = 0; // 수정 결과를 저장할 변수
		try {
			con = DBUtil.getConnect();
			stmt = con.prepareStatement(sql.toString());
			stmt.setString(1, id);
			stmt.setInt(2, boardNum);
			result = stmt.executeUpdate(); // 위에서 sql 처리 해주니까 여기엔 sql쓸필요없다.
			System.out.println(result + "개 행 수정성공");

		} catch (SQLException e) {
			e.printStackTrace();// 오류추적
			System.out.println("연결 실패 : " + e.getMessage());
		} finally {
			DBUtil.close(null, stmt, con);
		}
		return result;
	}

	public int delete(int boardnum) {

		Connection con = null;
		PreparedStatement stmt = null;
		String sql = "delete from tb_board where boardnum = ?";
		int result = 0; // 결과값을 저장할 변수

		try {
			con = DBUtil.getConnect();
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, boardnum);
			result = stmt.executeUpdate();
			System.out.println(result + "개 행 삭제성공");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(null, stmt, con);
		}
		return result;
	}

	public int insert(String id, String title, String content) {
		// 값을 넘기는 부분에서 sysout출력하여 확인해보자.
		Connection con = null;
		PreparedStatement stmt = null;

		String sql = "insert into tb_board values(board_seq.nextval,?,?,?,sysdate,0)";
		int result = 0; // 메소드의 실행결과가 저장될 변수
		try {
			con = DBUtil.getConnect();

			// 1. PreparedStatement 생성
			stmt = con.prepareStatement(sql);

			/// 2. ?에 값 전달하기
			stmt.setString(1, id);
			stmt.setString(2, title);
			stmt.setString(3, content);

			// 3. 실행하기 : 만약 오류가 발생한다면, try문 끝까지 못가고 catch로 가서
			// result = 0이 유지될 수 있다.
			result = stmt.executeUpdate();
			System.out.println(result + "개 행 삽입성공");
		} catch (SQLException e) {
			e.printStackTrace();// 오류추적
			System.out.println("연결 실패 : " + e.getMessage());
		} finally {
			DBUtil.close(null, stmt, con); // rs는 없으니까
		}
		return result;
	}

	public ArrayList<BoardDTO> select() {

		// 전체 게시글을 담을 Collection
		ArrayList<BoardDTO> boardlist = new ArrayList<BoardDTO>();

		// 조회한 게시글을 담을 객체. 어차피 while문에서 값이 계속 달라지기 때문에 타입만 명시하고 값 안준다.
		// 객체를 생성하지 않고 null로 초기화하는 이유
		// -> 데이터 조회하는 작업 하는 곳이 while문 내부이므로
		// while문에서 조회된 레코드로 객체를 생성
		BoardDTO board = null;
		String sql = "select * from tb_board";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try { // connection으로부터 statement로부터 resultset
			con = DBUtil.getConnect();
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) { // 데이터가 달라지는 부분. rs.next()했는데 값이 있으면 참이되어 진행
				// 레코드 값이 없으면 false되어 while문 탈출
				// 1. 조회한 레코드의 컬럼을 읽어서 DTO로 변환하는 작업
				board = new BoardDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5),
						rs.getInt(6));

				// 2. DTO로 변환된 레코드를 ArrayList에 추가하는 작업
				boardlist.add(board);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, stmt, con);
		}
		return boardlist;
	}

	@Override
	public BoardDTO read(int boardnum) {
		

		String sql = "select * from tb_board where boardnum = ? ";
		BoardDTO board = null;
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = DBUtil.getConnect();
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, boardnum);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				board = new BoardDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5),
						rs.getInt(6));
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(null, stmt, con);
		}

		return board;
	}

	@Override
	public ArrayList<BoardDTO> findByTitle(String title) {
		
		ArrayList<BoardDTO> boardlist = new ArrayList<BoardDTO>();
		
		String sql = "select * from tb_board where title like ? ";

		BoardDTO board = null;
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = DBUtil.getConnect();
			stmt = con.prepareStatement(sql);
			stmt.setString(1, "%" + title + "%");
			rs = stmt.executeQuery();
			
			while (rs.next()) { //결과처리 
				board = new BoardDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5),
					rs.getInt(6));
				boardlist.add(board);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, stmt, con);
		}

		return boardlist;
	}

}
