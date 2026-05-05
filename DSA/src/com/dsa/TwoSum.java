package com.dsa;

public class TwoSum {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] numArray = twoSum(new int[]{3,1,3}, 6);
        System.out.println("Index-0: "+numArray[0]+" Index-1: "+numArray[1]);

    }

    public static int[] twoSum(int[] nums, int target) {

        int [] numArray = new int[2];

        for(int i=0;i<nums.length;i++){

            for(int j=i+1;j<nums.length;j++) {
                if(nums[i]+nums[j]==target){
                    numArray[0]=i;
                    numArray[1]=j;
                    break;
                }
            }
        }

        return numArray;
    }
}
