package com.revature;

import java.util.ArrayList;
import java.util.List;

/*
 * Card Checker class contains method validate(String CreditCardNumber) and returns boolean
 * that indicates if it true or false
 * 
 */

public class CardChecker {

	
	public static boolean validate(String number) {
		
		//Return false if length is less than one
		if(number.length() < 14 || number.length() > 19) {
			return false;
		}
		
		//Declare vars
		int sum = 0;
		char[] arr = number.toCharArray();
		List<Integer> nums = new ArrayList<>();
		
		//parse number into list of Integers with error checking
		for (char c : arr) 
		{	
			if(c == ' ') {
				continue;
			} else if(!Character.isDigit(c)) {
				return false;
			} else {
				int n = c - '0';
				nums.add(n);
			}
			
		} 
		
		/*	Pass lunh test:
		 *  	Reverse the number, dobule value at each digit in odd position.
		 */
		int i = nums.size() - 2;
		while (i > -1) 
		{
			int n = nums.get(i);
			if(2*n > 9) {
				sum += 2*n - 9;
			} else {
				sum += 2*n;
			}
			sum += i > 0 ? nums.get(i-1) : 0;
			//System.out.printf("%d %d ", 2*n, nums.get(i-1));
			i-=2;
		}
		//END WHILE
		
		
		//Step 5. subtract last digit OF the sum from 10
		int check = 10 - (sum % 10);
		System.out.println("\nCheck is: " + check);
		
		//return whether sum is divis by 10
		return (check == nums.get(nums.size()-1));
	}
	
}
