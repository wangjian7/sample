package jw.temp;

public class Hel {
	public static void main(String[] args){
		String str = "���hello";
        	int byte_len = str.getBytes().length;
        	int len = str.length();
        	System.out.println("�ֽڳ���Ϊ��" + byte_len);
		System.out.println("�ַ�����Ϊ��" + len);
		System.out.println("ϵͳĬ�ϱ��뷽ʽ��" + System.getProperty("file.encoding"));
       }
}
