package fmi.patterns.command;

/**
 * Приложение на шаблона Команда
 */
public class TestTaskMinder {

	public static void main(String[] args) {
		// Създаване и стартиране на TaskMinder.
		// Този TaskMinder проверява за задачи на всеки 500 ms.
		TaskMinder tm = new TaskMinder(500);
		
		// Създаване на задача Fortune Teller.
		FortuneTask fortuneTask = new FortuneTask();
		
		// Изпълнение на Fortune Teller на всеки 3 s.
		tm.addTask(fortuneTask, 3000);	
		
		// Създаване на задача Fibonacci.
		FibonacciTask fibonacciTask = new FibonacciTask();

		// Изпълнение на задачата на всеки 700 ms.
		tm.addTask(fibonacciTask, 700);
	}
}


