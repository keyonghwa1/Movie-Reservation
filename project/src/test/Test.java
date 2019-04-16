package test;

import java.util.ArrayList;
import java.util.Collections;

public class Test {

	public static void main(String[] args) {
		
		ArrayList<String> list = new ArrayList<>();
		list.add("17 18 19 20");
		list.add("8 9 10");
		
		ArrayList<Integer> already_list = new ArrayList<>();
		
		for( String seats : list ) {
			String [] arr = seats.split(" ");
			
			for( int i = 0; i < arr.length; i++ ) {
				already_list.add( Integer.parseInt(arr[i]) );
			}
		}

		Collections.sort(already_list);
		for( int seat : already_list ) {
			System.out.println(seat);
		}
		
		
	}

}
