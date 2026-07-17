package com.misc;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstring {

	
	 static int longestUniqueSubsttr(String str) {
	       
		 int res=0;
		 int i=0;
		 Map<Character,Integer> map= new HashMap<>();
		 for(int j=0;j<str.length();j++) {
			 if(map.containsKey(str.charAt(j))) {
				i = Math.max(i, map.get(str.charAt(j))+1);
			 }
			 //update the result if needed
			 res= Math.max(res, j-i+1);
			 
			 //update the last occurance of current Character
			 map.put(str.charAt(j),j);
		 }
		 return res;
	    }
	public static void main(String[] args) {

		int result =longestUniqueSubsttr("AABBBBACDCCCC");
		System.out.println("Length of longest substring without repeating character is:"+result);

	}

}
