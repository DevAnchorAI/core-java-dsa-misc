package DSA.src.com.dsa;

import java.util.Arrays;

public class LengthOfLongestSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] numArray = twoSum(new int[]{3,1,3}, 6);
//		System.out.println("Index-0: "+numArray[0]+" Index-1: "+numArray[1]);	
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

	 public static int[] twoSum(int[] nums, int target) {

	      int [] numArray = new int[2];
	      
	       for(int i=0;i<nums.length;i++){

	    	   for(int j=i+1;j<nums.length;j++) {
		        	if(nums[i]+nums[j]==target){
		   	         numArray[0]=i;
		   	         numArray[1]=j;
		   	         break;
		   	        }
		        }
	       } 
	       
		return numArray;
	    }
}
