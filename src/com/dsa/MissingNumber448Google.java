package com.dsa;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/description/
public class MissingNumber448Google {

    public static void main(String[] args) {
       int[] arr ={4,3,2,7,8,2,3,1};
        List<Integer>  missingNums = findDisappearedNumbers(arr);
        System.out.println("missingNums: "+missingNums);
    }
    public static  List<Integer> findDisappearedNumbers(int[] nums) {

        int i =0;
        while(i<nums.length){
            int correctIndex= nums[i]-1;//(ElementValue -1)
            if(nums[i] != nums[correctIndex]){
                swapIt(nums,i,correctIndex);
            }else{
                i++;
            }

        }
        //find missing numbers here..
        List<Integer> missingNumList = new ArrayList<>();
        for(int index=0;index<nums.length;index++){
            if(nums[index] != index+1){
                missingNumList.add(index+1);
            }
        }
        return missingNumList;
    }

    private static void swapIt(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
