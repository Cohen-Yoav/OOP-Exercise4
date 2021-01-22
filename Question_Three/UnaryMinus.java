package Question_Three;

public class UnaryMinus extends Expression {

    // Abstraction Function:
    //  UnaryMinus e is an object represnting an arithmetic expression of minus the value of the expression.
    //  arg1 - object of type expression or it's descending clasess 
    // Representation Invariant:
    //  arg1 != null

    /**
     * Constructs a new UnaryMinus by calling the super method. 
     * @effects constructs a new UnaryMinus.
     **/
    public UnaryMinus (Number e) {
        super(e);
        checkRep();
    }

    /**
     * Constructs a new UnaryMinus by calling the super method. 
     * @effects constructs a new UnaryMinus.
     **/
    public UnaryMinus (Expression e){
        super(e);
        checkRep();
    }

    @Override
    protected void checkRep() {
        assert (arg1 != null):
        "Error arg1 of Addition is null";
    }

	/**
     * evalute the result UnaryMinus between two Expressions
     * @return the result of UnaryMinus between two Expressions
     **/
    @Override
    public Number eval() {
        checkRep();
        return (- arg1.eval().doubleValue());
    }

	/**
     * create a string represntion of the UnaryMinus expression "(-(exp1))"
     * @return the String represntion that was created
     **/
    @Override
    public String toString() {
        checkRep();
        return ("(-(" + arg1.toString() + "))");
    }
}
