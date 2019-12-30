package jdbc.member.exam;
import java.util.ArrayList;
import java.util.Scanner;

import jdbc.board.exam.BoardDTO;

public class MenuUI {
	Scanner key = new Scanner(System.in);
	
	MemberDAO dao = new MemberDAOImpl();
	
	public void insertMenu(){
		//입사일은 오늘날짜 - sysdate, point = 1000가 삽입되도록 
		System.out.println("*******사원등록********");
		System.out.print("아이디:");
		String id = key.next();
		System.out.print("패스워드:");
		String pass = key.next();
		System.out.print("성명:");
		String name = key.next();
		System.out.print("주소:");
		String addr = key.next();
		System.out.print("부서번호:");
		String deptno = key.next();
		
		
		//여기에서 MemberDAO의 메소드를 호출하세요
		MemberDTO member = new MemberDTO(id,pass,name,addr,deptno);
		int result = dao.insert(member);
		
	}
	public void updateMenu(){
		System.out.println("*******사원수정********");
		System.out.print("아이디:");
		String id = key.next();
		System.out.print("주소:");
		String addr = key.next();
		//여기에서 EmpDAO의 메소드를 호출하세요
		int result = dao.update(id,addr);
		if(result > 0) {
			System.out.println("계정 수정 성공");
		}else {
			System.out.println("수정실패");
		}
	}
	public void deleteMenu(){
		System.out.println("*******사원삭제********");
		System.out.print("아이디:");
		String id = key.next();
		//여기에서 EmpDAO의 메소드를 호출하세요
		int result = dao.delete(id);
		if(result > 0) {
			System.out.println("계정 삭제 성공");
		}else {
			System.out.println("삭제 실패");
		}
	}
	
	public void memberListMenu(){
		System.out.println("*******사원조회********");
		//여기에서 EmpDAO의 메소드를 호출하세요 - 전체사원조회
		ArrayList<MemberDTO> memberli = dao.memberList();
		int size = memberli.size();
		for(int i=0;i<size;i++) {
			MemberDTO member = memberli.get(i);
			System.out.println(member.getId()+"\t"+member.getPass()+"\t"+member.getName()
			+ member.getAddr() + "\t" + member.getDeptno());
		}
	}
	
	public void findByAddrMenu(){
		System.out.println("*******사원검색********");
		System.out.print("주소:");
		//여기에서 EmpDAO의 메소드를 호출하세요
		String addr = key.next();
		ArrayList<MemberDTO> addrlist = dao.findByAddr(addr);
		if(addr == null) {
			System.out.println("일치하는 데이터가 없습니다.");	
		}else {
			int size = addrlist.size();
			for(int i = 0; i<size;i++) {
				MemberDTO member = addrlist.get(i);
				System.out.println(member.getId()+"\t"+member.getPass()+"\t"+member.getName()
				+"\t"+ member.getAddr() + "\t" + member.getDeptno());
			}
		}
	}
	
	
	
	public void loginMenu() {
		System.out.println("*********로그인화면*******");
		System.out.print("ID: ");
		String id = key.next();
		System.out.println("Password: ");
		String pass = key.next();
		MemberDTO log = dao.login(id, pass);
		if(log == null) {
			System.out.println("id, pw 일치하는 정보가 없습니다.");
		}else {
			System.out.println("로그인성공");
			System.out.println(log.getId()+"\t"+log.getPass()+"\t"+log.getName()
			+ log.getAddr() + "\t" + log.getDeptno());
		}
		
	}
}


















