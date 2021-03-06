package fracCalc;

import java.util.Scanner;

/*This class is client code that uses the Fraction to perform various fraction calculation.
 * @author Alex Lee
 * @versions January 22, 2019
 */

public class FracCalc {
	static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        // TODO: Read the input from the user and call produceAnswer with an equation
    	boolean done = false;
    	while (!done) {
    		System.out.println("Type in the calculation (Type \"quit\" to end)");
    		String expression = input.nextLine();
    		if (!expression.toLowerCase().contains("quit")) {
    			System.out.println(produceAnswer(expression));
    		} else {
    			done = true;
    		}
    	}
    }
    // ** IMPORTANT ** DO NOT DELETE THIS FUNCTION.  This function will be used to test your code
    // This function takes a String 'input' and produces the result
    //
    // input is a fraction string that needs to be evaluated.  For your program, this will be the user input.
    //      e.g. input ==> "1/2 + 3/4"
    //        
    // The function should return the result of the fraction after it has been calculated
    //      e.g. return ==> "1_1/4"
    public static String produceAnswer(String input) {
        // TODO: Implement this function to produce the solution to the input
    	//separates the string into fraction1, fraction2, operator
    	String[] parsedInput = input.split(" ");
		if (parsedInput.length%2==0||parsedInput.length==1) {
			return "ERROR: Invalid expression. Please try again.";
		}
		Fraction fraction1 = new Fraction(parsedInput[0]);
		Fraction fraction2 = new Fraction(parsedInput[2]);
		String operator = parsedInput[1];
		Fraction answer = fraction1.calculation(fraction2, operator);
		String result = answer.toString();
		return result;
	}
    // TODO: Fill in the space below with any helper methods that you think you will need 
}