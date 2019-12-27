package api.util;
//동시처리,트랜젝션 중요. 동시처리 벡터 (배열은 처음에 사이즈를 정해줘야하고, 벡터는 그 점을 보완할 수 있다.)
//벡터는 사이즈를 안주고 들어간다. 안주고 들어가면 첨엔 기본으로 10개 준다. 10->20->40->80->160
import java.util.Vector;
//vector는  api. api는 메소드 콜로 접근
//Vector를 만들고 사용하는 방법
public class VectorTest01 {

	public static void main(String[] args) {
		Vector<Integer> v = new Vector<Integer>();// <> : 데이터타입을 제네릭이라고함
		//벡터에 인트데이터 담는다. 
		//v.add("java"); //
		v.add(100);
		System.out.println("Vector의 용량:" + v.capacity());//총사이즈
		System.out.println("Vectord에 저장된 요소의 갯수: " +v.size());//들어간 데이터의 개수
		System.out.println("===============================================");
		for (int i = 1;i<11;i++) {
			v.add(i);
		}
		System.out.println("Vector의 용량:" + v.capacity());//총사이즈
		System.out.println("Vectord에 저장된 요소의 갯수: " +v.size());//들어간 데이터의 개수
		
		System.out.println("===============================================");
		for (int i = 1;i<81;i++) {
			v.add(i);
		}
		System.out.println("Vector의 용량:" + v.capacity());//총사이즈
		System.out.println("Vectord에 저장된 요소의 갯수: " +v.size());//들어간 데이터의 개수

}
}
