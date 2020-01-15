package api.io;

import java.io.File;
import java.text.SimpleDateFormat;

//������ ���θ�Ž��
public class FileTest02 {

	public static void main(String[] args) {
		//c:\iot\iotest������ ���� ���� �� ������ ���
		//[�������]
		//a ----- [����]
		//b -----[����]
		//ArrayTest01.java -----[����  :(������ ������ ���)]
		
		
		//������ ������ ��¥�� �� �� ���� �������� ���
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy�� MM�� dd��");
		
		File filee = new File("c:/iot/iotest");
		File[] filelist = filee.listFiles();
		for(int i=0;i<filelist.length;i++) {
			if(filelist[i].isDirectory()) {
				System.out.println(filelist[i].getName()+
						"---------------[����]");
				
			}else {
				System.out.println(filelist[i].getName()+
						"---------------[����:("+
						filelist[i].length()+")]" +
						sdf.format(filelist[i].lastModified()));
			}
			
		}

	}

}