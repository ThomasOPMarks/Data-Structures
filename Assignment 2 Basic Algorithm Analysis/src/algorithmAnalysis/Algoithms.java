package algorithmAnalysis;

public class Algoithms {
	//Compares every value with every other value
	public static boolean sequential(int[] a){// HAS AN O(N^2)
		for(int i = 0; i < a.length; i++){ // This is an O(n)
			for(int j = i + 1; j < a.length; j++){ //This is the sum of ints squared (n * (n+1)/2))
				if(a[i] == a[j] * -1){ //Constant
					return true; //Constant
				}
			}
		}
		return false; //Constant
	}
	//This does a binary search for every value
	public static boolean binarySearch(int[] a) throws Exception{//HAS AN O(n * log(n))
		for (int n = 0; n < a.length; n++){//This is an O(n)
			int search = -a[n]; //Constant
			int first = 0; //Constant
			int last = a.length - 1; //Constant 
			
			while(first <= last){ //A O(log(n))
				int middle = (first + last)/2;//Constant
				if (a[middle] == search){//Constant
					return true;//Constant
				}
				else if(search < a[middle]){
					last = middle - 1;
				}
				else if(search > a[middle]){
					first = middle + 1;
				}
				else{
					throw new Exception("Bad index");
				}
			}
		}
		return false;
	}
	//This moves two indexes as needed, toward each other.
	public static boolean twoIndex(int[] a){//HAS AN O(n)
		int i = 0;//Constant
		int j = a.length - 1;//Constant
		int sum = a[i] + a[j];//Constant
		
		while(sum != 0){//This will at most be O(n), assuming that the two values are next to each other
			sum = a[i] + a[j];
			if(i == j){
				return false;
			}
			else if( sum < 0){
				i++;
			}
			else{
				j--;
			}
		}
		return true;
	}
	
	
}
