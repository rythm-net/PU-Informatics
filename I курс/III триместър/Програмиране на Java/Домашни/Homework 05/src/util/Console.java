package util;

import java.util.Scanner;

public class Console {

    public static void print(String message) {
        System.out.print(message);
    }

    public static void println(String message) {
        System.out.println(message);
    }

    public static int input() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static int input(String message) {
        print(message);
        return input();
    }
}