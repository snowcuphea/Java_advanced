package jdbc.board.exam;

//DAO : Data access object
//DB�� ���õ� �۾��� DAO������ �ϵ·� ���. �����Ͱ��� �۾��� ������ ���⼭ ������Ѵ�. 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

//tb_board���̺��� �׼����ϴ� ����� ���ǵ� Ŭ����
public class BoardDAOImpl implements BoardDAO {

	public int insert(BoardDTO board) {
		// ���� �ѱ�� �κп��� sysout����Ͽ� Ȯ���غ���.
		System.out.println("dto���޼ҵ�:" + board);
		Connection con = null;
		PreparedStatement stmt = null;

		String sql = "insert into tb_board values(board_seq.nextval,?,?,?,sysdate,0)";
		int result = 0; // �޼ҵ��� �������� ����� ����
		try {
			con = DBUtil.getConnect();

			// 1. PreparedStatement ����
			stmt = con.prepareStatement(sql);

			/// 2. ?�� �� �����ϱ�
			stmt.setString(1, board.getId());
			stmt.setString(2, board.getTitle());
			stmt.setString(3, board.getContent());

			// 3. �����ϱ� : ���� ������ �߻��Ѵٸ�, try�� ������ ������ catch�� ����
			// result = 0�� ������ �� �ִ�.
			result = stmt.executeUpdate();

			System.out.println(result + "�� �� ���Լ���");

		} catch (SQLException e) {
			e.printStackTrace();// ��������
			System.out.println("���� ���� : " + e.getMessage());
		} finally {
			DBUtil.close(null, stmt, con); // rs�� �����ϱ�
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
		int result = 0; // ���� ����� ������ ����
		try {
			con = DBUtil.getConnect();
			stmt = con.prepareStatement(sql.toString());
			stmt.setString(1, id);
			stmt.setInt(2, boardNum);
			result = stmt.executeUpdate(); // ������ sql ó�� ���ִϱ� ���⿣ sql���ʿ����.
			System.out.println(result + "�� �� ��������");

		} catch (SQLException e) {
			e.printStackTrace();// ��������
			System.out.println("���� ���� : " + e.getMessage());
		} finally {
			DBUtil.close(null, stmt, con);
		}
		return result;
	}

	public int delete(int boardnum) {

		Connection con = null;
		PreparedStatement stmt = null;
		String sql = "delete from tb_board where boardnum = ?";
		int result = 0; // ������� ������ ����

		try {
			con = DBUtil.getConnect();
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, boardnum);
			result = stmt.executeUpdate();
			System.out.println(result + "�� �� ��������");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(null, stmt, con);
		}
		return result;
	}

	public int insert(String id, String title, String content) {
		// ���� �ѱ�� �κп��� sysout����Ͽ� Ȯ���غ���.
		Connection con = null;
		PreparedStatement stmt = null;

		String sql = "insert into tb_board values(board_seq.nextval,?,?,?,sysdate,0)";
		int result = 0; // �޼ҵ��� �������� ����� ����
		try {
			con = DBUtil.getConnect();

			// 1. PreparedStatement ����
			stmt = con.prepareStatement(sql);

			/// 2. ?�� �� �����ϱ�
			stmt.setString(1, id);
			stmt.setString(2, title);
			stmt.setString(3, content);

			// 3. �����ϱ� : ���� ������ �߻��Ѵٸ�, try�� ������ ������ catch�� ����
			// result = 0�� ������ �� �ִ�.
			result = stmt.executeUpdate();
			System.out.println(result + "�� �� ���Լ���");
		} catch (SQLException e) {
			e.printStackTrace();// ��������
			System.out.println("���� ���� : " + e.getMessage());
		} finally {
			DBUtil.close(null, stmt, con); // rs�� �����ϱ�
		}
		return result;
	}

	public ArrayList<BoardDTO> select() {

		// ��ü �Խñ��� ���� Collection
		ArrayList<BoardDTO> boardlist = new ArrayList<BoardDTO>();

		// ��ȸ�� �Խñ��� ���� ��ü. ������ while������ ���� ��� �޶����� ������ Ÿ�Ը� ����ϰ� �� ���ش�.
		// ��ü�� �������� �ʰ� null�� �ʱ�ȭ�ϴ� ����
		// -> ������ ��ȸ�ϴ� �۾� �ϴ� ���� while�� �����̹Ƿ�
		// while������ ��ȸ�� ���ڵ�� ��ü�� ����
		BoardDTO board = null;
		String sql = "select * from tb_board";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try { // connection���κ��� statement�κ��� resultset
			con = DBUtil.getConnect();
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) { // �����Ͱ� �޶����� �κ�. rs.next()�ߴµ� ���� ������ ���̵Ǿ� ����
				// ���ڵ� ���� ������ false�Ǿ� while�� Ż��
				// 1. ��ȸ�� ���ڵ��� �÷��� �о DTO�� ��ȯ�ϴ� �۾�
				board = new BoardDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5),
						rs.getInt(6));

				// 2. DTO�� ��ȯ�� ���ڵ带 ArrayList�� �߰��ϴ� �۾�
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
			
			while (rs.next()) { //���ó�� 
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
