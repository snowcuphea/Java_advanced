package jdbc.board.exam;

public interface BoardDAO {
	//public abstract메소드인데 public abstract은 생략가능하다.
	int insert(BoardDTO board); //컬럼 여러개가아닌 객체 하나에 액세스가능 
	int insert(String id, String title, String content);
	int update(String id, int boardnum);
	int delete(int boardnum);
	void select();

}
