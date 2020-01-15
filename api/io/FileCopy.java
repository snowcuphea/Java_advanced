package api.io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileCopy {

	public static void main(String[] args)  {
		//FileTest01.java���� copy�ϱ�
		//1. FileReader�� �а� FileWriter�� ����ϱ�
		//2. src/data/copy_result.txt�� �����ϱ�
		//3. �ַܼε� ��µǵ��� �ۼ� 
		FileReader filerd = null;
		
		FileWriter filewr = null;
		try {
			filerd = new FileReader("src/api/io/FileTest01.java");
			filewr = new FileWriter("src/data/copy_result.txt",true);
			while(true){
				int data = filerd.read();
				filewr.write(data);
				if(data == -1) {
					break;
				}
				System.out.print((char)data);		
			}
			
		}catch(FileNotFoundException e){
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			
			try {
				if(filerd!=null) {
					filerd.close();
					filewr.close();
				}
				
			}catch(IOException e) {
				e.printStackTrace();
			}
			
		}
		

		
		

	}

}
