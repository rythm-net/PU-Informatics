package tests;

import calculators.AbstractCalculator;

public class MixOperationTest {

    public static void test(AbstractCalculator calculator) {

        Digit a   = new BinaryDigit("1101");
        Digit b  = new DecimalDigit("10574");
        BinaryDigit addResult = calculator.add(a, b);
        calculator.renderNative(addResult);
        calculator.renderDecimal(addResult);

        DecimalDigit subResult = calculator.sub(a, b);
        calculator.renderNative(addResult);
        calculator.renderBinary(addResult);

        BinaryDigit mulResult = calculator.mul(a, b);
        calculator.renderNative(addResult);
        calculator.renderOct(addResult);

        DecimalDigit divResult = calculator.div(a, b);
        calculator.renderNative(addResult);
        calculator.renderHex(addResult);
    }
}
