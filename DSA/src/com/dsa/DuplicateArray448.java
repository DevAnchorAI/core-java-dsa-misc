package com.dsa;

import java.util.ArrayList;
import java.util.List;

public class DuplicateArray448 {

    public static void main(String[] args) {
        int[] arr = {4,3,2,7,8,2,3,1};
        List<Integer> dupArr =findDuplicates(arr);
        System.out.println("dupArr: "+dupArr);
    }
    public static List<Integer> findDuplicates(int[] arr) {

        int i=0;

        while(i<arr.length){
                int correctIndex= arr[i]-1;
                if(arr[i] != arr[correctIndex]){
                    swapIt(arr,i,correctIndex);
                }else{
                    i++;
                }

        }
        List<Integer> missingNums = new ArrayList<>();
        for(int index=0; index<arr.length;index++){
            if(arr[index] != index+1){
                missingNums.add(arr[index]);
            }
        }

        return missingNums ;
    }

    private static void swapIt(int[] arr, int first, int second){
        int temp= arr[first];
        arr[first]= arr[second];
        arr[second]=temp;
    }
}
