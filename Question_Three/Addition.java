package Question_Three;

public class Addition extends Expression {

    // Abstraction Function:
    //  Addition e is an object represnting an arithmetic expression of addition.
    //  arg1 - object of type expression or it's descending clasess 
    //  arg2 - object of type expression or it's descending clasess 
    // Representation Invariant:
    //  arg1 != null && arg2 != null

    /**
     * Constructs a new Addition by calling the super method. 
     * @effects constructs a new Addition.
     **/
    public Addition(Expression e1, Expression e2) {
        super(e1, e2);
        checkRep();
    }

    /**
     * Constructs a new Addition by calling the super method. 
     * @effects constructs a new Addition.
     **/
    public Addition(Number e1, Expression e2) {
        super(e1, e2);
        checkRep();
    }

    /**
     * Constructs a new Addition by calling the super method. 
     * @effects constructs a new Addition.
     **/
    public Addition(Expression e1, Number e2) {
        super(e1, e2);
        checkRep();
    }

    /**
     * Constructs a new Addition by calling the super method. 
     * @effects constructs a new Addition.
     **/
    public Addition(Number e1, Number e2) {
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
     * evalute the result addition between two Expressions
     * @return the result of addition between two Expressions
     **/
    @Override
    public Number eval() {
        checkRep();
        return (arg1.eval().doubleValue() + arg2.eval().doubleValue());
    }

	/**
     * create a string represntion of the addition expression "(exp1 + exp2)"
     * @return the String represntion that was created
     **/
    @Override
    public String toString() {
        checkRep();
        return ("(" + arg1.toString() + " + " + arg2.toString() + ")");
    }
}
