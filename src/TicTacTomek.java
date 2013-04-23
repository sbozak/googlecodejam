import java.util.Scanner;


public class TicTacTomek {
	
	private static Scanner s;
	
	private static void process(int caseNum)
	{
		boolean hasEmptySpots = false;
		
		String[] grid = new String[4];
		grid[0] = s.nextLine();
		grid[1] = s.nextLine();
		grid[2] = s.nextLine();
		grid[3] = s.nextLine();
		
		boolean[][] xGrid = new boolean[4][4];
		boolean[][] oGrid = new boolean[4][4];
		
		for(int i = 0 ; i < grid.length; i++)
		{
			for(int j = 0 ; j < grid[i].length(); j++)
			{
				if(grid[i].charAt(j) == 'X' || grid[i].charAt(j) == 'T')
				{
					xGrid[i][j] = true;
				}
				if(grid[i].charAt(j) == 'O' || grid[i].charAt(j) == 'T')
				{
					oGrid[i][j] = true;
				}
				if(grid[i].charAt(j) == '.')
				{
					hasEmptySpots = true;
				}				
			}
		}
		
		
		//check horizontal
		for(int i = 0 ; i < xGrid.length; i++)
		{
			int xCount = 0;
			int oCount = 0;
			for(int j = 0 ; j < xGrid[i].length; j++)
			{
				if(xGrid[i][j])
				{
					xCount++;
				}
				if(oGrid[i][j])
				{
					oCount++;
				}
			}
			if(xCount == 4)
			{				
				printOutput(caseNum, 0);
				return;
			}
			if(oCount == 4)
			{
				printOutput(caseNum, 1);
				return;
			}
		}
		
		//check vertical
		for(int i = 0 ; i < 4; i++)
		{
			int xCount = 0;
			int oCount = 0;
			for(int j = 0 ; j < 4; j++)
			{
				if(xGrid[j][i])
				{
					xCount++;
				}
				if(oGrid[j][i])
				{
					oCount++;
				}
			}
			if(xCount == 4)
			{				
				printOutput(caseNum, 0);
				return;
			}
			if(oCount == 4)
			{
				printOutput(caseNum, 1);
				return;
			}
		}
		
		//check diag
		if((xGrid[0][0] && xGrid[1][1] && xGrid[2][2] && xGrid[3][3]) || 
				(xGrid[0][3] && xGrid[1][2] && xGrid[2][1] && xGrid[3][0]))
		{
			printOutput(caseNum, 0);
			return;
		}
		if((oGrid[0][0] && oGrid[1][1] && oGrid[2][2] && oGrid[3][3]) || 
				(oGrid[0][3] && oGrid[1][2] && oGrid[2][1] && oGrid[3][0]))
		{
			printOutput(caseNum, 1);
			return;
		}
		

		if(hasEmptySpots)
		{
			printOutput(caseNum, 3);
			
		}
		else
		{
			printOutput(caseNum, 2);
		}
	}
	
	
	public static void printOutput(int caseNum, int status)
	{
		System.out.print("Case #"+caseNum+": ");
		if(status == 0) //x won
		{
			System.out.println("X won");
		}
		else if(status == 1) //o won
		{
			System.out.println("O won");
		}
		else if(status == 2) //Draw
		{
			System.out.println("Draw");
		}
		else
		{
			System.out.println("Game has not completed");
		}
		
	}
	
	public static void main(String args[])
	{
		s = new Scanner(System.in);
		int count = s.nextInt();
		
		
		for(int i = 1; i <= count; i ++)
		{
			s.nextLine();
			process(i);
			
		}
		
	}
}
