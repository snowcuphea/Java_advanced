package api.util;

import java.util.ArrayList;

public class ArrayListTest03 {

	public static void main(String[] args) {
		String[] arr = {"java", "oracle", "jdbc", "html5", "css","java"};
		ArrayList<String> list = changeData(arr);
		
		//ArrayList API���� ���� size()�޼ҵ� �ִ�.
//		for(int i = 0; i<list.size();i++) { 
//			System.out.println(list.get(i));
//		}
		for(String arar : list) {
			System.out.println("���:" + arar);
		}
		System.out.println("=======================");
		int size = list.size(); //�� ���� ������� ȣ���ϸ� for���� ���������� heap���� size()ȣ���Ѵ�.
		// ���� �̷� ��쿡�� ���ҽ��� ���� ��������,size()�޼ҵ带 ȣ���� ���� ������ �����ؼ� ����ϴ� ���� ����.
		
		for(int i = 0; i<size ; i++) {
			System.out.println("���: " + list.get(i));
		}
		
		
		
	}
	
	//�迭�� ArrayList�� ��ȯ�ؼ� �����ϴ� �޼ҵ�
	//ArrayList�� ����Ÿ������ �� �� �ִ�.
	public static ArrayList<String> changeData(String[] arr){ //�Ű������� �迭 ����
		ArrayList<String> lili = new ArrayList<String>();
		//ArrayList�� ������Ÿ�� ����� �� �մ� ���� �� �� �� �ִ�.
		for (int i = 0; i<arr.length;i++) {
			lili.add(arr[i]);
		}
		return lili;
	}

}
