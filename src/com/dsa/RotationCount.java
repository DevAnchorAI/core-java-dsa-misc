package com.dsa;

public class RotationCount {
    public static void main(String[] args) {
      int[] arr= {4,5,6,7,0,1,2};
        System.out.println(countRotations(arr));
    }

    private static int countRotations(int[] arr){
        int pivot = findPivot(arr);
        System.out.println("pivot: "+pivot);
        return pivot+1;
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


}
