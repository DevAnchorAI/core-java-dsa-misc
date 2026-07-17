package com.dsa;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr= {4,5,3,2,1};
        System.out.println("Input: "+Arrays.toString(arr));
        System.out.println("Output: "+Arrays.toString(bubbleSort(arr)));
    }

    private static int[] bubbleSort(int[] arr){
       boolean swapped;
       int n = arr.length;
        for(int i=0;i<n-1;i++){
            swapped = false;
            for(int j=0;j<n-1-i;j++){
                if(arr[j]>arr[j+1]){
                    int temp =arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swapped =true;
                }
            }
            //if you did not swapped for any particular value of i; that means Array is sorted.
            //hence terminate the program
            if(!swapped){
                break;
            }
        }
        return arr;
    }



}
