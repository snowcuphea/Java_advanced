package jdbc.customer.exam;
import java.util.Scanner;

public class MenuUI {
	Scanner key = new Scanner(System.in);
	
	CustomerDAO dao = new CustomerDAOImpl();
	
	public void insertMenu(){
		
		System.out.println("*******������********");
		System.out.print("���̵�:");
		String id = key.next();
		System.out.print("�н�����:");
		String pass = key.next();
		System.out.print("����:");
		String name = key.next();
		System.out.print("����Ʈ:");
		int point = key.nextInt();
		System.out.print("�ּ�:");
		String addr = key.next();
	
		
		CustomerDTO customer = new CustomerDTO(id,pass,name,point,addr);
		int result = dao.insert(customer);
		
	}
	public void updateMenu(){
		
		System.out.println("*******ȸ�� ����********");
		System.out.print("���̵�:");
		String id = key.next();
		System.out.print("�ּ�:");
		String addr = key.next();
	
		int result = dao.update(id,addr);
		if(result > 0) {
			System.out.println("�ּ� ���� ����");
		}else {
			System.out.println("���� ����");
		}
	}
	
	public void deleteMenu(){
		System.out.println("*******ȸ�� ����********");
		System.out.print("���̵�:");
		String id = key.next();
		int result = dao.delete(id);
		if(result > 0) {
			System.out.println("���� ���� ����");
		}else {
			System.out.println("���� ����");
		}
	}
	
}


















