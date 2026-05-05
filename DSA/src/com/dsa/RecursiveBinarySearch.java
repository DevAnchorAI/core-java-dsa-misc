package com.dsa;

public class RecursiveBinarySearch {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,55,66,78};
        int target =78;
        System.out.println(recursiveSearch(arr,target,0,arr.length-1));
    }
    static int recursiveSearch(int[] arr, int target, int start, int end){

        if(start>end) return -1;
        int mid= start + (end-start)/2;
        if( arr[mid] == target){
            return mid;
        }
        if(target  < arr[mid]){
            return recursiveSearch(arr,target,start,mid-1);
        }
        return recursiveSearch(arr,target,mid+1,end);

    }

}
