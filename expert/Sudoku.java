package expert;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
public class Sudoku {
	static final int UNASSIGNED = 0;
	static int row, col;
	public static int SolveMagicSquare(int[][] grid)
		{
			int n = (int)Math.sqrt(grid.length);
			if(SolveSudoku(grid)){
				if(grid[0][0] != 1){
					return 0;
				}
				printGrid(grid);
				return 1;
			}
			return 0;
		}

	static boolean SolveSudoku(int grid[][]){
		int size = grid.length;
		if (!FindUnassignedLocation(grid, row, col))
		   return true;

		else{
			
			if(row==0){
				for (int num = 1; num <=size; num++)
				{
					if (isSafe(grid, row, col, num))
					{
						// make tentative assignment
						grid[row][col] = num;
						// return, if success, yay!
						if (SolveSudoku(grid))
							return true;

						// failure, unmake & try again
						grid[row][col] = UNASSIGNED;
					}
				}
			}
			
			else{
				int iterate = (int)Math.sqrt(size);
				int g = 1;
				while(g <= iterate){
					if(col >= size - iterate && col < size){
						if(checkForNum(grid,0)){
							if(SolveSudoku(grid))
								return true;
						}
						return false;
					}
					if(col < iterate * g){
					
						if(checkForNum(grid,iterate * g)){
							if(SolveSudoku(grid))
								return true;
						}
						return false;
					}
					g++;
				}	
			}
		
			
		}
		return false; // this triggers backtracking
	}
	
	static boolean checkForNum(int [][]grid,int startCol){
		int newCol = startCol;
		int part = (int)Math.sqrt(grid.length);
		for(int k=startCol;k < startCol+part;k++){
			if(row % part == 0)
				newCol = (k==(startCol+part-1))?startCol:(k+1);
			else
				newCol = k;
			if(isSafe(grid, row,col,grid[row-1][newCol])){
				grid[row][col] = grid[row-1][newCol];
				return true;
			}
		}
		return false;
	}
	
	static boolean FindUnassignedLocation(int grid[][], int row, int col)
	{
		for (row = 0; row < grid.length; row++)
			for (col = 0; col < grid.length; col++)
				if (grid[row][col] == UNASSIGNED){
					Sudoku.row = row;
					Sudoku.col = col;
					return true;
				}
		return false;
	}
	
	static boolean UsedInRow(int grid[][], int row, int num)
	{
		for (int col = 0; col < grid.length; col++)
			if (grid[row][col] == num)
				return true;
		return false;
	}
	
	static boolean UsedInCol(int grid[][], int col, int num)
	{
		for (int row = 0; row < grid.length; row++)
			if (grid[row][col] == num){
				return true;
			}
		return false;
	}
	
	static boolean UsedInBox(int grid[][], int boxStartRow, int boxStartCol, int num)
	{
		for (int row = 0; row < Math.sqrt(grid.length); row++)
			for (int col = 0; col < Math.sqrt(grid.length); col++)
				if (grid[row+boxStartRow][col+boxStartCol] == num)
					return true;
		return false;
	}
	
	static boolean isSafe(int grid[][], int row, int col, int num)
	{
		/* Check if 'num' is not already placed in current row,
		   current column and current sub-matrix */
		return !UsedInRow(grid, row, num) &&
			   !UsedInCol(grid, col, num) &&
			   !UsedInBox(grid, row - (int)(row%(int)Math.sqrt(grid.length)), col - (int)(col%(int)Math.sqrt(grid.length)), num);
	}
	
	/* A utility function to print grid  */
	static void printGrid(int grid[][])
	{
		int N = grid.length;
	    for (int row = 0; row < N; row++)
	    {
	       for (int col = 0; col < N; col++)
	             System.out.printf("%4d", grid[row][col]);
	       System.out.printf("\n");
	    }
	}

	
 public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(System.in);
        int output = 0;
        int ip1_rows = 0;
        int ip1_cols = 0;
	 
	 //Uncomment below lines if you want to enter matrix from terminal.
//      ip1_rows = Integer.parseInt(in.nextLine().trim());
//		ip1_cols = Integer.parseInt(in.nextLine().trim());
//      int[][] ip1 = new int[ip1_rows][ip1_cols];

//        for(int ip1_i=0; ip1_i<ip1_rows; ip1_i++) {
//            for(int ip1_j=0; ip1_j<ip1_cols; ip1_j++) {
//                ip1[ip1_i][ip1_j] = in.nextInt();
//                
//            }
//        }
	 // You can give matrix of  a² * a², where 1=<a<=20 
	 int [][] ip1 = {{0, 0,0, 0},
             {0, 0, 1, 0},
             {0, 1, 0, 0},
             {4, 0, 0, 0}};
        output = SolveMagicSquare(ip1);
        System.out.println(String.valueOf(output));
    }
}
