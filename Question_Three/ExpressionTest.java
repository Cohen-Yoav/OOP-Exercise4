package Question_Three;

public class ExpressionTest {
	public static void main(String[] args) {
		Expression e = new Multiplication(new Addition(new Double(2.5),
			new Double(3.5)), new UnaryMinus(new Integer(5))); 
		System.out.println(e.eval());  // should print out -30.0 
		System.out.println(e.toString());  // should print out ((2.5 + 3.5) * (-(5)))
		
		Expression e1 = new Subtraction(new Addition(new Double(2.5),
				new Double(3.5)), new UnaryMinus(new Integer(5))); 
			System.out.println(e1.eval());  // should print out 11.0 
			System.out.println(e1.toString());  // should print out ((2.5 + 3.5) - (-(5)))
			
		Expression e2 = new Division(new UnaryMinus(new Addition(new Double(2.5),
				new Double(3.5))), new UnaryMinus(new Integer(5))); 
			System.out.println(e2.eval());  // should print out 1.2 
			System.out.println(e2.toString());  // should print out ((-((2.5 + 3.5))) / (-(5)))
	}
}