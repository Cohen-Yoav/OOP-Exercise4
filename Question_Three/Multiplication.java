package Question_Three;

public class Multiplication extends Expression {

    public Multiplication(Expression e1, Expression e2) {
        super(e1, e2);
        checkRep();
    }

    public Multiplication(Number e1, Expression e2) {
        super(e1, e2);
        checkRep();
    }

    public Multiplication(Expression e1, Number e2) {
        super(e1, e2);
        checkRep();
    }

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

    @Override
    public Number eval() {
        checkRep();
        return (arg1.eval().doubleValue() * arg2.eval().doubleValue());
    }

    @Override
    public String toString() {
        checkRep();
        return ("(" + arg1.toString() + " * " + arg2.toString() + ")");
    }
}
