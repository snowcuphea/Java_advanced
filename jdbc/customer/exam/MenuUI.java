package jdbc.customer.exam;
import java.util.Scanner;

public class MenuUI {
	Scanner key = new Scanner(System.in);
	
	CustomerDAO dao = new CustomerDAOImpl();
	
	public void insertMenu(){
		
		System.out.println("*******사원등록********");
		System.out.print("아이디:");
		String id = key.next();
		System.out.print("패스워드:");
		String pass = key.next();
		System.out.print("성명:");
		String name = key.next();
		System.out.print("포인트:");
		int point = key.nextInt();
		System.out.print("주소:");
		String addr = key.next();
	
		
		CustomerDTO customer = new CustomerDTO(id,pass,name,point,addr);
		int result = dao.insert(customer);
		
	}
	public void updateMenu(){
		
		System.out.println("*******회원 수정********");
		System.out.print("아이디:");
		String id = key.next();
		System.out.print("주소:");
		String addr = key.next();
	
		int result = dao.update(id,addr);
		if(result > 0) {
			System.out.println("주소 수정 성공");
		}else {
			System.out.println("수정 실패");
		}
	}
	
	public void deleteMenu(){
		System.out.println("*******회원 삭제********");
		System.out.print("아이디:");
		String id = key.next();
		int result = dao.delete(id);
		if(result > 0) {
			System.out.println("계정 삭제 성공");
		}else {
			System.out.println("삭제 실패");
		}
	}
	
}


















