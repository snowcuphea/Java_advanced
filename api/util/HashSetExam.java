package api.util;

import java.util.HashSet;
import java.util.Set;

public class HashSetExam {

	public static void main(String[] args) {
		//������ ���� ���������� HashSet��ü 2�� �ۼ��ϱ�
		//set1 -> 1���� 10������ ����
		//set2 -> 5���� 15������ ����
		HashSet<Integer> set1 = new HashSet<Integer>();
		for (int i = 1; i<11;i++) {
			set1.add(i);
		}
		HashSet<Integer> set2 = new HashSet<Integer>();
		for (int i = 5; i<16;i++) {
			set2.add(i);
		}
		
		HashSet<Integer> setsum = new HashSet<Integer>(set1);
		for (int i = 5; i<16;i++) {
			setsum.add(i);
		}
	
		//set1�� set2�� ������
		print(setsum,"������");
		
		//set1�� set2�� ������
		set1.retainAll(set2);
		
		print(set1,"������");
	
		}
	
	
	public static void print(Set<Integer> seti, String setName) { //�θ�Ÿ������ �޾Ƴ��� hashset���� �ٸ��ֵ鵵 ����
		System.out.println("������=>"+seti.size());
		for(Integer data : seti) {
			System.out.println(setName+"�� ����� ���=>" + data);
			
		}
		
		
		System.out.println("=============================================");
		
		
	}

}
