package Question_Three;

abstract class Expression implements Evalable {
    
    protected Expression arg1;
    protected Expression arg2;

    public Expression() {}

    public Expression(Number e) {
        arg1 = new LeafNumber(e);
    }

    public Expression(Expression e) {
        arg1 = e;
    }

    public Expression (Expression e1, Expression e2) {
        arg1 = e1;
        arg2 = e2;
        checkRep();
    }

    public Expression (Number e1, Expression e2) {
        arg1 = new LeafNumber(e1);
        arg2 = e2;
        checkRep();
    }

    public Expression (Expression e1, Number e2) {
        arg1 = e1;
        arg2 = new LeafNumber(e2);
        checkRep();
    }

    public Expression (Number e1, Number e2) {
        arg1 = new LeafNumber(e1);
        arg2 = new LeafNumber(e2);
        checkRep();
    }
    
    protected abstract void checkRep();
    public abstract Number eval();
    public abstract String toString();
}
