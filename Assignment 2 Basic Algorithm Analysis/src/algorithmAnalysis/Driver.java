package algorithmAnalysis;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;
//This code looks at three algorithms empirically for run time
//of finding if a positive and a negative of same magnitude are 
//in the array

//Driver
public class Driver {
	public static void main (String args[]) throws Exception{
		//Makes the random array, and prints what case it is
		Random r = new Random();
		int random;
		System.out.println("Random Case");
		for(int n = 50000; n < 800001; n += 50000){
			int[] a = new int[n];
			for (int j = 0; j < a.length; j++){
				random = r.nextInt(10) - 5;
				a[j] = random;
				if(random == 0){
					j--;
				}
			}
			//Sorts array
			Arrays.sort(a);
			//Times all three algorithms, and outputs the time
			long startBS = System.nanoTime();
			Algoithms.binarySearch(a);
			long endBS = System.nanoTime();
			
			long startS = System.currentTimeMillis();
			Algoithms.sequential(a);
			long endS = System.currentTimeMillis();
			
			long startTI = System.nanoTime();
			Algoithms.twoIndex(a);
			long endTI = System.nanoTime();
			
			System.out.println(n+ ", " + ((endBS - startBS)/1000000.0) + ", " + (endS - startS) + ", " + ((endTI - startTI))/1000000.0);
			
			
		}
		//Thought it was required to do the worst case, but it wasn't but it's ok because here we are
		//Makes the worst case of not finding the value for comparison
		System.out.println("Worst case");
		
		for(int n = 50000; n < 800001; n += 50000){
			int[] a = new int[n];
			for (int j = 0; j < a.length; j++){
				
				a[j] = 1;
				
			}
			
			//Times the algorithms in the worst cases 
			long startBS = System.nanoTime();
			Algoithms.binarySearch(a);
			long endBS = System.nanoTime();
			
			long startS = System.currentTimeMillis();
			Algoithms.sequential(a);
			long endS = System.currentTimeMillis();
			
			long startTI = System.nanoTime();
			Algoithms.twoIndex(a);
			long endTI = System.nanoTime();
			
			System.out.println(n+ ", " + ((endBS - startBS)/1000000.0) + ", " + (endS - startS) + ", " + ((endTI - startTI))/1000000.0);
			
			
		}
		
	}
}
