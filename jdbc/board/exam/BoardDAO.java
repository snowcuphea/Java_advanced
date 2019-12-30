package jdbc.board.exam;

import java.util.ArrayList;

public interface BoardDAO {
	//public abstract�޼ҵ��ε� public abstract�� ���������ϴ�.
	int insert(BoardDTO board); //�Խñ۵�� //�÷� ���������ƴ� ��ü �ϳ��� �׼�������  - C
	int insert(String id, String title, String content); //�Խñ� ���
	int update(String id, int boardnum); //�Խñ� ���� - U
	int delete(int boardnum); //�Խñ� ���� - D
	ArrayList<BoardDTO> select();//��ü �Խñ� ��ȸ - L
	BoardDTO read(int boardnum);//�Խñ� ��ȸ (�ϳ� �б�)-R//�ϳ��� �д� �Ŵ� ���� ArrayList�� �ʿ� ����. 
	ArrayList<BoardDTO> findByTitle(String title); 
	//�Խñ� �˻� - Ư�� �˻��� �����ϴ� ������ ã�� ������ ���� ���� ���´�.
	//�����͸� where������ ���� �� ��Ȯ�� ��ġ�ϴ� �Ÿ� ������, Ư�� �ܾ ���� �� ����
	// pareparedStatement �Ҷ� ?�� �÷��� ������ ���� ��ü�� �� �ִ�.
	// ����ǥ�� ū����ǥ �̷��� ���� ���ϴ� ���� 

}
