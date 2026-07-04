package com.dsa;

public class SearchInMountain {
    public static void main(String[] args) {

        int[] arr = {1,2,3,4,5,3,1};
        int target = 3;
        System.out.println("Ans::"+findInMountainArray(arr,target));
    }

    private static int findInMountainArray(int[] arr, int target) {
        int peak = peakIndexInMountainArray(arr);
        int firstSearch = agnosticSearch(arr, target,0,peak);
        if(firstSearch != -1){
            return firstSearch;
        }
        return  agnosticSearch(arr,target,peak+1,arr.length-1);
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

    public static int agnosticSearch(int[] arr, int target,int start,int end) {

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


/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

//class Solution {
//    public int findInMountainArray(int target, MountainArray mountainArr) {
//        int peak = peakIndexInMountainArray(mountainArr);
//        int firstSearch = agnosticSearch(mountainArr, target,0,peak);
//        if(firstSearch != -1){
//            return firstSearch;
//        }
//        return  agnosticSearch(mountainArr,target,peak+1,mountainArr.length()-1);
//    }
//
//    public  int peakIndexInMountainArray(MountainArray mountainArr) {
//
//        int start =0;
//        int end = mountainArr.length()-1;
//
//        while(start<end){
//            int mid = start +(end-start)/2;
//            if(mountainArr.get(mid)> mountainArr.get(mid+1)){
//                //that means we are in decraesing part of arr
//                end = mid;
//            }else{
//                //we are in increasing part of array
//                start = mid+1;
//            }
//        }
//        // we can return either of start or end , since start and trying to find the max value,
//        //henc both will react to the same index when maximum value arrived.
//        return start;
//    }
//
//    public  int agnosticSearch(MountainArray mountainArr, int target,int start,int end) {
//
//        boolean isAscending = mountainArr.get(start) < mountainArr.get(end);
//
//        while(start<=end) {
//            int mid = start+ (end-start)/2;
//
//            if(target == mountainArr.get(mid)){
//                return mid;
//            }
//            if(isAscending){
//                if( target< mountainArr.get(mid)) {
//                    end = mid-1;
//                }else {
//                    start = mid+1;
//                }
//            }else{
//                if( target > mountainArr.get(mid)) {
//                    end = mid-1;
//                }else {
//                    start = mid+1;
//                }
//            }
//
//        }
//        return -1;
//    }
//
//}