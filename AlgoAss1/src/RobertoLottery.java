import java.util.Random;
import java.util.Scanner;

public class RobertoLottery {
	
	public static void main(String [] args) 
	{	
		Scanner reader = new Scanner(System.in);
		System.out.println("Please enter your lottery number that is two digits");
		int pick = reader.nextInt();
		
		Random rnd = new Random();
		int draw = rnd.nextInt(100);		
		System.out.println("The winning number is "+ draw);
		
		int drawNum1 = draw /10;
		int drawNum2 = draw %10;		
		
		int pickNum1 = pick /10;
		int pickNum2 = pick %10;
		
		if(pick == draw) 
		{
			System.out.println("You Won the Grand Prize $10 000");
		}
		else if(pickNum2 == drawNum1 && pickNum1 == drawNum2) 
		{
			System.out.println("You won $3000 for mathing the numbers not in the correct order");
		}
		else if(pickNum1 == drawNum1 || pickNum1 == drawNum2 || pickNum2 == drawNum1 || pickNum2 == drawNum2)
		{
			System.out.println("You won $1000 for matching one numeber");			
		}
		else 
		{
			System.out.println("Non matching, sorry. Please play again");
		}
	}

}
