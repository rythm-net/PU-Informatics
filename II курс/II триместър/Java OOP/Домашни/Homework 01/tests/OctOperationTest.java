package tests;

import calculators.AbstractCalculator;
import calculators.Digit;
import digits.DecimalDigit;
import digits.OctDigit;

public class OctOperationTest {

    public static void test(AbstractCalculator calculator) {

        Digit a = new OctDigit("531");
        Digit b = new OctDigit("67");

        Digit addResult = calculator.add(a, b);
        calculator.nativeRender(addResult);
        calculator.binaryRender(addResult);

        Digit subResult = calculator.sub(a, b);
        calculator.nativeRender(addResult);
        calculator.octRender(addResult);

        Digit mulResult = calculator.mul(a, b);
        calculator.nativeRender(addResult);
        calculator.decimalRender(addResult);

        Digit divResult = calculator.div(a, b);
        calculator.nativeRender(addResult);
        calculator.hexRender(addResult);
    }
}
