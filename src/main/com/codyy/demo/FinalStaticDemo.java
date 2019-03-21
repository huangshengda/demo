package main.com.codyy.demo;

import java.math.BigDecimal;

public class FinalStaticDemo {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		System.out.println(Const.RAND_CONST);
		
		int i = 0;
		
		System.out.println(i++);
		
		i=i++;
		System.out.println(i);
		
		
		int fee = 200;
		saveDefault:save(fee);
		
		
		System.out.println(remainder(-1,2));
		
		
		System.out.println(10.0-9.6);
		
		BigDecimal bigD = new BigDecimal(10.0);
		BigDecimal bigD2 = new BigDecimal(9.6);
		
		System.out.println(bigD.subtract(bigD2).floatValue());
	}

	
	public static void saveDefault(){
		
	}
	
	public static void save(int fee){
		
	}
	
	public static int remainder(int dividend,int divisor){
		return dividend - dividend / divisor * divisor;
	}
}
