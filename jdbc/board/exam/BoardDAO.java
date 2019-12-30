package jdbc.board.exam;

import java.util.ArrayList;

public interface BoardDAO {
	//public abstract메소드인데 public abstract은 생략가능하다.
	int insert(BoardDTO board); //게시글등록 //컬럼 여러개가아닌 객체 하나에 액세스가능  - C
	int insert(String id, String title, String content); //게시글 등록
	int update(String id, int boardnum); //게시글 수정 - U
	int delete(int boardnum); //게시글 삭제 - D
	ArrayList<BoardDTO> select();//전체 게시글 조회 - L
	BoardDTO read(int boardnum);//게시글 조회 (하나 읽기)-R//하나를 읽는 거니 굳이 ArrayList쓸 필요 없다. 
	ArrayList<BoardDTO> findByTitle(String title); 
	//게시글 검색 - 특정 검색어 포함하는 제목을 찾기 때문에 여러 글이 나온다.
	//데이터를 where절에서 비교할 때 정확히 일치하는 거를 비교할지, 특정 단어가 들어가는 지 유의
	// pareparedStatement 할때 ?는 컬럼엔 못쓰고 값만 대체할 수 있다.
	// 물음표랑 큰따옴표 이런거 연결 못하니 유의 

}
