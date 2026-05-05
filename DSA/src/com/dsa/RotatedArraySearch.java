package com.dsa;

public class RotatedArraySearch {
    public static void main(String[] args) {
    int[] nums = {3,5,1};
    int target= 3;
    System.out.println(search(nums,target));
    }

    public static int search(int[] nums, int target) {

        int pivot = findPivot(nums);
        System.out.println("pivot:"+pivot);
        //that means it's not Rotated Array,, do simple Binary search
        if(pivot ==-1){
         return binarySearch(nums,target,0,nums.length-1);
        }
        if(nums[pivot]==target){
            return pivot;
        }
        //if Pivot found, that means we have 2 ascending sortaed array
        if(target>=nums[0]){
            //search in first ascending half
            return binarySearch(nums,target,0,pivot-1);
        }
        return binarySearch(nums,target,pivot+1,nums.length-1);
    }

    //use this for duplicates
    private static int findPivot(int[] arr){
      int start =0;
      int end = arr.length-1;

      while(start<=end){
          int mid =start +(end-start)/2;
          //write all 4 cases
          if(mid<end && arr[mid]>arr[mid+1]){
              return mid;//Pivot
          }
          if(mid>start && arr[mid]<arr[mid-1]){
              return mid-1;//pivot
          }
          //when start, and mid might reach at same position
          if(arr[mid]<= arr[start] ){

                end=mid-1;
          }else {
              //if(arr[mid]>=arr[start]){
              //if this cas was pivot, then it would have been cought in step1 & step2
              //hence proved that bigger number lying ahead.
              //hence ignore mid and start=mid+1
              start =mid+1;
          }

      }
      return -1;
    }
    //use this when Array contains  non-duplicates
    private static int findPivotWithoutDuplicates(int[] arr){
        int start =0;
        int end = arr.length-1;

        while(start<=end){
            int mid =start +(end-start)/2;
            //write all 4 cases
            if(mid<end && arr[mid]>arr[mid+1]){
                return mid;//Pivot
            }
            if(mid>start && arr[mid]<arr[mid-1]){
                return mid-1;//pivot
            }
            //when start, and mid might reach at same position
            if(arr[start]==arr[mid] || arr[mid]==arr[end]){
                if(arr[start]>arr[start+1]){
                    return start;
                }
                start++;
                if(arr[end]<arr[end-1]){
                    return end-1;
                }
                end--;

            }
            //left side array is sorted, pivot lying at right side array
            else if (arr[start]<arr[mid] ||(arr[start]==arr[mid] && arr[mid]>arr[end])) {
             start= mid+1;
            }else{
                end=mid-1;
            }

        }
        return -1;
    }

    private static int binarySearch(int[] arr, int target, int start,int end){

        while(start<=end){
            int mid = start+(end-start)/2;

            if(target<arr[mid]){
                end = mid-1;
            }else if(target>arr[mid]){
                start =  mid+1;
            }else{
                return mid;
            }
        }
        return -1;
    }
}
