package util;

import java.util.Scanner;

public class Console {

    public static void log(String message) {
        System.out.print(message);
    }

    public static void logln(String message) {
        System.out.println(message);
    }

    public static String scan() {
        Scanner scanner = new Scanner(System.in);
        String message = scanner.nextLine();
        return message;
    }

    public static String scan(String message) {
        log(message);
        return scan();
    }

    public static int scanInt() {
        Scanner scanner = new Scanner(System.in);
        int message = scanner.nextInt();
        return message;
    }

    public static int scanInt(String message) {
        log(message);
        return scanInt();
    }
}