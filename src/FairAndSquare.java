import java.math.BigInteger;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;


public class FairAndSquare {
	
	private static Scanner s;
	private static ArrayList<Long> l = new ArrayList<Long>();
	
	private static void process(int caseNum)
	{
		long min = s.nextLong();
		long max = s.nextLong();
		
		int count = 0;
		
		for(long x : l)
		{
			if(x > max)
			{
				break;
			}
			if(x >= min)
			{
				count++;
			}
			
		}
		
		printOutput(caseNum, count);
	}
	
	private static void findFairAndSquares(long upTo)
	{
		long start = System.currentTimeMillis();
		System.out.println("Starting");
		for(long i = 1; upTo != i ; i++ )
		{
			if(isPalindrome(Long.toString(i)))
			{
				long x = i*i;
				if(isPalindrome(Long.toString(x)))
				{
					l.add(x);
					System.out.println(i + " " + x);
				}
			}			
		}
		System.out.println(l.size() +" took " + (System.currentTimeMillis() - start) );
	}
	
	private static boolean isPalindrome(String s)
	{
		int iterator = 0;
		while(iterator < s.length() / 2)
		{
			if(s.charAt(iterator) != s.charAt(s.length() - iterator - 1))
			{
				return false;
			}
			++iterator;
		}
		
		return true;
	}
	
	
	public static void printOutput(int caseNum, int count)
	{
		System.out.println("Case #"+caseNum+": "+count);
		
	}
	
	public static void main(String args[])
	{
		
		findFairAndSquares(Long.parseLong("10000000000"));
		
		s = new Scanner(System.in);
		int count = s.nextInt();

		for(int i = 1; i <= count; i ++)
		{		
			s.nextLine();
			process(i);
			
		}
		
	}
}
