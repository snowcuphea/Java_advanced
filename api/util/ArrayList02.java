package api.util;

import java.util.ArrayList;
//collection에 저장할 요소의 타입을 generic 형태로 정의한다.
//collection클래스<데이터타입>;
// └> ArrayList<String>;

public class ArrayList02 {
	public static void main(String[] args) {
		//배열의 경우 : String[] arr = new String[5];
		ArrayList<String> list = new ArrayList<String>(); // < 담길데이터의타입 >//Person이런거 가능
		
		list.add("자바");
		list.add("오라클");
		list.add("JDBC");
		list.add("HTML5");
		list.add("CSS");
		for(int i = 0 ; i<list.size();i++) {
			System.out.println(list.get(i));
		}

	}

}
