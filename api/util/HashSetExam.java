package api.util;

import java.util.HashSet;
import java.util.Set;

public class HashSetExam {

	public static void main(String[] args) {
		//다음과 같은 변수명으로 HashSet객체 2개 작성하기
		//set1 -> 1부터 10까지의 정수
		//set2 -> 5부터 15까지의 정수
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
	
		//set1과 set2의 합집합
		print(setsum,"합집합");
		
		//set1과 set2의 교집합
		set1.retainAll(set2);
		
		print(set1,"교집합");
	
		}
	
	
	public static void print(Set<Integer> seti, String setName) { //부모타입으로 받아놔야 hashset말고 다른애들도 가능
		System.out.println("사이즈=>"+seti.size());
		for(Integer data : seti) {
			System.out.println(setName+"에 저장된 요소=>" + data);
			
		}
		
		
		System.out.println("=============================================");
		
		
	}

}
