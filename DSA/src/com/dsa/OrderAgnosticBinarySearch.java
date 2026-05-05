package com.dsa;

public class OrderAgnosticBinarySearch {

    public static void main(String[] args) {
        System.out.println("Binary Search");
        int[] ascArr = {-18,-12,-4,0,2,3,4,15,16,18,22,45,89};
        int[] descArr = {99,89,75,22,10,8,6,5};
        int key = 22;
        int ans = OrderAgnosticBinarySearch.agnosticSearch(descArr, key);

        System.out.println("key found at: "+ans);

    }
    public static int agnosticSearch(int[] arr, int target) {
        int start= 0;
        int end =  arr.length-1;
        boolean isAscending = arr[start] < arr[end];

        while(start<=end) {
            int mid = start+ (end-start)/2;

            if(target == arr[mid]){
                return mid;
            }
            if(isAscending){
                if( target< arr[mid]) {
                    end = mid-1;
                }else {
                    start = mid+1;
                }
            }else{
                if( target > arr[mid]) {
                    end = mid-1;
                }else {
                    start = mid+1;
                }
            }

        }
        return -1;
    }


}
