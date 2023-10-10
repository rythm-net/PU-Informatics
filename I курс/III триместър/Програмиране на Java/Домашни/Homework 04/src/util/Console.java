package util;

public class Console {

    public static void print(String message) {
        System.out.print(message);
    }

    public static void println(String message) {
        System.out.println(message);
    }

    public static void red(String message) {
        print("\u001B[31m" + message + "\u001B[0m");
    }

    public static void green(String message) {
        print("\u001B[32m" + message + "\u001B[0m");
    }

    public static void yellow(String message) {
        print("\u001B[33m" + message + "\u001B[0m");
    }

    public static void blue(String message) {
        print("\u001B[34m" + message + "\u001B[0m");
    }
}