package api.util;
//����ó��,Ʈ������ �߿�. ����ó�� ���� (�迭�� ó���� ����� ��������ϰ�, ���ʹ� �� ���� ������ �� �ִ�.)
//���ʹ� ����� ���ְ� ����. ���ְ� ���� ÷�� �⺻���� 10�� �ش�. 10->20->40->80->160
import java.util.Vector;
//vector��  api. api�� �޼ҵ� �ݷ� ����
//Vector�� ����� ����ϴ� ���
public class VectorTest01 {

	public static void main(String[] args) {
		Vector<Integer> v = new Vector<Integer>();// <> : ������Ÿ���� ���׸��̶����
		//���Ϳ� ��Ʈ������ ��´�. 
		//v.add("java"); //
		v.add(100);
		System.out.println("Vector�� �뷮:" + v.capacity());//�ѻ�����
		System.out.println("Vectord�� ����� ����� ����: " +v.size());//�� �������� ����
		System.out.println("===============================================");
		for (int i = 1;i<11;i++) {
			v.add(i);
		}
		System.out.println("Vector�� �뷮:" + v.capacity());//�ѻ�����
		System.out.println("Vectord�� ����� ����� ����: " +v.size());//�� �������� ����
		
		System.out.println("===============================================");
		for (int i = 1;i<81;i++) {
			v.add(i);
		}
		System.out.println("Vector�� �뷮:" + v.capacity());//�ѻ�����
		System.out.println("Vectord�� ����� ����� ����: " +v.size());//�� �������� ����

}
}
