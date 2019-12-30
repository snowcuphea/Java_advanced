package jdbc.member.exam;
import java.util.ArrayList;
import java.util.Scanner;

import jdbc.board.exam.BoardDTO;

public class MenuUI {
	Scanner key = new Scanner(System.in);
	
	MemberDAO dao = new MemberDAOImpl();
	
	public void insertMenu(){
		//�Ի����� ���ó�¥ - sysdate, point = 1000�� ���Եǵ��� 
		System.out.println("*******������********");
		System.out.print("���̵�:");
		String id = key.next();
		System.out.print("�н�����:");
		String pass = key.next();
		System.out.print("����:");
		String name = key.next();
		System.out.print("�ּ�:");
		String addr = key.next();
		System.out.print("�μ���ȣ:");
		String deptno = key.next();
		
		
		//���⿡�� MemberDAO�� �޼ҵ带 ȣ���ϼ���
		MemberDTO member = new MemberDTO(id,pass,name,addr,deptno);
		int result = dao.insert(member);
		
	}
	public void updateMenu(){
		System.out.println("*******�������********");
		System.out.print("���̵�:");
		String id = key.next();
		System.out.print("�ּ�:");
		String addr = key.next();
		//���⿡�� EmpDAO�� �޼ҵ带 ȣ���ϼ���
		int result = dao.update(id,addr);
		if(result > 0) {
			System.out.println("���� ���� ����");
		}else {
			System.out.println("��������");
		}
	}
	public void deleteMenu(){
		System.out.println("*******�������********");
		System.out.print("���̵�:");
		String id = key.next();
		//���⿡�� EmpDAO�� �޼ҵ带 ȣ���ϼ���
		int result = dao.delete(id);
		if(result > 0) {
			System.out.println("���� ���� ����");
		}else {
			System.out.println("���� ����");
		}
	}
	
	public void memberListMenu(){
		System.out.println("*******�����ȸ********");
		//���⿡�� EmpDAO�� �޼ҵ带 ȣ���ϼ��� - ��ü�����ȸ
		ArrayList<MemberDTO> memberli = dao.memberList();
		int size = memberli.size();
		for(int i=0;i<size;i++) {
			MemberDTO member = memberli.get(i);
			System.out.println(member.getId()+"\t"+member.getPass()+"\t"+member.getName()
			+ member.getAddr() + "\t" + member.getDeptno());
		}
	}
	
	public void findByAddrMenu(){
		System.out.println("*******����˻�********");
		System.out.print("�ּ�:");
		//���⿡�� EmpDAO�� �޼ҵ带 ȣ���ϼ���
		String addr = key.next();
		ArrayList<MemberDTO> addrlist = dao.findByAddr(addr);
		if(addr == null) {
			System.out.println("��ġ�ϴ� �����Ͱ� �����ϴ�.");	
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
		System.out.println("*********�α���ȭ��*******");
		System.out.print("ID: ");
		String id = key.next();
		System.out.println("Password: ");
		String pass = key.next();
		MemberDTO log = dao.login(id, pass);
		if(log == null) {
			System.out.println("id, pw ��ġ�ϴ� ������ �����ϴ�.");
		}else {
			System.out.println("�α��μ���");
			System.out.println(log.getId()+"\t"+log.getPass()+"\t"+log.getName()
			+ log.getAddr() + "\t" + log.getDeptno());
		}
		
	}
}


















