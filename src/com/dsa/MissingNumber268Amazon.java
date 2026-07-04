package com.dsa;
//https://leetcode.com/problems/missing-number/submissions/1850491796/
public class MissingNumber268Amazon {
    public static void main(String[] args) {
    int[] arr= {3,0,1};
    int missingNum= missingNumber(arr);
    System.out.println("missingNum: "+missingNum);
    }

    public static int missingNumber(int[] arr) {
        int i =0;
        while(i<arr.length){
            int correctIndex= arr[i];
            if(arr[i]<arr.length && arr[i] != arr[correctIndex]){
                swapIt(arr,i,correctIndex);
            }else{
                i++;
            }

        }
        //search for first missing number
        for(int index=0;index<arr.length;index++){
            if(arr[index]!=index){
                return index;
            }
        }

        //case2: return N
        return arr.length;
    }

    private static void  swapIt(int[] arr,int first,int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
