import java.util.Scanner;


public class Lawnmower {
	
	private static Scanner s;
	
	private static void process(int caseNum)
	{
		int n = s.nextInt();
		int m = s.nextInt();
		s.nextLine();

		int grid[][] = new int[n][m];
		int desiredGrid[][] = new int[n][m];
		
		int highestHeight = 0;
		
		
		for(int i = 0; i < n; i ++)
		{
			
			for(int j = 0; j < m; j ++)
			{
				desiredGrid[i][j] = s.nextInt();
				if(desiredGrid[i][j] > highestHeight)
				{
					highestHeight = desiredGrid[i][j];
				}
			}
			
			if(s.hasNext())
			{
		
				s.nextLine();
			}
		}
		

		if(n < 2 || m < 2)
		{
			
			printOutput(caseNum, true);
			return;
		}
		
		for(int i = 0; i < n; i ++)
		{
			for(int j = 0; j < m; j ++)
			{
				grid[i][j] = highestHeight;				
			}					
		}
		
		
		//trim from top edge
		for(int col = 0; col < n; col ++)
		{
			int firstHeight = desiredGrid[col][0];
			boolean trim = true;
			for(int row = 1 ; row < m; row++)
			{
				if(desiredGrid[col][row] > firstHeight)
				{
					trim = false;
				}
			}
			if(trim)
			{
				cutColumn( col,  firstHeight, grid );
			}
		}

		
		
		//trim from left edge
		for(int row = 0; row < m; row ++)
		{
			int firstHeight = desiredGrid[0][row];
			boolean trim = true;
			for(int col = 1 ; col < n; col++)
			{
				if(desiredGrid[col][row] > firstHeight)
				{
					trim = false;
				}
			}
			if(trim)
			{
				cutRow( row,  firstHeight, grid );
			}
		}

		
		
		printOutput(caseNum, compareGrids(desiredGrid, grid));
	}
	
	private static boolean compareGrids(int[][] a, int[][] b)
	{
		for(int i = 0; i < a.length; i ++)
		{
			for(int j = 0; j < a[i].length; j ++)
			{
				if(a[i][j] != b[i][j])
				{
					return false;				
				}
			}					
		}
		return true;
	}
	
	private static void cutRow(int row, int height, int grid[][])
	{
		for(int i = 0; i < grid.length; i++)
		{
			for(int j = 0; j < grid[i].length; j++)
			{
				if(j == row && grid[i][j] > height)
				{
					grid[i][j] = height;
				}				
			}
		}
	}
	
	private static void cutColumn(int column, int height, int grid[][])
	{
		for(int i = 0; i < grid.length; i++)
		{
			for(int j = 0; j < grid[i].length; j++)
			{
				if(i == column)
				{
					grid[i][j] = height;
				}				
			}
		}
	}
	
	
	public static void printOutput(int caseNum, boolean yes)
	{
		System.out.print("Case #"+caseNum+": ");
		if(yes) 
		{
			System.out.println("YES");
		}
		else
		{
			System.out.println("NO");
		}
		
	}
	
	public static void main(String args[])
	{
		s = new Scanner(System.in);
		int count = s.nextInt();
		s.nextLine();
		
		for(int i = 1; i <= count; i ++)
		{			
			process(i);
			
		}
		
	}
}
