import java.util.Scanner;

public class HexConversionApp {
	
	
	/**
	 * Main method prompts for number of the number of Hex numbers to convert
	 * then iterates through converting and printing values entered
	 */
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter number of Hex numbers to convert to decimal: ");
		int size = scanner.nextInt();
		scanner.nextLine();
		String hexString;
		int decNum;
		for(int i = 0; i < size; i++) {
			System.out.println("Enter in a Hexadecimal number");
			hexString = scanner.nextLine();
			decNum = hex2Dec(hexString);
			System.out.println("Hex Value: " + hexString);
			System.out.println("Decimal value: " + decNum + "\n");
		}
		
		System.out.println("Thanks hope you enjoyed!");
		scanner.close();
		System.exit(0);
	}
	
	public static int hex2Dec(String hexString) {
		char[] hexVals = {'A', 'B', 'C', 'D', 'E', 'F'}; //set hex values
		int[] decVals = {10, 11, 12, 13, 14, 15};
		String capHexString = hexString.toUpperCase(); 
		int decNum, temp;
		//base case is have a string of size one so there is only hex value to convert
		if(capHexString.length() == 1) {
			//compares the lone hex number to see if it is 10-15 because we must take the
			//extra step to convert
			for(int i = 0; i < hexVals.length; i++) {
				if(capHexString.charAt(0) == hexVals[i]) {
					temp = decVals[i];
					//X * (BaseNum)^(number system position - 1)
					decNum = (int)(temp * Math.pow(16, (capHexString.length()-1)));
					//return the value so following statements don't execute
					return decNum;
				}
			}
			//if not 10-15 it'll be 1-9 so just get the numeric value of character entered
			temp = Character.getNumericValue(capHexString.charAt(0));
			decNum = (int)(temp * Math.pow(16, (capHexString.length()-1)));
			return decNum;
		}
		
		//recursive call sends substring, will continue to execute until string with size of 1
		//is found
		decNum = hex2Dec(hexString.substring(1));
		
		
		//following statements use same logic and add the value of next hex value to the 
		//dec value which was returned by previous recursive iteration of hex2Dec
		for(int i = 0; i < hexVals.length; i++) {
			if(capHexString.charAt(0) == hexVals[i]) {
				temp = decVals[i];
				decNum += (int)(temp * Math.pow(16, (capHexString.length()-1)));
				return decNum;
			}
		}
		temp = Character.getNumericValue(capHexString.charAt(0));
		decNum += (int)(temp * Math.pow(16, (capHexString.length()-1)));
		
		return decNum;
	}

}
