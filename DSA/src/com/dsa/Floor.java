package com.dsa;

public class Floor {
    public static void main(String[] args) {
        System.out.println("Binary Search");
        int[] arr = {2,3,5,9,14,16,18};
        int target = 1;
        int ans = Floor.floorOfNumber(arr, target);

        System.out.println("Floor: "+ans);

    }
    //ceilingOfNumber: greatest_number <= Target
    public static int floorOfNumber(int[] arr, int target) {
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
        return end;
    }
}
