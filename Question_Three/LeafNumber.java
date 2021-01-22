package Question_Three;

public class LeafNumber extends Expression{
    private Number arg;

    public LeafNumber (Number num) {
        arg = num;
        checkRep();
    }
    
    @Override
    protected void checkRep() {
        assert (arg != null) :
        "Error LaefNumber can not be Null";
        
    }

    @Override
    public Number eval() {
        checkRep();
        return arg;
    }

    @Override
    public String toString() {
        checkRep();
        return arg.toString();
    }
}
