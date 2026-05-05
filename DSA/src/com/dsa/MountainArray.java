package com.dsa;

public class MountainArray {
    public static void main(String[] args) {

        int[] arr = {0,10,5,2};
     System.out.println(peakIndexInMountainArray(arr));
    }
    public static int peakIndexInMountainArray(int[] arr) {

        int start =0;
        int end = arr.length-1;

        while(start<end){
            int mid = start +(end-start)/2;
            if(arr[mid]> arr[mid+1]){
                //that means we are in decraesing part of arr
                end = mid;
            }else{
                //we are in increasing part of array
                start = mid+1;
            }
        }
        // we can return either of start or end , since start and trying to find the max value,
        //henc both will react to the same index when maximum value arrived.
        return start;
    }
}
