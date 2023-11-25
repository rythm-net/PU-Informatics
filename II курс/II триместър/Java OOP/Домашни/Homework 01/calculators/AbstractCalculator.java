package calculators;

public abstract class AbstractCalculator {

    public abstract Digit add(Digit a, Digit b);
    public abstract Digit addMulti(Digit ...collection);
    public abstract Digit sub(Digit a, Digit b);
    public abstract Digit subMulti(Digit ...collection);
    public abstract Digit mul(Digit a, Digit b);
    public abstract Digit mulMulti(Digit ...collection);
    public abstract Digit div(Digit a, Digit b);
    public abstract Digit divMulti(Digit ...collection);

    public <BinaryDigit> void renderNative(BinaryDigit addResult) {
    }

    public <BinaryDigit> void renderDecimal(BinaryDigit addResult) {
    }

    public void renderHex(Digit addResult) {
    }

    public void nativeRender(Digit addResult) {
    }

    public void binaryRender(Digit addResult) {
    }

    public <BinaryDigit> void renderBinary(BinaryDigit addResult) {
    }

    public void octRender(Digit addResult) {
    }

    public void decimalRender(Digit addResult) {
    }

    public void hexRender(Digit addResult) {
    }
}
