import java.util.Scanner;

public class RobertoHexDec 
{
	public static void main(String [] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the Hex value you wish to be converted into decimal");
		String hexStr = sc.nextLine();
		int decimalVal;
		
		char chVal = hexStr.toUpperCase().charAt(0);
		if(Character.isDigit(chVal)) 
		{
			System.out.println("Decimal equivalent for "+chVal+" is "+chVal);
		}
		else if(chVal >= 'A' && chVal <= 'F'){
			decimalVal = chVal + 10 - 'A';			
			System.out.println("Decimal equivalent for "+chVal+" is "+decimalVal);
		}else {
			System.out.println(chVal+" Invalid input");
		}
		
	}

}
