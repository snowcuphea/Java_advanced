package jdbc.board.exam;

import java.util.Scanner;

import jdbc.basic.PreparedInsertTest;

public class BoardDAOTest {
	public static void main(String[] args) {
		
			
			Scanner key = new Scanner(System.in);
			BoardDAO dao = new BoardDAO();
			System.out.println("********�Խñ� ���*******");
			
			System.out.println("���̵�:");
			String id = key.next();
			System.out.println("����:");
			String title = key.next();
			System.out.println("����:");
			String content = key.next();
			
			System.out.println();
			
			dao.insert(id,title,content);
			dao.select();
		
		
		

	}

}
