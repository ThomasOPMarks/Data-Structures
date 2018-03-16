package nameSets;

//
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

//Makes two lists and looks at the number of names that are the same
public class Driver {
	public static void main(String args[]) throws FileNotFoundException{
		//This makes all the variables 
		Scanner girls = new Scanner(new FileInputStream("girlnames.txt"));
		Scanner boys = new Scanner(new FileInputStream("boynames-1.txt"));
		ArraySet<String> names = new ArraySet<>();
		String current = "";
		ArrayList<String> shared = new ArrayList<>();
		
		//Puts all the girls into a list
		while(girls.hasNext()){
			current = girls.next();
			try{
				Integer.parseInt(current);
			}
			catch (NumberFormatException e){
				names.add(current);
			}
			
		}
		
		
		//Checks to see if all the boys names are the same.
		while(boys.hasNext()){
			current = boys.next();
			try{
				Integer.parseInt(current);
			}
			catch (NumberFormatException e){
				if(!names.add(current)){
					shared.add(current);
				}
			}
		}
		
		//Prints out the shared names and how many names are shared.
		System.out.println(shared.toString());
		System.out.println(shared.size());
		girls.close();
		boys.close();
	}
}
