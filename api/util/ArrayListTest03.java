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
	
	//�迭�� ArrayList�� ��ȯ�ؼ� �����ϴ� �޼ҵ�
	//ArrayList�� ����Ÿ������ �� �� �ִ�.
	public static ArrayList<String> changeData(String[] arr){
		ArrayList<String> lili = new ArrayList<String>();
		
		for (int i = 0; i<arr.length;i++) {
			lili.add(arr[i]);
		}
		return lili;
	}

}
