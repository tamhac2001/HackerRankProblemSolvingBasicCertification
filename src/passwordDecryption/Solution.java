package passwordDecryption;

import java.io.*;
import java.lang.reflect.Array;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;



import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

	/*
	 * Complete the 'decryptPassword' function below.
	 *
	 * The function is expected to return a STRING. The function accepts STRING s as
	 * parameter.
	 */

	public static String decryptPassword(String s) {
		char charArr[] = s.toCharArray();
		Stack<Character> numberStack = new Stack<Character>();
		for (int i = 0; i < charArr.length;) {
			if (Character.isDigit(charArr[i])) {
				if (charArr[i] != '0') {
					numberStack.push(charArr[i]);
					charArr = Arrays.copyOfRange(charArr, i + 1, charArr.length);
				} else {
					charArr[i] = numberStack.pop();
					i++;
				}
			}
			else if(Character.isUpperCase(charArr[i])&&Character.isLowerCase(charArr[i+1])&&charArr[i+2]=='*') {
				char temp = charArr[i];
				charArr[i] = charArr[i+1];
				charArr[i+1]=temp;
				for(int j=i+2;j<charArr.length-1;j++) {
					charArr[j]=charArr[j+1];
				}
				charArr=Arrays.copyOf(charArr, charArr.length-1);
				i+=2;
			}
			else i++;
		}
		String ans = String.copyValueOf(charArr);
		return ans;

	}// end of method

}

public class Solution {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		String result = Result.decryptPassword(s);
		System.out.println(result);
	}
}
