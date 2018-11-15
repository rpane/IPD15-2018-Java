import java.util.Random;
import java.util.Scanner;

public class Lottery {
	
	public static void main(String [] args) 
	{
		Random rnd = new Random();
		int lotto = rnd.nextInt(100);
		
		Scanner reader = new Scanner(System.in);
		System.out.println("Please enter your lottery number that is two digits");
		int pick = reader.nextInt();
		
		int lottoNum1 = lotto /10;
		int lottoNum2 = lotto %10;
		System.out.println("The winning number is "+ lotto);
		
		int guessNum1 = pick /10;
		int guessNum2 = pick %10;
		
		if(pick == lotto) {
			System.out.println("Perfect Order: You Won $10 000");
		}else if(guessNum2 == lottoNum1 && guessNum1 == lottoNum2) {
			System.out.println("Matching Digits: You won $3000");
		}else if(guessNum1 == lottoNum1 || guessNum1 == lottoNum2 || guessNum2 == lottoNum1 || guessNum2 == lottoNum2)
		{
			System.out.println("1 Match has been found: You win $1000");			
		}else {
			System.out.println("Non matching, sorry. Please play again");
		}
	}

}
