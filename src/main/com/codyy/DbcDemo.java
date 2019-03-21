package main.com.codyy;

public class DbcDemo {

	public static void main(String[] args) {
		String str = "半角ABC123,，";
		String str2 = "全角ＡＢＣ，，";
		
//		System.out.println("半角"+str.length());
//		System.out.println("全角"+str2.length());
		
		char[] chars = str.toCharArray();
		char[] chars2 = str2.toCharArray();
//		byte[] bytes = str.getBytes();
//		byte[] bytes2 = str2.getBytes();
		
		for(int i = 0; i<chars.length; i++){
			System.out.println((int)chars[i]);
//			System.out.println("==="+str.charAt(i));
//			if (chars[i] >= 32 && chars[i] <= 127) {  
//	            System.out.println("---"+chars[i]);  
//	        } 
		}
		
		System.out.println("==============");
		
		for(int i = 0; i<chars2.length; i++){
			System.out.println((int)chars2[i]);
//			System.out.println("==="+str2.charAt(i));
//			if (chars2[i] >= 32 && chars2[i] <= 127) {  
//	            System.out.println("---"+chars2[i]);  
//	        } 
		}
		
//		System.out.println("==============");
//		
//		for(int i = 0; i<bytes.length; i++){
//			System.out.println(bytes[i]);
//		}
//		
//		System.out.println("==============");
//		
//		for(int i = 0; i<bytes2.length; i++){
//			System.out.println(bytes2[i]);
//		}
	}

}
