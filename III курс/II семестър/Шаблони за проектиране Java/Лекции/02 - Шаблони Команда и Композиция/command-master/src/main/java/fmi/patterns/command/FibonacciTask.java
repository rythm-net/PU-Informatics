package fmi.patterns.command;

/**
 * Команда, извеждаща следващото число от реда на Фибоначи
 */
public class FibonacciTask implements Task {
	private int n1 = 1;
	private int n2 = 0;

	@Override
	public void performTask() {
		int num = n1 + n2;
		System.out.println("Следващото число на Фибоначи е: " + num);
		n1 = n2;
		n2 = num;
	}

	@Override
	public String toString() {
		return ("Task: числа на Фибоначи");
	}
}

