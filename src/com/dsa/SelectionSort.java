package com.dsa;

import java.util.Arrays;


public class SelectionSort {
    public static void main(String[] args) {
        int[] arr= {2,1,-3,8,7,5,9,0};
        System.out.println(Arrays.toString(selection(arr)));
    }

    private static int[] selection(int[] arr) {
        for(int i=0;i<arr.length;i++){

            int last = arr.length-i-1;
            int maxIndex = findMaxIndex(arr,0,last);
            swapIt(arr,maxIndex,last);
        }
        return arr;
    }
    private static int findMaxIndex(int[] arr,int start ,int end) {
        int max  = start;
        for(int i=start;i<end;i++){
        if(arr[max] < arr[i]){
            max= i;
        }
    }
   return max;
    }
    private static void swapIt(int[] arr,int first, int second) {
        int temp = arr[first];
        arr[first]=arr[second];
        arr[second]=temp;
    }

}
