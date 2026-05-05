package com.dsa;
import java.util.Arrays;

public class MedianSortedArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findMedianSortedArrays(new int[]{1,3},new int[]{2}));
		System.out.println(findMedianSortedArrays(new int[]{1,2},new int[]{3,4}));
		System.out.println(findMedianSortedArrays(new int[]{2,2,4,4},new int[]{2,2,2,4,4}));
	}
	
	  public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

	     int totalElements= nums1.length+nums2.length;
         int[] arr =new int[totalElements];
         int arr2Index=0;
	     for(int i=0; i<nums1.length;i++) {
	    	 arr[i]= nums1[i];
	     }
	     for(int i=nums1.length; i<totalElements;i++) {
	    	 arr[i]= nums2[arr2Index++];
	     }
	
	     for(int i=0;i<totalElements;i++) {
	    	 for(int j=i+1;j<totalElements;j++) {
	    		 if(arr[i]>arr[j]) {
	    			 int temp = arr[i];
	    			 arr[i] =arr[j];
	    			 arr[j]= temp;
	    		 }
	    	 }
	     }

	     int mid =totalElements/2;

	     if(totalElements%2==0) {
	    	 return  (arr[mid-1] +arr[(mid)])/2.0 ;
	    	 
	     }else {
	    	 return arr[mid] ;
	     }
 
	    }
	

}
