import java.util.Scanner;

public class YoungestPerson 
{
	public static void main(String [] args)
	{
		String [] namesArray = new String[4];
		int [] agesArray = new int[4];
		int index =0;
		String name;
		
		Scanner sc = new Scanner(System.in);
		for(int i =0;i<namesArray.length;i++)
		{
			
			System.out.print("Enter name of person #"+(i+1)+":");
			namesArray[i] = sc.next();
			System.out.print("Enter age  of person #"+(i+1)+":");
			agesArray[i] = sc.nextInt();
		}
		
		int minVal = agesArray[0];
		for(int i =1;i<agesArray.length;i++)
		{
			if(agesArray[i] < minVal)
			{
				minVal = agesArray[i];
				index =i;
			}
			
		}
		System.out.println("Youngest person is "+minVal+" and their name is "+namesArray[index]);
		
	}

}
