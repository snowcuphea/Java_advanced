package api.util;

import java.util.ArrayList;

public class ArrayListTest03 {

	public static void main(String[] args) {
		String[] arr = {"java", "oracle", "jdbc", "html5", "css"};
		ArrayList<String> list = changeData(arr);
		
		for(int i = 0; i<list.size();i++) {
			System.out.println(list.get(i));
		}
	}
	
	//배열을 ArrayList로 변환해서 리턴하는 메소드
	//ArrayList를 리턴타입으로 쓸 수 있다.
	public static ArrayList<String> changeData(String[] arr){
		ArrayList<String> lili = new ArrayList<String>();
		
		for (int i = 0; i<arr.length;i++) {
			lili.add(arr[i]);
		}
		return lili;
	}

}
