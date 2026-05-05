package com.dsa;

import java.util.Arrays;

public class LongestSubstring {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring(" "));
        System.out.println(lengthOfLongestSubstring("au"));
    }

    public static int lengthOfLongestSubstring(String s) {
        int left = 0;
        int maxlength =0;
        int[] charIndexArr = new int[128];
        Arrays.fill(charIndexArr, -1);

        for(int right=0;right<s.length();right++){
            //If the character has occurred,
            //then move the left pointer to the next position after the last occurrence of the character.
            if(charIndexArr[s.charAt(right)]>=left){
                left= charIndexArr[s.charAt(right)]+1;

            }

            //update the index of current character in charIndexArr
            charIndexArr[s.charAt(right)]=right;
            maxlength= Math.max(maxlength,right-left+1);

        }
        return maxlength;
    }


}

