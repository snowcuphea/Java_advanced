package api.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

//���ڴ����� �о ����input�ϱ� 
public class FileReaderTest {

	public static void main(String[] args) {
		FileReader fr = null;
		try {
			//1. ���Ͽ����ϱ�
			fr = new FileReader("src/api/io/FileTest01.java"); 
			//2. ���� �׼���
			int count=0; //����Ƚ��
			long start = System.nanoTime();//���۽ð� ����

			while(true) {
				int data = fr.read();
				if (data==-1) {
					break;
				}
				count++;
				System.out.print((char)data);
			}
			long end = System.nanoTime();//���۽ð� ����
			System.out.println("����Ƚ��=>"+count);
			System.out.println("����ð�=>"+(end-start));
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			try {
				//3. ���ϴݱ�
				if(fr!=null) {
					fr.close(); //null�϶��� close�޼ҵ� ȣ���� �� �����ϱ�.
				}
			}catch(IOException e) {
				e.printStackTrace();
			}
			
		}

	}

}
