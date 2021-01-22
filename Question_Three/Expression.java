package Question_Three;

abstract class Expression implements Evalable {

    protected Expression arg1;
    protected Expression arg2;

  	/**
     * Constructs a new Expression.
     * @effects constructs a new Expression.
     **/
    public Expression() {}

    /**
     * Constructs a new Expression and assign e to arg1.
     * @effects constructs a new Expression.
     **/
    public Expression(Number e) {
        arg1 = new LeafNumber(e);
    }

    /**
     * Constructs a new Expression and assign e to arg1.
     * @effects constructs a new Expression.
     **/
    public Expression(Expression e) {
        arg1 = e;
    }

    /**
     * Constructs a new Expression and assign e1 to arg1, and e2 to arg2. 
     * @effects constructs a new Expression.
     **/
    public Expression (Expression e1, Expression e2) {
        arg1 = e1;
        arg2 = e2;
        checkRep();
    }

    /**
     * Constructs a new Expression and assign e1 to arg1, and e2 to arg2. 
     * @effects constructs a new Expression.
     **/
    public Expression (Number e1, Expression e2) {
        arg1 = new LeafNumber(e1);
        arg2 = e2;
        checkRep();
    }

    /**
     * Constructs a new Expression and assign e1 to arg1, and e2 to arg2. 
     * @effects constructs a new Expression.
     **/
    public Expression (Expression e1, Number e2) {
        arg1 = e1;
        arg2 = new LeafNumber(e2);
        checkRep();
    }

    /**
     * Constructs a new Expression and assign e1 to arg1, and e2 to arg2. 
     * @effects constructs a new Expression.
     **/
    public Expression (Number e1, Number e2) {
        arg1 = new LeafNumber(e1);
        arg2 = new LeafNumber(e2);
        checkRep();
    }
    
    protected abstract void checkRep();
    public abstract Number eval();
    public abstract String toString();
}
