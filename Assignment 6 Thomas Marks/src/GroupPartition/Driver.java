package GroupPartition;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
	public static void main(String args[]) throws FileNotFoundException{
		UnionFind<String> total = new UnionFind<>();
		GroupPartition filled =  creatGroup(total);
		
		
		
	}
	
	public static GroupPartition<String> creatGroup(GroupPartition<String> o) throws FileNotFoundException{
		Scanner file = new Scanner(new FileInputStream("NumberTest.txt"));
		int numberOfNames = file.nextInt();
		String[] names = new String[numberOfNames];
		
		System.out.println(numberOfNames);
		for(int i = 0; i < numberOfNames; i++){
			names[i] = file.next();
			o.makeSet(names[i]);
		}
		System.out.println(o);
		
		while(file.hasNext()){
			String firstName = file.next();
			firstName = firstName.substring(0,firstName.length()-1);
			String secondName = file.next();
			o.combineGroup(firstName, secondName);
		}
		ArrayList<ArrayList<String>> groupNames = new ArrayList<>();
		for(int i = 0; i < groupNames.size(); i++){
			boolean alreadyGroup = false;
			String repName = o.find(names[i]);
			for(int j = 0; j < groupNames.size(); i++){
				if(repName.equals(groupNames.get(j).get(0))){
					groupNames.get(j).add(names[i]);
					alreadyGroup = true;
				}
			}
			if(!alreadyGroup){
				groupNames.add(new ArrayList<>());
				groupNames.get(groupNames.size()).add(names[i]);
			}
		}
		
		file.close();
		return o;
	}
	
	
}
