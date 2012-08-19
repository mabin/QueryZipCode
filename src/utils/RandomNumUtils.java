package utils;

import java.text.DecimalFormat;
import java.util.Random;

public class RandomNumUtils { 
	
	public static int getInt(int min, int max){

		Random random = new Random();
		int result ;
		while ( (result = random.nextInt(max)) < min){}
		return result ;
	}
	
	public static float getFloat(int min, int max){
		
		String strNum = String.valueOf(max);
		int length = strNum.trim().length();
		Random random = new Random();
		double result ;
		while ( (result = random.nextGaussian()*((int)Math.pow(100, length))) <min || result >max){};
		
		DecimalFormat ft = new DecimalFormat("#.00");
		
		return Float.valueOf(ft.format(result));
	}
} 