package fracCalc;

import java.util.Scanner;

public class FracCalc {
	static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        // TODO: Read the input from the user and call produceAnswer with an equation
    	while (!input.equals("quit")) {
    		System.out.println("Type in the calculation (Type \"quit\" to end)");
    		String expression = input.nextLine();
    		if (!expression.toLowerCase().contains("quit")) {
    			System.out.println(produceAnswer(expression));
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
    public static String produceAnswer(String input)
    {
        // TODO: Implement this function to produce the solution to the input
    	//separates the string into fraction1, fraction2, operator
    	String fraction1 = input.substring(0, input.indexOf(" "));
        String operator = input.substring((input.indexOf(" ")), (input.indexOf(" ")+ 3));
        String fraction2 = input.substring(input.lastIndexOf(" ") + 1);
        int[] frac1 = Fraction(fraction1);
        int[] frac2 = parseFrac(fraction2);
        //store the final calculated fraction into the variable named result
    	int[] result = new int [3];
    	//does the calculation based on the types of the operators: +, -, *, /
    	result = Fraction.Calculation(frac1,frac2,operator);
    	result = reduceFrac(result);//reduce
    	return fracForm(result);
        return "";
    }

    // TODO: Fill in the space below with any helper methods that you think you will need
    
}
