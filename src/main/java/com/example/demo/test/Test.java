package com.example.demo.test;

public class Test {

	public static void main(String[] args) {

		int i, count, result = 0;
		 
	    for (i = 2; i <= 2000000; i++) {
	    	/*
	    	if(i > 2 && i%2==0) {
	    		continue;
	    	}
	    	if(i > 3 && i%3==0) {
	    		continue;
	    	}
	    	if(i > 5 && i%5==0) {
	    		continue;
	    	}
	    	if(i > 7 && i%7==0) {
	    		continue;
	    	}
	    	
	    	*/
	    	
	        count = 0;
	        for (int j = 1; j <= i; j++)
	            if (i%j == 0)
	                count++;
	        if (count == 2)
	            result += i;
	        System.out.println("i : " + i);
	    }
	    
	    System.out.println("result : " + result);
/*
		int sumSosu = 0;

		for(int i=2; i<=100; i++) {
		
			boolean isSosu = true;
			
			for(int y=2; y<i; y++) {
				if(i%y==0) {
					isSosu = false;
					break;
				}
			}
			
			if(isSosu) {
				sumSosu += i;
				System.out.println("i2 : " + i);
				}
			}
		
		//142913828922
		//1179908154
		System.out.println("sumSosu : " + sumSosu);
	*/		
		}
		
	
	
	
		
		//
		
		 
		

}
