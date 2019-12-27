package jdbc.customer.exam;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jdbc.board.exam.DBUtil;

public class CustomerDAOImpl implements CustomerDAO {
	
	public int insert(CustomerDTO customer) {
		System.out.println("dto���޼ҵ�:"+customer);
		Connection con = null;
		PreparedStatement stmt = null;

		String sql = "insert into customer values(?,?,?,sysdate,?,?)";
		int result = 0; 
		try {
			con = DBUtil.getConnect();
			stmt = con.prepareStatement(sql);
			stmt.setString(1, customer.getId());
			stmt.setString(2, customer.getPass());
			stmt.setString(3, customer.getName());
			stmt.setInt(4, customer.getPoint());
			stmt.setString(5, customer.getAddr());
			result = stmt.executeUpdate();
			System.out.println(result + "�� �� ���Լ���");
		} 
		 catch (SQLException e) {
			e.printStackTrace();
			System.out.println("���� ���� : " + e.getMessage());
		} finally {
			DBUtil.close(null,stmt,con); 
		}
		return result;
	}

	@Override
	public int update(String id, String addr) {
		Connection con = null;
		PreparedStatement stmt = null;
		int result = 0 ;
		String sql = "update customer set addr = ? where id = ? ";
		try {
			con = DBUtil.getConnect();
			stmt = con.prepareStatement(sql.toString());
			stmt.setString(1, addr);
			stmt.setString(2, id);
			result = stmt.executeUpdate();
			System.out.println(result + "�� �� ������Ʈ ����");
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(null, stmt, con);
		}
		return result;
	}

	
	@Override
	public int delete(String id) {
		Connection con = null;
		PreparedStatement stmt = null;
		String sql = "delete from customer where id = ?";
		int result = 0 ; //������� ������ ����
		try {
			con = DBUtil.getConnect();
			stmt = con.prepareStatement(sql);
			stmt.setString(1,id);
			result = stmt.executeUpdate();
			System.out.println(result + "�� �� ��������");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(null, stmt, con);
		}
		return result;
		
	}
	
	
	
}
