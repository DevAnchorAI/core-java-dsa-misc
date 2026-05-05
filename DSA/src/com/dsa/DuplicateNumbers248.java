package com.dsa;
//https://leetcode.com/problems/find-the-duplicate-number/description/
public class DuplicateNumbers248 {
    public static void main(String[] args) {
        int[] arr = {3,1,3,4,2};//3,3,3,3,3};//{1,3,4,2,2};
        int duplicate = findDuplicate(arr);
        System.out.println("duplicate: "+duplicate);
    }

    public static int findDuplicate(int[] arr) {
        int i=0;

          while(i<arr.length){
              if(arr[i] != i+1){
                  int correctIndex= arr[i]-1;
                  if(arr[i] != arr[correctIndex]){
                      swapIt(arr,i,correctIndex);
                  }else{
                      return arr[i];
                  }
              }else{
                  i++;
              }
          }

        return -1;

    }
    private static void swapIt(int[] arr, int first, int second){
        int temp= arr[first];
        arr[first]= arr[second];
        arr[second]=temp;
    }
}
