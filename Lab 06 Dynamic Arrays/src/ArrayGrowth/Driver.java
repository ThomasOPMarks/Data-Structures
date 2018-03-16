package ArrayGrowth;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class Driver {
	
	public static void main(String args[]) throws FileNotFoundException{
		PrintWriter file = new PrintWriter (new FileOutputStream("LabData.csv"));
		file.println("n, Time (in ms)");
		
		for(int n = 1000000; n < 65000000; n *= 2){
			
			DynamicArray<Integer> array = new DynamicArray<>();
			long start = System.currentTimeMillis();
			//This is an O(n^2), because we have an n by another n (during worst case);
			for(int i = 0; i < n; i++){//This is an n operation
				array.add(i);//This is a constant operation, unless it has to expand which makes it an n operation 
			}
			long end = System.currentTimeMillis();
			
			file.println("" + n +", " + (end - start));
			System.out.println("" + n +", " + (end - start));
			
			
		}
		
		file.close();
	}

}
