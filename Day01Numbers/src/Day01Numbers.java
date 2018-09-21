import java.util.Random;
import java.util.Scanner;

public class Day01Numbers 
{
	static Scanner sc = new Scanner(System.in);
	static Random r = new Random();
	public static void main(String args[])
	{
		int[] a1 = {1,5,9,4,7,8};
		int[] a2 = {5,6,8,4,6,3};
		int[] a3 = {1,9};
		//NumBetween();
		//printDups(a1,a2);
		//removeDups(a1,a3);
		concatenate(a2,a3);
	}
	
	public static void NumBetween()
	{
		float[] numBet = new float[5];
		int max, min;
	
		System.out.println("Enter a Min");
		min= sc.nextInt();
		System.out.println("Enter a Max");
		max = sc.nextInt();
		
		if(max <min) 
		{
			System.out.println("Error: Max is less than Min");
			System.exit(0);
		}
		for(int i =0;i<numBet.length;i++)
		{
			float rndm = min + r.nextFloat() * (max-min);
			numBet[i] = rndm;
			if(i ==4)
			System.out.printf("%.2f ",numBet[i]);
			else
				System.out.printf("%.2f, ",numBet[i]);
		}
	
	}
	public static void printDups(int[] x, int[] y)
	{
		for(int i=0;i<x.length;i++)
		{
			for(int j=0;j<y.length;j++)
			{
				if(y[j]==x[i])
					System.out.println(y[j]);
			}
		}
	}
	public static int[] removeDups(int[] x, int[] y) 
	{
		boolean flag;
		int count =0;
		for(int i=0;i<x.length;i++)
		{
			for(int j=0;j<y.length;j++)
			{
				if(y[j]==x[i])
					count++;
			}
		}
		int [] copy= new int[x.length-count];
		int notDup =0;
		for(int i=0;i<x.length;i++)
		{
			flag = true;
			for(int j=0;j<y.length;j++)
			{
				if(x[i]==y[j])
				{
					flag = false;
					notDup--;
				}
					
			}
			if(flag)
				copy[notDup] = x[i];
			notDup++;
		}
		
		for(int val: copy)
			System.out.println(val);
		
		return copy;
		
	}
	public static int[] concatenate(int[] a1, int[] a2)
	{
		int size = a1.length+a2.length;
		int [] full = new int [size];
		int pos =0;
		for(int val: a1)
		{
			full[pos] = val;
			pos++;
		}
		for(int val: a2)
		{
			full[pos] = val;
			pos++;
		}
		
		
		for(int val: full)
			System.out.printf("%d ", val);
		
		return full;
	}
}
