package com.dsa;

public class SmallestLetter {

    public static void main(String[] args) {
        System.out.println("CeilingLetter...");
        //char[] letters = {'c','f','j'};
        char[] letters = {'x','x','z','z'};
        char target = 'z';
        char ans = SmallestLetter.nextGreatestLetter(letters, target);

        System.out.println("Ceiling: "+ans);

    }
    //ceilingOfNumber: smallest_number >= Target
    public static char nextGreatestLetter(char[] letters, char target) {

        int start= 0;
        int end = letters.length-1;

        while(start<=end){

            int mid =start+(end-start)/2;

            if(target < letters[mid]) {
                end = mid -1;
            }else{
                start = mid+1;
            }

        }

        return letters[start % letters.length];
    }
}
