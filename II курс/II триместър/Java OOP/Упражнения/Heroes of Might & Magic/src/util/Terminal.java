package util;

import java.util.Scanner;

public class Terminal
{
	public static int inputNumber(String message)
	{
		System.out.println(message);
		return inputNumber();
	}
	
	public static int inputNumber()
	{
		Scanner scanner=new Scanner(System.in);
		return  scanner.nextInt();
	}

	public static String inputString(String message)
	{
		System.out.println();
		return inputString();
	}
	
	public static String inputString()
	{
		Scanner scanner=new Scanner(System.in);
		return  scanner.nextLine();
	}
}
