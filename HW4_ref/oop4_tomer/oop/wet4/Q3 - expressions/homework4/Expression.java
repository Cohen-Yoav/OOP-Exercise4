package homework4;
/**
 * an Expression is an abstraction of an arithmetic element.
 * each Expression can show the expression value(eval), and the current string
 *  of the expression.
 */
// Abstraction Function:
    // an arithmetic element e, such that
    // e.eval() = returns the value of the expression.
    // e.toString() = returns the string that represent all the arithmetic calculations. 
    //
    // Representation Invariant:
    // (e.eval() != null) &&
    // (e.toString() != null)
 
//abstract class of an Expression element 
abstract class Expression {
	public abstract Number eval();
	public abstract String toString();
	public void checkrep()
    {
        assert eval() != null:
            "The number is null";
        assert toString ()!= null:
            "The string is null ";
                 
    }
}

//the leaf of the composite, the Expression element  holds a single number.
class RegularNumber extends Expression {
	protected Number _number;
	public RegularNumber(Number number){
		_number = number;
		checkrep();
	}
	
	/**
   * Returns the value of the number.
   * @return the value of the number
   **/
	@Override
	public Number eval() {
		return _number;
	}

	/**
   * Returns the string of the number.
   * @return the string of the number
   **/
	@Override
	public String toString() {
		return _number.toString();
	}
	
}
//Multiplication between two ExpressionElements
class Multiplication extends Expression {
	protected Expression _left;
	protected Expression _right;
	
	/**
     * calc the value of Multiplication between two Expressions
     * @return the value of Multiplication between two Expressions
     **/
	public Number eval() {
		return _right.eval().doubleValue()*_left.eval().doubleValue();
	}
	
	/**
     * Returns the String of Multiplication between two Expressions
     * @return the String of Multiplication between two Expressions
     **/
	public String toString(){
		return ("(" + _right.toString() + " * " +  _left.toString() + ")");
	}
	
	public Multiplication(Expression e1, Expression e2){
		_left =  e2;
		_right = e1;
		checkrep();
	}
	
	public Multiplication(Number e1, Expression e2){
		_left =  e2;
		_right = new RegularNumber(e1);
		checkrep();
	}
	public Multiplication(Number e1, Number e2){
		_left =  new RegularNumber(e2);
		_right = new RegularNumber(e1);
		checkrep();
	}
	public Multiplication(Expression e1, Number e2){
		_left =  new RegularNumber(e2);
		_right = e1;
		checkrep();
	}
}

//calcs addition between to expressions.
class Addition extends Expression {
	protected Expression _left;
	protected Expression _right;
	
	/**
     * calc the value of addition between two Expressions
     * @return the value of addition between two Expressions
     **/
	public Number eval() {
		return _right.eval().doubleValue()+_left.eval().doubleValue();
	}
	
	/**
     * Returns the String of Addition between two Expressions
     * @return the String of Addition between two Expressions
     **/
	public String toString(){
		return ("(" + _right.toString() + " + " +  _left.toString() + ")");
	}
	
	public Addition(Expression e1, Expression e2){
		_left =  e2;
		_right = e1;
		checkrep();
	}
	
	public Addition(Number e1, Expression e2){
		_left =  e2;
		_right = new RegularNumber(e1);
		checkrep();
	}
	public Addition(Number e1, Number e2){
		_left =  new RegularNumber(e2);
		_right = new RegularNumber(e1);
		checkrep();
	}
	public Addition(Expression e1, Number e2){
		_left =  new RegularNumber(e2);
		_right = e1;
		checkrep();
	}
}

//calcs Subtraction between to expressions.
class Subtraction extends Expression {
	protected Expression _left;
	protected Expression _right;
	
	/**
   * calc the value of Subtraction between two Expressions
   * @return the value of Subtraction between two Expressions
   **/
	public Number eval() {
		return _right.eval().doubleValue()-_left.eval().doubleValue();
	}
	
	/**
   * Returns the String of Subtraction between two Expressions
   * @return the String of Subtraction between two Expressions
   **/
	public String toString(){
		return ("(" + _right.toString() + " - " +  _left.toString() + ")");
	}
	
	public Subtraction(Expression e1, Expression e2){
		_left =  e2;
		_right = e1;
		checkrep();
	}
	
	public Subtraction(Number e1, Expression e2){
		_left =  e2;
		_right = new RegularNumber(e1);
		checkrep();
	}
	public Subtraction(Number e1, Number e2){
		_left =  new RegularNumber(e2);
		_right = new RegularNumber(e1);
		checkrep();
	}
	public Subtraction(Expression e1, Number e2){
		_left =  new RegularNumber(e2);
		_right = e1;
		checkrep();
	}
}

//calcs Devision between to expressions.
class Devision extends Expression {
	protected Expression _left;
	protected Expression _right;
	
	/**
 * calc the value of Devision between two Expressions
 * @return the value of Devision between two Expressions
 **/
	public Number eval() {
		return _right.eval().doubleValue() / _left.eval().doubleValue();
	}
	
	/**
 * Returns the String of Devision between two Expressions
 * @return the String of Devision between two Expressions
 **/
	public String toString(){
		return ("(" + _right.toString() + " / " +  _left.toString() + ")");
	}
	
	public Devision(Expression e1, Expression e2){
		_left =  e2;
		_right = e1;
		checkrep();
	}
	
	public Devision(Number e1, Expression e2){
		_left =  e2;
		_right = new RegularNumber(e1);
		checkrep();
	}
	public Devision(Number e1, Number e2){
		_left =  new RegularNumber(e2);
		_right = new RegularNumber(e1);
		checkrep();
	}
	public Devision(Expression e1, Number e2){
		_left =  new RegularNumber(e2);
		_right = e1;
		checkrep();
	}
}

//calcs UnaryMinus of expression.
class UnaryMinus extends Expression {
	protected Expression _e;
	
	/**
* calc the value of UnaryMinus Expression
* @return the value of UnaryMinus Expression
**/
	public Number eval() {
		return (- _e.eval().doubleValue());
	}
	
	/**
* Returns the String of UnaryMinus Expression
* @return the String of UnaryMinus Expression
**/
	public String toString(){
		return ("(-(" +  _e.toString() + "))");
	}
	
	public UnaryMinus(Expression e){
		_e =  e;
		checkrep();
	}
	
	public UnaryMinus(Number e){
		_e = new RegularNumber(e);
		checkrep();
	}
}

