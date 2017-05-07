package medium;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
public class CandidateCode {
    /*
     * Complete the function below.
    */

public static int appearanceCount(int input1,int input2,String input3,String input4)
    {
		if(input1 > input2) return 0;
	    if(input1 < 1) return 0;
	    int count =0;
	    int startIndex=0;
	    int endIndex=input1;
	    String sortedPattern = sortChars(input3);
	    while(startIndex < endIndex && endIndex <= input2) {
	        String part = input4.substring(startIndex,endIndex);
	        String sortedPart= sortChars(part);
	        if(sortedPattern.equals(sortedPart)) ++count;
	        startIndex++;
	        endIndex++;

	    }
	    return count;
    }
	
	public static String sortChars(String text) {
		String lowerText = text.toLowerCase();
	    char[] chars = text.toCharArray();
	    Arrays.sort(chars);
	    String sortedChars = new String(chars);
	    return sortedChars;
	}
	
	
	public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(System.in);
        int output = 0;
        int ip1 = Integer.parseInt(in.nextLine().trim());
        int ip2 = Integer.parseInt(in.nextLine().trim());
        String ip3 = in.nextLine().trim();
        String ip4 = in.nextLine().trim();
        output = appearanceCount(ip1,ip2,ip3,ip4);
        System.out.println(String.valueOf(output));
    }
}

