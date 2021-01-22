package Question_Three;

public class ExpressionTest {
	public static void main(String[] args) {
		System.out.println("---------------------------");
		Expression e = new Multiplication(
			new Addition( Double.valueOf(2.5), Double.valueOf(3.5)),
			new UnaryMinus(Integer.valueOf(5)));
		System.out.println("e:" + e.eval()); // should print out -30.0
		System.out.println(e.toString()); // should print out ((2.5 + 3.5) * (-(5)))

		System.out.println("---------------------------");
		Expression e1 = new LeafNumber(Double.valueOf(2.5));
		System.out.println("e1:" + e1.eval());
		System.out.println(e1.toString());

		System.out.println("---------------------------");
		Expression e2 = new LeafNumber(Integer.valueOf(4));
		System.out.println("e2:" + e2.eval());
		System.out.println(e2.toString());

		System.out.println("---------------------------");
		Expression e3 = new Addition(e1, e2);
		System.out.println("e3:" + e3.eval());
		System.out.println(e3.toString());

		System.out.println("---------------------------");
		Expression e4 = new Addition(new Multiplication(e1, e2), e2);
		System.out.println("e4:" + e4.eval());
		System.out.println(e4.toString());

		System.out.println("---------------------------");
		Expression e5 = new Addition(
			new Multiplication(e1, e2), 
			new Division(Integer.valueOf(10), Double.valueOf(2.5)));
		System.out.println("e5:" + e5.eval());
		System.out.println(e5.toString());

		System.out.println("---------------------------");
		Expression e6 = new Subtraction(
			new Multiplication(e1, e2), 
			new Division(Integer.valueOf(10), Double.valueOf(2.5)));
		System.out.println("e6:" + e6.eval());
		System.out.println(e6.toString());

		System.out.println("---------------------------");
		Expression e7 = new Subtraction(
			new UnaryMinus(e1), 
			new Division(Integer.valueOf(10), Double.valueOf(2.5)));
		System.out.println("e7:" + e7.eval());
		System.out.println(e7.toString());

		System.out.println("---------------------------");
		Expression e8 = new Subtraction(e7, new Division(e6, e5));
		System.out.println("e8:" + e8.eval());
		System.out.println(e8.toString());
	}
}