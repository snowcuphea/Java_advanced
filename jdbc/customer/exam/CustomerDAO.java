package jdbc.customer.exam;

public interface CustomerDAO {
	int insert(CustomerDTO user);
	int update(String id, String addr);
	int delete(String id);

}
