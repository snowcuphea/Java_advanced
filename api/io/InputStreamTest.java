package api.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

//InputStream���̿��ؼ� Ű����� �Է¹޴� ���ڿ��� �б�
// - ScannerŬ������ next�޼ҵ��� ����� ����
public class InputStreamTest {
	public static void main(String[] args) {
		InputStream in = System.in;
		PrintStream out = System.out;
		
		while(true) {
			//1.��Ʈ���� �����͸� 1byte �б�
			try {
				int data = in.read();
				if(data==13) { //��Ʈ���� ���� ������ -1�̴�.
					//data==-1 �극��ũ �ϸ�, ���ͱ��� �νĵǾ 13, 10�̳��´�.
					//�׷��� data==13���� ���͸� ������ ����ش�.
					
					break;
				}
				out.println((char)data);
			}catch(IOException e) {
				e.printStackTrace();
			}
			
			
		}
		

	}

}
