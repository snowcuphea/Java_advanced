package api.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ScoreTest {

	public static void main(String[] args) {
		BufferedReader bf = null;
		try {
			bf = new BufferedReader(new FileReader("src/data/score.txt"));
			int sum = 0;
		
			while(true) {
				String data = bf.readLine();
				if(data==null) {
					break;
				}
				String arr[] = data.split(", ");
				System.out.println(arr[0]+"�� ������"+arr[1]+"��");
				
				sum = sum + Integer.parseInt(arr[1]);
			}
			System.out.println("����: " + sum);
			System.out.println("���: " + sum/3);
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(bf!=null) {
					bf.close();
				}
				
			}catch(IOException e) {
				e.printStackTrace();
			}
			
		}
		
	}

}
