package util;

import java.util.Scanner;

public class Console {

    public static int input(String message) {
        System.out.print(message);

        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}