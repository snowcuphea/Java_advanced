package jdbc.board.exam;

public interface BoardDAO {
	//public abstract�޼ҵ��ε� public abstract�� ���������ϴ�.
	int insert(BoardDTO board); //�÷� ���������ƴ� ��ü �ϳ��� �׼������� 
	int insert(String id, String title, String content);
	int update(String id, int boardnum);
	int delete(int boardnum);
	void select();

}
