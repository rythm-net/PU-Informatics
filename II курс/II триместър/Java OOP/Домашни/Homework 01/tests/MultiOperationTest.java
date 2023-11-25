package tests;

import calculators.AbstractCalculator;
import calculators.Digit;
import digits.BinaryDigit;
import digits.DecimalDigit;
import digits.OctDigit;

public class MultiOperationTest {

    public static void test(AbstractCalculator calculator) {

        Digit a = new BinaryDigit("010011");
        Digit b = new OctDigit("67");
        Digit c = new DecimalDigit("67");
        Digit d = new HexOperationTest("67");

        Digit addResult = calculator.addMulti(a, b, c, d);
        calculator.nativeRender(addResult);
        calculator.binaryRender(addResult);

        Digit subResult = calculator.subMulti(a, b, c, d);
        calculator.nativeRender(addResult);
        calculator.octRender(addResult);

        Digit mulResult = calculator.mulMulti(a, b, c, d);
        calculator.nativeRender(addResult);
        calculator.decimalRender(addResult);

        Digit divResult = calculator.divMulti(a, b, c, d);
        calculator.nativeRender(addResult);
        calculator.hexRender(addResult);
    }
}
