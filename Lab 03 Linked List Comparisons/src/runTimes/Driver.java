package runTimes;

import java.util.ArrayList;

public class Driver {
	public static void main(String args[]) throws Exception{
		for (int n = 50000; n < 200001; n += 50000){
			LinkedList linkedList = new LinkedList();
			ArrayList<Integer> arrayList = new ArrayList<>();
			DLinkedList<Integer> dLinkedList = new DLinkedList<>();
			System.out.println("Adding them");
			long start1 = System.currentTimeMillis();
			for (int i = 0; i < n; i++){
				linkedList.insertAtHead(i);
			}
			long end1 = System.currentTimeMillis();
			
			long start2 = System.currentTimeMillis();
			for (int i = 0; i < n; i++){
				arrayList.add(0, i);;
			}
			long end2 = System.currentTimeMillis();
			
			long start3 = System.currentTimeMillis();
			for (int i = 0; i < n; i++){
				dLinkedList.insetAtHead(i);
			}
			long end3 = System.currentTimeMillis();
			
			System.out.println("" + n + ", " + (end1 - start1) + ", " + (end2 - start2) + ", " + (end3 - start3));
			
			System.out.println("Removing them");
			
			start1 = System.currentTimeMillis();
			for (int i = 0; i < n; i++){
				linkedList.removeTail();
			}
			end1 = System.currentTimeMillis();
			
			start2 = System.currentTimeMillis();
			for (int i = 0; i < n; i++){
				arrayList.remove(arrayList.size()-1);
			}
			end2 = System.currentTimeMillis();
			
			start3 = System.currentTimeMillis();
			for (int i = 0; i < n; i++){
				dLinkedList.removeAtTail();
			}
			end3 = System.currentTimeMillis();
			
			System.out.println("" + n + ", " + (end1 - start1) + ", " + (end2 - start2) + ", " + (end3 - start3));
		}
	}
}
