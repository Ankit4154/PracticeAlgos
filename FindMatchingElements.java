package prep;

import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FindMatchingElements {
	
	/*
	 * Output :
	35 40 55 
	Ellapsed time for brute force : 4000000
	35 40 55 
	Ellapsed time for binary search : 3000000
	35 40 55 
	Ellapsed time for hashmap : 2000000
	*/


	public static void main(String args[]) throws InterruptedException{
		int arr[] = {13,27,35,40,49,55,59};
		int arr2[] = {17,35,39,40,55,58,60};
		
		Map<Integer, Integer> map = new HashMap<>();
		
		Instant start = Instant.now();
		// Brute force N square solution O(N^2)
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr2.length;j++){
				if(arr[i]==arr2[j]){
					System.out.print(arr[i]+" ");
				}
			}
		}
		
		Thread.sleep(2);
		Instant end = Instant.now();
		Duration elp = Duration.between(start, end);
		System.out.println("\nEllapsed time for brute force : " + elp.toNanos());
		
		List<Integer> list = IntStream.of(arr2).boxed().collect(Collectors.toList());
		start = Instant.now();
		// Binary search solution O(NlogN)
		for(int i=0;i<arr.length;i++){
			if(binary(list, arr[i]) >=0) {
			//if(Collections.binarySearch(list, arr[i])>=0) {
				System.out.print(arr[i]+" ");
			}
		}
		Thread.sleep(2);
		end = Instant.now();
		elp = Duration.between(start, end);
		System.out.println("\nEllapsed time for binary search : " + elp.toNanos());
		
		
		start = Instant.now();
		// HashMap solution O(N), space complexity O(N)
		for(int i=0;i<arr.length;i++){
			map.put(arr[i], 0);
		}
		for(int i=0;i<arr2.length;i++){
			if(map.containsKey(arr2[i])) {
				System.out.print(arr2[i] + " ");
			}
		}
		Thread.sleep(2);
		end = Instant.now();
		elp = Duration.between(start, end);
		System.out.println("\nEllapsed time for hashmap : " + elp.toNanos());
		
		start = Instant.now();
		// Optimum solution O(N) without hashmap, space complexity O(1) 
		int j=0;
		for(int i=0;i<arr.length;i++){
			for(;j<arr2.length;j++) {
				if(arr2[j]>arr[i]) {
					break;
				}else if(arr[i] == arr2[j]) {
						System.out.print(arr[i] + " ");
						j++;
						break;
				}
			}
		}
		
		Thread.sleep(2);
		end = Instant.now();
		elp = Duration.between(start, end);
		System.out.println("\nEllapsed time for Optimum : " + elp.toNanos());
		
	}
	
	
	static int binary(List<Integer> list, int key) {	
		int low = 0;
        int high = list.size()-1;

		while(low <= high) {
			int median = (high+low+1)/2;
			int cmp = list.get(median);
			if(key == cmp) {
				return median;
			}else if(key < cmp) {
				high = median - 1;//binary(list, low, median-1,key);
			}else {
				low = median + 1;// binary(list, median+1, high, key);
			}
		}
		return -(low+1);
	}
	
}
