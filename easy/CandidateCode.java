package easy;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
public class CandidateCode {

static int jump = 0;
public static int GetJumpCount(int input1,int input2,int[] input3)
    {
		for(int i =0;i<input3.length;i++){
			getWallJump(input1,input2,input3[i]);
		}
		return jump;
    }
	
	public static int getWallJump(int canJ,int canF,int wallH){
		if(canJ >= wallH){
			return jump++;
		}
		else{
			jump++;
			return getWallJump(canJ,canF,wallH-(canJ-canF));
		}
	}
	
	public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(System.in);
        int output = 0;
		System.out.println("Enter the height of Jump:);
        int ip1 = Integer.parseInt(in.nextLine().trim());
	    System.out.println("Enter the height of fall:);
        int ip2 = Integer.parseInt(in.nextLine().trim());
        int ip3_size = 0;
	    System.out.println("Enter the numbers of Walls:);
        ip3_size = Integer.parseInt(in.nextLine().trim());
        int[] ip3 = new int[ip3_size];
        int ip3_item;
        for(int ip3_i = 0; ip3_i < ip3_size; ip3_i++) {
			System.out.println("Enter the height of wall:);
            ip3_item = Integer.parseInt(in.nextLine().trim());
            ip3[ip3_i] = ip3_item;
        }
        output = GetJumpCount(ip1,ip2,ip3);
        System.out.println(String.valueOf(output));
    }
}

