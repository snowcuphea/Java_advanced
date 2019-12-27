package api.util;

import java.util.ArrayList;

public class ArrayTestExam01 { //79, 55, 100, 98, 99¸¦ ArrayList¿¡ ´ã°í, ÃÑÁ¡°ú Æò±ÕÀ» Ãâ·ÂÇÏ½Ã¿À.	
	public static void main(String[] args) {
		ArrayList<Integer> lili = new ArrayList<Integer>();
		int sum = 0;
		int avg = 0;
		lili.add(79);
		lili.add(55);
		lili.add(100);
		lili.add(98);
		lili.add(99);
		for (int i = 0 ; i<lili.size();i++) {
			sum = sum + lili.get(i);
		}
		avg  = sum / lili.size();
		
		System.out.println("ÃÑÁ¡: "+sum);
		System.out.println("Æò±Õ: "+ avg);
	}
}
