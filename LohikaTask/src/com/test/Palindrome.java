package com.test;

public class Palindrome {
	
	public static boolean checkIfPalindrome (String str) {
		
		int i = 0;
		int j = str.length()-1;
		char [] arr = str.toCharArray();
		
		while (i < j) {
			if (arr[i++] != arr[j--])
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		
		String test1 = "12321";
		System.out.println(test1 + ": " + checkIfPalindrome(test1));

		String test2 = "123214";
		System.out.println(test2 + ": " + checkIfPalindrome(test2));
	}

}
