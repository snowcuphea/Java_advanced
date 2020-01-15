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
				System.out.println(arr[0]+"ÀÇ Á¡¼ö´Â"+arr[1]+"Á¡");
				
				sum = sum + Integer.parseInt(arr[1]);
			}
			System.out.println("ÃÑÁ¡: " + sum);
			System.out.println("Æò±Õ: " + sum/3);
			
			
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
