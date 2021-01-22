package Question_Three;

public class UnaryMinus extends Expression {
    public UnaryMinus (Number e) {
        super(e);
        checkRep();
    }

    public UnaryMinus (Expression e){
        super(e);
        checkRep();
    }

    @Override
    protected void checkRep() {
        assert (arg1 != null):
        "Error arg1 of Addition is null";
    }

    @Override
    public Number eval() {
        checkRep();
        return (- arg1.eval().doubleValue());
    }

    @Override
    public String toString() {
        checkRep();
        return ("(-(" + arg1.toString() + "))");
    }
}
