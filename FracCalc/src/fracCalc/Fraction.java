package fracCalc;

public class Fraction {
	private int numerator = 0;//all the values initially put as zero
	private int denominator = 1;//zero cannot be the denominator
	private int whole = 0;
	
	public Fraction(String fraction) {
		parseFrac(fraction);
	}
	public Fraction(int whole, int numerator, int denominator) {
		this.whole = whole;
		this.numerator = numerator;
		this.denominator = denominator;
	}
	private void parseFrac(String frac) {
		if (frac.contains("/") && frac.contains("_")) {
			numerator = (Integer.parseInt(frac.split("_")[1].split("/")[0]));
			denominator = (Integer.parseInt(frac.split("/")[1]));
			whole = (Integer.parseInt(frac.split("_")[0]));
		} else if (frac.contains("/") && !(frac.contains("_"))) {
			numerator = (Integer.parseInt(frac.split("/")[0]));
			denominator = (Integer.parseInt(frac.split("/")[1]));
		} else {
			whole = Integer.parseInt(frac);
		}
	}
	public Fraction calculation(Fraction SecondFrac, String operator) {
		this.toImproperFrac();
		SecondFrac.toImproperFrac();
		Fraction answer;
		if (operator.contains("+")) {
			answer = addition(SecondFrac);
		} else {
			if (operator.contains("-")) {
				answer = subtraction(SecondFrac);
			} else {
				if (operator.contains("*")) {
					answer = multiplication(SecondFrac);
				} else {
					if (operator.contains("/")) {
						answer = division(SecondFrac);
					} else {
						throw new IllegalArgumentException ("Not a correct operator");
					}
				}
			}
		}
		answer.reduce();
		return answer;
	}
	//all of the calculation method gets the second fraction to solve with the first fraction that was stored into the instance variables
	private Fraction addition(Fraction SecondFrac) {
		int num = this.numerator * SecondFrac.denominator + SecondFrac.numerator*this.denominator;
		int denom = this.denominator * SecondFrac.denominator;
		Fraction answer = new Fraction(0, num, denom);
		return answer;
	}
	private Fraction subtraction(Fraction SecondFrac) {
		int num = this.numerator * SecondFrac.denominator - SecondFrac.numerator*this.denominator;
		int denom = this.denominator * SecondFrac.denominator;
		Fraction answer = new Fraction(0, num, denom);
		return answer;
	}
	private Fraction multiplication(Fraction SecondFrac) {
		int num = this.numerator * SecondFrac.numerator;
		int denom = this.denominator * SecondFrac.denominator;
		Fraction answer = new Fraction(0, num, denom);
		return answer;
	}
	private Fraction division(Fraction SecondFrac) {
		int num = this.numerator * SecondFrac.denominator;
		int denom = this.denominator * SecondFrac.numerator;
		Fraction answer = new Fraction(0, num, denom);
		return answer;
	}
	private void toImproperFrac() {
		if (this.whole>=0) {
			this.numerator = whole * denominator + numerator;
		} else {
			this.numerator = whole * denominator - numerator;
		}
		this.whole = 0;
	}
	private void reduce() {
		if (denominator<0) {
			denominator *= -1;
			numerator *= -1;
		}
		whole = numerator/denominator;
		numerator = numerator%denominator;
		if (numerator<0 && whole!=0) {
			numerator *= -1;
		}
		int gcf = gcf(numerator, denominator);
		numerator /= gcf;
		denominator /= gcf;
    }
	public String toString() {
		if (this.numerator==0) {
			return ""+ whole;
		} 
		if (this.whole==0) {
			return "" + numerator + "/" + denominator;
		}
		return "" + whole +"_" + numerator + "/" + denominator;
	}
  //Calculates the greatest common factor of two integers
    public static int gcf(int numerator, int denominator) {
    	int gcf = 1; // Set the initial value of gcf to 1, which is the lowest possible gcf
		int count; // Set it to whichever number is larger.
    	if (numerator==denominator || numerator>denominator ) {
    		count = denominator;
    	} else {
    		count = numerator;
    	}
    	if (count<0) {
    		count *= -1;
    	}
		for(int i = 2; i <= count; i++) {
			if(numerator%i == 0 && denominator%i == 0) {
				gcf = i;
			}
		}
		return gcf;
    }
}