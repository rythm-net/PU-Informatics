package tests;

public class TestRunner {

    public static void check(String what, String against) {

        String message = what.equals(against) ? "Test Pass" : "Test Fail";
        System.out.println(message);
    }
}
