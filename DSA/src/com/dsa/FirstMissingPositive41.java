package com.dsa;

import java.sql.SQLOutput;

public class FirstMissingPositive41 {
    public static void main(String[] args) {
        int [] arr = {1,2,0};//{7,8,9,11,12};//{3,4,-1,1};
        System.out.println("First Missing Num: "+firstMissingPositive(arr));

    }

    public static int firstMissingPositive(int[] arr) {
        int i =0;
        while(i<arr.length){
            int correctIndex= arr[i]-1;
            if( arr[i]>0 && arr[i]<=arr.length && arr[i] != arr[correctIndex]){
                swapIt(arr,i,correctIndex);
            }else{
                i++;
            }

        }
        //search for first missing number
        for(int index=0;index<arr.length;index++){
            if(arr[index]!= index+1){
                return index+1;
            }
        }

        //case2: return N+1
        return arr.length+1;
    }

    private static void  swapIt(int[] arr,int first,int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
