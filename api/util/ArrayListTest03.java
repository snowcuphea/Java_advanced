package api.util;

import java.util.ArrayList;

public class ArrayListTest03 {

	public static void main(String[] args) {
		String[] arr = {"java", "oracle", "jdbc", "html5", "css","java"};
		ArrayList<String> list = changeData(arr);
		
		//ArrayList API문서 보면 size()메소드 있다.
//		for(int i = 0; i<list.size();i++) { 
//			System.out.println(list.get(i));
//		}
		for(String arar : list) {
			System.out.println("요소:" + arar);
		}
		System.out.println("=======================");
		int size = list.size(); //맨 위의 방법으로 호출하면 for문을 돌릴때마다 heap에서 size()호출한다.
		// 따라서 이런 경우에는 리소스를 적게 쓰기위해,size()메소드를 호출한 값을 변수에 저장해서 사용하는 것이 좋다.
		
		for(int i = 0; i<size ; i++) {
			System.out.println("요소: " + list.get(i));
		}
		
		
		
	}
	
	//배열을 ArrayList로 변환해서 리턴하는 메소드
	//ArrayList를 리턴타입으로 쓸 수 있다.
	public static ArrayList<String> changeData(String[] arr){ //매개변수로 배열 전달
		ArrayList<String> lili = new ArrayList<String>();
		//ArrayList도 데이터타입 명시할 수 잇는 곳에 다 올 수 있다.
		for (int i = 0; i<arr.length;i++) {
			lili.add(arr[i]);
		}
		return lili;
	}

}
