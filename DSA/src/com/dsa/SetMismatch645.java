package com.dsa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SetMismatch645 {
    public static void main(String[] args) {
        int[] arr = {1,2,2,4};//{1,1};
       int[] missMatched = findErrorNums(arr);
        System.out.println("missMatched: "+ Arrays.toString(missMatched));
    }

    public static int[] findErrorNums(int[] arr) {

        int i=0;
        while(i<arr.length){
            int correctIndex= arr[i]-1;
            if(arr[i] != arr[correctIndex]){
                swapIt(arr,i,correctIndex);
            }else{
                i++;
            }
        }

        for(int index=0; index<arr.length;index++){
            if(arr[index] != index+1){
                return  new int[]{arr[index],index+1};
            }
        }
        return  new int[]{-1,-1};
    }

    private static void swapIt(int[] arr, int first, int second){
        int temp= arr[first];
        arr[first]= arr[second];
        arr[second]=temp;
    }
}
