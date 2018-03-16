package GroupPartition;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
	static int powerOfTwo = 1073741824;
	public static void main(String args[]) throws IOException{
		//Make the two ADT's Are made
		UnionFind<String> total = new UnionFind<>();
		ArrayListOfHashSets<String> total2 = new ArrayListOfHashSets<>();
		System.out.println("The Union Find Method:");
		//Here sort the sample input
		GroupPartition<String> filled =  createGroup(total, "sampleInput.txt");
		System.out.println("The Arraylist of Hashsets Method: ");
		GroupPartition<String> filled2 =  createGroup(total2, "sampleInput.txt");
		//Here we make the worst case, write it to a file, and then read it like before.
		PrintWriter numbers = new PrintWriter(new FileWriter (("WorstCaseFile.txt")));
		int starting = 2;
		while (starting < 32769){ // 2^15
			numbers = new PrintWriter(new FileWriter (("WorstCaseFile.txt")));
			numbers.println(starting);
			for(int i = 0; i < starting; i++){
				numbers.println(i);;
			}
			for(int i = 1; i < starting; i*=2){
				for(int j = 0; j < starting; j+= 2*i){
					numbers.println("" + j+", "+ (j+i));
				}
			}
			numbers.close();
			
			total = new UnionFind<>();
			total2 = new ArrayListOfHashSets<>();
			System.out.println("The Union Find with " + starting + " elements");
			GroupPartition<String> filled3 =  createGroup(total, "WorstCaseFile.txt");
			System.out.println("The ArrayListOfHashSets " + starting + " elements");
			GroupPartition<String> filled4 =  createGroup(total2, "WorstCaseFile.txt");
			starting *= 2;
		}
		
		
	}
	
	public static GroupPartition<String> createGroup(GroupPartition<String> o, String filename) throws FileNotFoundException{
		Scanner file = new Scanner(new FileInputStream(filename));
		int numberOfNames = file.nextInt();
		String[] names = new String[numberOfNames];
		//Here perform the sort and calculate the time it takes 
		for(int i = 0; i < numberOfNames; i++){
			names[i] = file.next();
			o.makeSet(names[i]);
		}
		long start = System.currentTimeMillis();
		while(file.hasNext()){
			String firstName = file.next();
			firstName = firstName.substring(0,firstName.length()-1);
			String secondName = file.next();
			o.combineGroup(firstName, secondName);
		}
		long end = System.currentTimeMillis();
		System.out.println("It took " + (end - start) + " miliseconds to calculate this grouping\n\n\n");
		file.close();
		return o;
	}
	
	
}
