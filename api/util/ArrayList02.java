package api.util;

import java.util.ArrayList;
//collection�� ������ ����� Ÿ���� generic ���·� �����Ѵ�.
//collectionŬ����<������Ÿ��>;
// ��> ArrayList<String>;

public class ArrayList02 {
	public static void main(String[] args) {
		//�迭�� ��� : String[] arr = new String[5];
		ArrayList<String> list = new ArrayList<String>(); // < ��浥������Ÿ�� >//Person�̷��� ����
		
		list.add("�ڹ�");
		list.add("����Ŭ");
		list.add("JDBC");
		list.add("HTML5");
		list.add("CSS");
		for(int i = 0 ; i<list.size();i++) {
			System.out.println(list.get(i));
		}

	}

}
