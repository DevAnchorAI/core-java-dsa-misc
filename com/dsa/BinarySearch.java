package com.dsa;

public class BinarySearch {

	public static void main(String[] args) {
		System.out.println("Binary Search");
		int[] elementsArr = {2,3,4,10,40};
		int elementIndex = BinarySearch.binarySearchkey(elementsArr, 4);
		if(elementIndex == -1) {
			System.out.println("key not found");
		}else {
			System.out.println("key found at: "+elementIndex);
		}


	}
	public static int binarySearch(int[] arr, int target) {
		int start= 0;
		int end =  arr.length-1;
		while(start<=end) {
			int mid = start+ (end-start)/2;
			
			if( target< arr[mid]) {
				end = mid-1;
			}else if(target>arr[mid]) {
				start = mid+1;
			}else {
				return mid;
			}
		}
		return -1;
	}

	public static int binarySearchkey(int[] arr, int key){

		int start = 0;
		int end = arr.length-1;
		while (start<=end){
			int mid = 1 +(end-start)/2;
			if(key<arr[mid]){
				end= mid -1;
			}else if(key>  arr[mid]){
				start= mid+1;
			}else{
				return mid;
			}

		}
		return -1;
	}

	


}
