package jw.temp;

import java.io.UnsupportedEncodingException;

public class Test {


	public static void main(String[] args) {
		String str= "��";
		char x ='��';
		byte[] bytes=null;
		byte[] bytes1=null;
		try {
			bytes = str.getBytes("utf-16");
			bytes1 = charToByte(x);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("bytes ��С��"+bytes.length);
		System.out.println("bytes1��С��"+bytes1.length);
	}
	public static byte[] charToByte(char c) { 
        byte[] b = new byte[2]; 
        b[0] = (byte) ((c & 0xFF00) >> 8); 
        b[1] = (byte) (c & 0xFF); 
        return b; 
    }
}
