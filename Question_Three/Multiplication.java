package Question_Three;

public class Multiplication extends Expression {

    // Abstraction Function:
    //  Multiplication e is an object represnting an arithmetic expression of multiplication.
    //  arg1 - object of type expression or it's descending clasess 
    //  arg2 - object of type expression or it's descending clasess 
    // Representation Invariant:
    //  arg1 != null && arg2 != null

    /**
     * Constructs a new Multiplication by calling the super method. 
     * @effects constructs a new Multiplication.
     **/
    public Multiplication(Expression e1, Expression e2) {
        super(e1, e2);
        checkRep();
    }

    /**
     * Constructs a new Multiplication by calling the super method. 
     * @effects constructs a new Multiplication.
     **/
    public Multiplication(Number e1, Expression e2) {
        super(e1, e2);
        checkRep();
    }

    /**
     * Constructs a new Multiplication by calling the super method. 
     * @effects constructs a new Multiplication.
     **/
    public Multiplication(Expression e1, Number e2) {
        super(e1, e2);
        checkRep();
    }

    /**
     * Constructs a new Multiplication by calling the super method. 
     * @effects constructs a new Multiplication.
     **/
    public Multiplication(Number e1, Number e2) {
        super(e1, e2);
        checkRep();
    }
    
    @Override
    protected void checkRep() {
        assert (arg1 != null) :
        "Error arg1 of Addition is null";
        assert (arg2 != null) :
        "Error arg2 of Addition is null";
    }

	/**
     * evalute the result Multiplication between two Expressions
     * @return the result of Multiplication between two Expressions
     **/
    @Override
    public Number eval() {
        checkRep();
        return (arg1.eval().doubleValue() * arg2.eval().doubleValue());
    }

	/**
     * create a string represntion of the Multiplication expression "(exp1 * exp2)"
     * @return the String represntion that was created
     **/
    @Override
    public String toString() {
        checkRep();
        return ("(" + arg1.toString() + " * " + arg2.toString() + ")");
    }
}
