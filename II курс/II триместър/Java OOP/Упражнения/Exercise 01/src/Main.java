public class Main {

    public static void main(String[] args) {
        // byte
        // short
        // int
        // long

        int a = 1;
        int b = 2;

        float number = 2.3F;
        double doubleNumber = 12.3D;

        char symbol = 'A';
        char symbol1 = 42;

        boolean isValid = number > doubleNumber ? true : false;

        if (number > doubleNumber) {
            isValid = true;
        } else {
            isValid = false;
        }

        String word = "test";

        // <, >, ==, <=, >=, !=
        // =
        // +, -, /, *, %
        // &, |
        // &&, ||
        // ++, --

        int c = 1;
        int d = 2;

        int f = ++c;
        int g = c++;

        boolean isTrue = number > doubleNumber && a > b;
        int result = 5 & 3;
        System.out.println("Result: " + result);

        switch (word) {
            case "test":
                System.out.println("You win!");
                break;
            case "test1":
                System.out.println("You lost!");
                break;
            default:
                System.out.println("I don't know what it is");
        }

        String r = switch (word) {
            case "test" -> "You win!";

            case "test1" -> "You lost!";

            default -> "I don't know what it is";
        };

        System.out.println("Result 1: " + r);

        while (true) {
            System.out.println("test");
            break;
        }

        do {
            System.out.println("test");
            break;
        } while (true);

        for (int i = 0; i < 5; ++i) {
            System.out.println("test");
        }

        for (int i = 0; i < 5;) {
            System.out.println("test");
            i++;
        }

        int array0 [] = new int[5];
        int [] array = new int [] {1, 2, 3, 4, 5};

        for (int n : array) {
            System.out.printf("N = %d; ", n);
        }
    }

}