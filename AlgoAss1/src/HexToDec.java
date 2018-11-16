import java.util.Scanner;

public class HexToDec {
	public static void main(String [] args) {
		
		Scanner reader = new Scanner(System.in);
		System.out.println("Please enter a hexedecimal digit");
		String hexDig = reader.nextLine();
		int decVal;
		
		char ch = hexDig.toUpperCase().charAt(0);
		if(ch >= 'A' && ch <= 'F') {
			decVal = ch - 'A' +10;			
			System.out.println("Decimal Value for Hex Degit "+ch+" is "+decVal);
		}else if(Character.isDigit(ch)) {
			System.out.println("Decimal Value for "+ch+" is "+ch);
		}else {
			System.out.println(ch+" Invalid input");
		}
	}

}
