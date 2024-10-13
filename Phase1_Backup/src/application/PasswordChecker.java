package application;

/**
 * Default Constructor
 */
public class PasswordChecker {

	/**
	 * Initialize variables used 
	 */
	
	
	/**
	 * Initializes includesUppercase which is used to determine whether or not the input includes an upper case character
	 */
	public static boolean includesUppercase = false;
	
	/**
	 * Initializes includesLowercase which is used to determine whether or not the input includes an lower case character
	 */
	public static boolean includesLowercase = false;	
	
	/**
	 * Initializes includesNum which is used to determine whether or not the input includes a numerical value
	 */
	public static boolean includesNum = false;			
	
	/**
	 * Initializes includesSpecialchar which is used to determine whether or not the input includes a special character
	 */
	public static boolean includesSpecialchar = false;
	
	/**
	 * Initializes sufficientLength which is used to determine whether or not the input is of sufficient length
	 */
	public static boolean sufficientLength = false;
	
	/**
	 * Initializes currentChar which is used to iterate through the input
	 */
	private static char currentChar;
	
	/**
	 * Initializes running which is used to determine when the while loop stops
	 */
	private static boolean running;
	
	/**
	 * Initializes index which is used to iterate through the input
	 */
	private static int index;
	
	/**
	 * Input goes through this method and it determines whether or not the password is valid or not
	 * @param input is the password that is entered
	 * @return returns a string based on the input given
	 */
	public static String checkPassword(String input) {
		index = 0;

		if(input.length() <= 0) {
			return "The password is empty! Please enter password.";
		}
		
		currentChar = input.charAt(0);			// currentChar is the first char in the input

		includesUppercase = false;
		includesLowercase = false;	
		includesNum = false;
		includesSpecialchar = false;
		sufficientLength = false;
		running = true;

		/**
		 * iterates through the password and determines the characteristics of the password
		 */
		while (running) {
            System.out.println("Current character: '" + currentChar + "' (Index: " + index + ")");
            if (currentChar >= 'A' && currentChar <= 'Z') {
                System.out.println("Upper case letter found");
                includesUppercase = true;
            } 
            else if (currentChar >= 'a' && currentChar <= 'z') {
                System.out.println("Lower case letter found");
                includesLowercase = true;
            } 
            else if (currentChar >= '0' && currentChar <= '9') {
                System.out.println("Digit found");
                includesNum = true;
            } 
            else if ("~`!@#$%^&*()_-+={}[]|\\:;\"'<>,.?/".indexOf(currentChar) >= 0) {
                System.out.println("Special character found");
                includesSpecialchar = true;
            } 
            else {
                System.out.println("*** Error *** An invalid character has been found!");
                return "*** Error *** An invalid character has been found!";
            }

            if (index >= 7) {
                System.out.println("At least 8 characters found");
                sufficientLength = true;
            }
			
            index++;
            if (index >= input.length()) {
                running = false;
            }
            else {
                currentChar = input.charAt(index);
            }
            System.out.println();
        }
		
		String errMessage = "";
		if (!includesUppercase)
			errMessage += "Upper case; ";
		
		if (!includesLowercase)
			errMessage += "Lower case; ";
		
		if (!includesNum)
			errMessage += "Numeric digits; ";
			
		if (!includesSpecialchar)
			errMessage += "Special character; ";
			
		if (!sufficientLength)
			errMessage += "Long Enough; ";
		
		if (errMessage == "")
			return "";
	
		return errMessage + "conditions were not satisfied";
	}
}
