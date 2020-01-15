package api.io;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

//InputStream을이용해서 키보드로 입력받는 문자열을 읽기
// - Scanner클래스의 next메소드의 기능을 구현
public class InputStreamReaderTest {
	public static void main(String[] args) {
		InputStreamReader in = new InputStreamReader(System.in);
		//InputStreamReader in = System.in;//오류나는 이유.
		//타입이 다르다. 왼쪽은 inputStreamReader타입, 오른쪽은 inputstream타입
		PrintStream out = System.out;
		
		while(true) {
			//1.스트림의 데이터를 1byte 읽기
			try {
				int data = in.read();
				if(data==13) { //스트림의 끝을 만나면 -1이다.
					//data==-1 브레이크 하면, 엔터까지 인식되어서 13, 10이나온다.
					//그래서 data==13으로 엔터를 끝으로 잡아준다.
					
					break;
				}
				out.print((char)data);
			}catch(IOException e) {
				e.printStackTrace();
			}
			//open access close
			//모두 생성자에서 알아서 처리된다. 
			
			
		}
		

	}

}
