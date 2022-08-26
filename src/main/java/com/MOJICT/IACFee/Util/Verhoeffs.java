package com.MOJICT.IACFee.Util;

import org.apache.log4j.Logger;
//import org.apache.commons.validator.routines.checkdigit.VerhoeffCheckDigit;
/**
 * @author turnerdv
 * @see <a href="http://en.wikipedia.org/wiki/Verhoeff_algorithm/">More Info</a>
 * @see <a href="http://en.wikipedia.org/wiki/Dihedral_group">Dihedral Group</a>
 * @see <a href="http://mathworld.wolfram.com/DihedralGroupD5.html">Dihedral
 *      Group Order 10</a> To generate a Verhoeff number: 1 - Reverse input
 *      string 2 - Get length of input string 3 - initiliase c to 0 4 - create
 *      int array from input string 5 - reverese int array 6 - iterate through
 *      int array 6.i c = value from d[previous c] [p[iteration+1 % 8][int array
 *      value at this iteration]] 7 return final value of inv[c] //inv = {0, 4,
 *      3, 2, 1, 5, 6, 7, 8, 9}
 * 
 *      so a value of 10 would do this: 1 - 01 2 - 2 3 - 0 4 - ['0','1'] 5 - i -
 *      c = d[0][p[1][0]] = d[0][1] = 1 ii - c = d[1][p[2][1]] = d[1][8] = 9
 *      return inv[9] = 9
 * 
 *      SQL are doing it: 1 - Reverse input string (@n) 2 - Get length of input
 *      string (@len) 3 - initialise c to 0 (@c) 4 - initialise
 *      @inv='0432156789' 4 - iterate through each character of @n 4.1 set @m to
 *      p[((iteration+1 % 8) * 10 + int value of current char)] 4.2 set @c to
 *      d[(@c *10 + @m+1)] 5 - return 8 bit - value of inv [@c+1] SET @m = CAST(
 *      substring(@p, ( ( (@i+1)%8 )*10 )+ CAST( substring(@n,@i+1,1) as
 *      tinyint)+1,1) as tinyint ); SET @c = CAST(substring(@d,(@c*10+@m+1),1)
 *      as tinyint); SET @i=@i+1//increment loop
 * 
 *      so a value of 10 would do this: 1 - 01 2 - 2 3 - 0 5 - iterate through
 *      '0','1' i = m = 1 = (p [(0+1 % 8 = 1)* 10 = 10)+1]) = p[11] //no
 *      position 0 apparently - starts from 1? c = 1 = (d (0 * 10 + 1 +1 = 2) ii
 *      = m = 5 = (p [1+1 % 8 = 1) * 10 = 10)+ 2) = p[12] c = 6 = d [(1 * 10 + 5
 *      + 1 = 16)] = d[16] return inv[c+1] = inv[7] = 6
 * 
 */
public class Verhoeffs {
	/**
	 * log4j logging solution
	 */
	static Logger logger = Logger.getLogger(Verhoeffs.class);

	// The multiplication table
	static int[][] d = new int[][] { { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 }, { 1, 2, 3, 4, 0, 6, 7, 8, 9, 5 },
			{ 2, 3, 4, 0, 1, 7, 8, 9, 5, 6 }, { 3, 4, 0, 1, 2, 8, 9, 5, 6, 7 }, { 4, 0, 1, 2, 3, 9, 5, 6, 7, 8 },
			{ 5, 9, 8, 7, 6, 0, 4, 3, 2, 1 }, { 6, 5, 9, 8, 7, 1, 0, 4, 3, 2 }, { 7, 6, 5, 9, 8, 2, 1, 0, 4, 3 },
			{ 8, 7, 6, 5, 9, 3, 2, 1, 0, 4 }, { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 } };

	// The permutation table
	static int[][] p = new int[][] { { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 }, { 1, 5, 7, 6, 2, 8, 3, 0, 9, 4 },
			{ 5, 8, 0, 3, 7, 9, 6, 1, 4, 2 }, { 8, 9, 1, 6, 0, 4, 3, 5, 2, 7 }, { 9, 4, 5, 3, 1, 2, 6, 8, 7, 0 },
			{ 4, 2, 8, 6, 5, 7, 3, 9, 0, 1 }, { 2, 7, 9, 3, 8, 0, 6, 4, 1, 5 }, { 7, 0, 4, 6, 9, 1, 3, 2, 5, 8 } };

	// The inverse table
	static int[] inv = { 0, 4, 3, 2, 1, 5, 6, 7, 8, 9 };

	/*
	 * For a given number generates a Verhoeff digit
	 */
	public static String generateVerhoeff(String num) {

		int c = 0;
		try {
			Long.parseLong(num);
		} catch (NumberFormatException ex) {
			return "X"; // we'll deal with this later when we validate the same
						// value
		}
		int[] myArray = StringToReversedIntArray(num);

		for (int i = 0; i < myArray.length; i++) {
			c = d[c][p[((i + 1) % 8)][myArray[i]]];
		}
		return Integer.toString(inv[c]);
	}
	  
	/*
	 * Validates that an entered number is Verhoeff compliant. NB: Make sure the
	 * check digit is the last one.
	 */
	public static boolean validateVerhoeff(String num) {

		int c = 0;
		try {
			if(num.length()>18||num.length()<18)
			{
				return false;
			}
			Long.parseLong(num.substring(2));
		} catch (NumberFormatException ex) {
			return false;
		}
		num = Verhoeffs.removeLeadingZeros(num.substring(2));
		int[] myArray = StringToReversedIntArray(num);

		for (int i = 0; i < myArray.length; i++) {
			c = d[c][p[(i % 8)][myArray[i]]];
		}

		return (c == 0);
	}

	
	public static String validatereference(String num) {

		int c = 0;
		try {
			String caps=num.substring(0,2);
			boolean flag = caps.matches("^[a-zA-Z]+$");
			if(!flag)
			{
				return "failure";
			}
			
			caps=caps.toUpperCase();
			String rem=num.substring(2);
			caps=caps.concat(rem);
			return caps;
		} catch (Exception ex) {
			return "failure";
		}
		
	}
	/*
	 * Converts a string to a reversed integer array.
	 */
	private static int[] StringToReversedIntArray(String num) {

		int[] myArray = new int[num.length()];

		for (int i = 0; i < num.length(); i++) {
			myArray[i] = Integer.parseInt(num.substring(i, i + 1));
		}

		myArray = Reverse(myArray);

		return myArray;

	}

	private static String removeLeadingZeros(String valToStrip) {
		String tempString = valToStrip;
		while (tempString.substring(0, 1).equals("0")) {
			tempString = tempString.substring(1);
		}
		return tempString;
	}

	/*
	 * Reverses an int array
	 */
	private static int[] Reverse(int[] myArray) {
		int[] reversed = new int[myArray.length];

		for (int i = 0; i < myArray.length; i++) {
			reversed[i] = myArray[myArray.length - (i + 1)];
		}

		return reversed;
	}

	public static void main(String args[]) {
		String root = "0002320110214024";
		for(int i = 0; i <10;i++){
			
			logger.debug("Generated"+Verhoeffs.generateVerhoeff(root));
			//root=root+i;
			if(Verhoeffs.validateVerhoeff(root))
			{
			System.out.print("Verhoeff is"+root);
			}
			logger.debug("finish");
		}
	}
}