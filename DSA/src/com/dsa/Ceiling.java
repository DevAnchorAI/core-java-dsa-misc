package com.dsa;

public class Ceiling {
    public static void main(String[] args) {
        System.out.println("Binary Search");
        int[] arr = {2,3,5,9,14,16,18};
        int target = 22;
        int ans = Ceiling.ceilingOfNumber(arr, target);

        System.out.println("Ceiling: "+ans);

    }
    //ceilingOfNumber: smallest_number >= Target
    public static int ceilingOfNumber(int[] arr, int target) {
        int start= 0;
        int end =  arr.length-1;

        //but what if Target element is grater than the largest number in array

        if(target> arr[end]){
            return -1;
        }
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
        return start;
    }
}
