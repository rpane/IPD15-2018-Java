import java.util.Scanner;

public class RobertoHexToDec {
	public static void main(String [] args) 
	{		
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter a hexedecimal digit");
		String hexDig = sc.nextLine();
		
		int decVal;
		
		char ch = hexDig.toUpperCase().charAt(0);
		if(ch >= 'A' && ch <= 'F'){
			decVal = ch + 10 - 'A';			
			System.out.println("Decimal equivalent for "+ch+" is "+decVal);
		}
		else if(Character.isDigit(ch)){
			System.out.println("Decimal equivalent for "+ch+" is "+ch);
		}
		else{
			System.out.println(ch+" Invalid input");
		}
	}

}
