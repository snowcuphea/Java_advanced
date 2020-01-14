package api.util;

import java.util.HashSet;
import java.util.Set;
//Set�� �ֿ����� ������ ������ ����� �����غ��� 
//: ������ ���� �ߺ��� ������� �ʾ� �����ϱ⿡ ���ϴ�. 
public class HashSetTest2 {

	public static void main(String[] args) {
		HashSet<String> set = new HashSet<String>();
		set.add("java");
		set.add("jdbc");
		set.add("oracle");
		set.add("html");
		set.add("css");
		set.add("java");
		//System.out.println("������->" + set.size());
		print(set,"set");
		
		
		//�������� �����ϴ¹���� => Set��ü�������� �� ���������� ǥ���� Set�� �������ǸŰ������� ����
		//set1�� set2�� ������
		HashSet<String> set2 = new HashSet<String>(set);
		set2.add("servlet");
		set2.add("jsp");
		set2.add("hadoop");
		set2.add("jquery");
		print(set2, "set2"); 
		
		HashSet<String> set3 = new HashSet<String>();
		set3.add("java");
		set3.add("oracle");
		set3.add("jdbc");
		set3.add("hive");
		print(set3,"set3");
		
		//set�� set3�� ������ ���ϱ�
		set.retainAll(set3); //set�� set3�� ����� ��� ��
							//�ߺ��Ǵ� ��Ҹ� ������ ���ο� set������ ���������.
							//set�� set3�� ���ؼ� ��ġ�ϴ� �͸� ����� �������� ���ŵȴ�. 
		print(set,"������");
		

	}
	
	//set�� ����� �����͸� ������ ����ϱ� 
	public static void print(Set<String> seti, String setName) { //�θ�Ÿ������ �޾Ƴ��� hashset���� �ٸ��ֵ鵵 ����
		System.out.println("������=>"+seti.size());
		for(String data : seti) {
			System.out.println(setName+"�� ����� ���=>" + data);
			
		}
		System.out.println("=============================================");
		
		
	}

}
