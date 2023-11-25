package processor;

import calculators.AbstractCalculator;
import calculators.Digit;

public class MathCalculator extends AbstractCalculator {

    public Digit add(Digit a, Digit b) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Digit addMulti(Digit... collection) {
        return null;
    }

    public Digit sub(Digit a, Digit b) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Digit subMulti(Digit... collection) {
        return null;
    }

    public Digit mul(Digit a, Digit b) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Digit mulMulti(Digit... collection) {
        return null;
    }

    public Digit div(Digit a, Digit b) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Digit divMulti(Digit... collection) {
        return null;
    }

    /**
     *
     * Визуализирира числото, във формата към който принадлежи
     * •	BinaryDigit – двоично
     * •	OctDigit - осмично
     * •	DecimalDigit – десетично
     * •	HexDigit – шестнаисетично
     *
     * #Пример:
     * BinaryDigit a = new BinaryDigit(“0101”);
     * MathCalculator calculator = new MathCalculator();
     * calculator.nativeRender(a) // 0101
     * @param digit
     */
    public void renderNative(Digit digit) {

    }

    /**
     * Визуализира числото в десетичен формат
     *
     * Пример:
     * BinaryDigit a = new BinaryDigit(“0101”);
     * MathCalculator calculator = new MathCalculator();
     * calculator.decimalRender(a) // 5
     * @param digit
     */
    public void renderDecimal(Digit digit) {

    }

    /**
     * Визуализира числото в двуичен формат
     * @param digit
     */
    public void renderBinary(Digit digit) {

    }

    /**
     * Визуализира числото в осмичен формат
     * @param digit
     */
    public void renderOct(Digit digit) {

    }

    /**
     * Визуализира числото в шестнадесетичен формат
     * @param digit
     */
    public void renderHex(Digit digit) {

    }
}
