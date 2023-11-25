package tests;

import calculators.AbstractCalculator;

public class BinaryOperationsTest {

    public static void test(AbstractCalculator calculator) {

        BinaryDigit a = new BinaryDigit("1101");
        BinaryDigit b = new BinaryDigit("0001");

        BinaryDigit addResult = calculator.add(a, b);
        calculator.renderNative(addResult);
        calculator.renderDecimal(addResult);

        BinaryDigit subResult = calculator.sub(a, b);
        calculator.renderNative(addResult);
        calculator.renderDecimal(addResult);

        BinaryDigit mulResult = calculator.mul(a, b);
        calculator.renderNative(addResult);
        calculator.renderDecimal(addResult);

        BinaryDigit divResult = calculator.div(a, b);
        calculator.renderNative(addResult);
        calculator.renderDecimal(addResult);
    }
}
