package Question_Three;

public class Division extends Expression {

    // Abstraction Function:
    //  Division e is an object represnting an arithmetic expression of division.
    //  arg1 - object of type expression or it's descending clasess 
    //  arg2 - object of type expression or it's descending clasess 
    // Representation Invariant:
    //  arg1 != null && arg2 != null && arg2.eval().doubleValue() != 0.0

    /**
     * Constructs a new Division by calling the super method. 
     * @effects constructs a new Division.
     **/
    public Division(Expression e1, Expression e2) {
        super(e1, e2);
        checkRep();
    }

    /**
     * Constructs a new Division by calling the super method. 
     * @effects constructs a new Division.
     **/
    public Division(Number e1, Expression e2) {
        super(e1, e2);
        checkRep();
    }

    /**
     * Constructs a new Division by calling the super method. 
     * @effects constructs a new Division.
     **/
    public Division(Expression e1, Number e2) {
        super(e1, e2);
        checkRep();
    }

    /**
     * Constructs a new Division by calling the super method. 
     * @effects constructs a new Division.
     **/
    public Division(Number e1, Number e2) {
        super(e1, e2);
        checkRep();
    }
    
    @Override
    protected void checkRep() {
        assert (arg1 != null) :
        "Error arg1 of Addition is null";
        assert (arg2 != null) :
        "Error arg2 of Addition is null";
        assert (arg2.eval().doubleValue() != 0.0) :
        "ar2 is zero, Division not possible";
    }

	/**
     * evalute the result Division between two Expressions
     * @return the result of Division between two Expressions
     **/
    @Override
    public Number eval() {
        checkRep();
        return (arg1.eval().doubleValue() / arg2.eval().doubleValue());
    }

	/**
     * create a string represntion of the Division expression "(exp1 / exp2)"
     * @return the String represntion that was created
     **/
    @Override
    public String toString() {
        checkRep();
        return ("(" + arg1.toString() + " / " + arg2.toString() + ")");
    }
}
