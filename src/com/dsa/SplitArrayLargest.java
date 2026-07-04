package com.dsa;

public class SplitArrayLargest {
    public static void main(String[] args) {
       int [] nums ={1,2,3,4,5};
       int k = 2;
        System.out.println(splitArray(nums,k));
    }

    public static int splitArray(int[] nums, int m) {

        int start =0;
        int end= 0;

        for(int i=0;i<nums.length;i++){
            start = Math.max(start,nums[i]);//At the end of the loop this will cantain maximum item of array
            end += nums[i];
        }

        //binary search
        while (start<end){
            int mid = start+(end-start)/2;
            int sum =0;
            int pieces =1;
            for(int num:nums){
                if((sum+num)>mid){
               //you can not add in this SubArray, make new one
                    //say you add this num in new SubArray, then sum= num
                    sum= num;
                    pieces++;//create new subarry
                }else{
                  sum +=num;
                }
            }
            if(pieces>m){
             start = mid+1;
            }else{
                end = mid;
            }
        }
        return end; //here start==end
    }
}
