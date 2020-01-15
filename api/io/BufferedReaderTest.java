package api.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
//BufferedReader로 한 문장씩 읽기

public class BufferedReaderTest {

	public static void main(String[] args) {
		//FileReader fr = null;
		BufferedReader br = null;
		try {
			//1. 파일오픈하기
			//fr = new FileReader("src/data/test.txt"); //기본스트림
			//br = new BufferedReader(fr); //보조스트림 - 기본스트림과 연결하는 작업
			//bufferedReader는 ㅂ조스트림으로 원시데이터와 연결할 수 없으므로
			//원시데이터를 읽을 수 있는 기본스트림을 생성해서 넘겨주어야 한다. 
			br = new BufferedReader(new FileReader("src/api/io/FileTest01.java"));//보통 이렇게 한번에 적어준다.
			//2. 파일 액세스
			int count=0; //실행횟수
			long start = System.nanoTime();//시작시간 측정
			while(true) {
				String data = br.readLine();
				if (data==null) { //string이니까
					break;
				}
				count++;
				System.out.println(data);
			}
			long end = System.nanoTime();//시작시간 측정
			System.out.println("실행횟수=>"+count);
			System.out.println("실행시간=>"+(end-start));
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(br!=null) {
					br.close(); 
				}
			}catch(IOException e) {
				e.printStackTrace();
			}			
		}
	}
}
