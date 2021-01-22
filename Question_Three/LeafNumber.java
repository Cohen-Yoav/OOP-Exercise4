package Question_Three;

public class LeafNumber extends Expression{

    // Abstraction Function:
    //  LeafNumber e is an object represnting an arithmetic expression of a Number.
    //  arg - object of type Number or it's descending clasess 
    // Representation Invariant:
    //  arg != null

    private Number arg;

    /**
     * Constructs a new LeafNumber. 
     * @effects constructs a new LeafNumber.
     **/
    public LeafNumber (Number num) {
        arg = num;
        checkRep();
    }

    @Override
    protected void checkRep() {
        assert (arg != null) :
        "Error LaefNumber can not be Null";
        
    }

    /**
     * return this.arg
     * @return arg
     **/
    @Override
    public Number eval() {
        checkRep();
        return arg;
    }

	/**
     * create a string represntion of the LaefNumber value 
     * @return the String represntion that was created
     **/
    @Override
    public String toString() {
        checkRep();
        return arg.toString();
    }
}
