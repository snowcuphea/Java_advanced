package api.util;

import java.util.HashSet;
import java.util.Set;
//Set의 주요기능인 합집합 교집합 기능을 구현해보기 
//: 순서가 없고 중복을 허용하지 않아 구현하기에 편하다. 
public class HashSetTest2 {

	public static void main(String[] args) {
		HashSet<String> set = new HashSet<String>();
		set.add("java");
		set.add("jdbc");
		set.add("oracle");
		set.add("html");
		set.add("css");
		set.add("java");
		//System.out.println("사이즈->" + set.size());
		print(set,"set");
		
		
		//합집합을 구현하는방법은 => Set객체를생성할 때 합집합으로 표현할 Set을 생성자의매개변수로 전달
		//set1과 set2의 합집합
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
		
		//set과 set3의 교집합 구하기
		set.retainAll(set3); //set과 set3에 저장된 요소 중
							//중복되는 요소만 가지고 새로운 set구조가 만들어진다.
							//set과 set3을 비교해서 일치하는 것만 남기고 나머지가 제거된다. 
		print(set,"교집합");
		

	}
	
	//set에 저장된 데이터를 꺼내서 출력하기 
	public static void print(Set<String> seti, String setName) { //부모타입으로 받아놔야 hashset말고 다른애들도 가능
		System.out.println("사이즈=>"+seti.size());
		for(String data : seti) {
			System.out.println(setName+"에 저장된 요소=>" + data);
			
		}
		System.out.println("=============================================");
		
		
	}

}
