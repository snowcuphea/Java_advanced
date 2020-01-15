package api.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
//BufferedReader�� �� ���徿 �б�

public class BufferedReaderTest {

	public static void main(String[] args) {
		//FileReader fr = null;
		BufferedReader br = null;
		try {
			//1. ���Ͽ����ϱ�
			//fr = new FileReader("src/data/test.txt"); //�⺻��Ʈ��
			//br = new BufferedReader(fr); //������Ʈ�� - �⺻��Ʈ���� �����ϴ� �۾�
			//bufferedReader�� ������Ʈ������ ���õ����Ϳ� ������ �� �����Ƿ�
			//���õ����͸� ���� �� �ִ� �⺻��Ʈ���� �����ؼ� �Ѱ��־�� �Ѵ�. 
			br = new BufferedReader(new FileReader("src/api/io/FileTest01.java"));//���� �̷��� �ѹ��� �����ش�.
			//2. ���� �׼���
			int count=0; //����Ƚ��
			long start = System.nanoTime();//���۽ð� ����
			while(true) {
				String data = br.readLine();
				if (data==null) { //string�̴ϱ�
					break;
				}
				count++;
				System.out.println(data);
			}
			long end = System.nanoTime();//���۽ð� ����
			System.out.println("����Ƚ��=>"+count);
			System.out.println("����ð�=>"+(end-start));
			
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
