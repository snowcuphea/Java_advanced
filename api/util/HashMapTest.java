package api.util;

import java.util.HashMap;
import java.util.Set;

//HashMap의 사용방법
public class HashMapTest {

	public static void main(String[] args) {
		//1. key와 value를 한 쌍으로 저장
		// - Generic으로 데이터타입을명시할때도 key에 대한 타입,
		//	value에 대한 타입을 같이 정의
		HashMap<Integer, String> map = new HashMap<Integer,String>();
		//Get 메소드 : key를 주면 value가 리턴됨
		
		map.put(1, "servlet");
		map.put(1, "jsp");
		map.put(1, "Spring");
		System.out.println("map에 저장된 요소의 갯수=>" + map.size());
		System.out.println("key가1인 요소의value=> " + map.get(1));
		
		//map에 저장된 데이터를모두 출력하기
		//map은key를이용해서 저장될 위치를 계산하기 때문에 저장한 순서대로 출력되지 않는다.
		HashMap<String,String> map2 = new HashMap<String,String>();
		map2.put("abc_1", "servlet");
		map2.put("dfg_2", "jsp");
		map2.put("ddd_3", "spring");
		map2.put("asd_4", "tiles");
		map2.put("sss_5", "mybatis");
		
		//1. key목록을 추출한다.
		Set<String> keylist = map2.keySet();
		//2. 반복문 안에서 key를 이용해서 value를 추출한다.
		for (String key : keylist) {
			String value = map2.get(key);
			System.out.println(key+":"+value);
			
		}
	}
}
