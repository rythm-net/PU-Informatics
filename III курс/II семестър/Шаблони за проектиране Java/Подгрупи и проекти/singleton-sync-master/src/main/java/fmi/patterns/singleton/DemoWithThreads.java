package fmi.patterns.singleton;

/**
 * Пример за шаблона Singleton към дисциплината "Проектиране на софтуер и архитектури"
 */
public class DemoWithThreads {

	public static void main(String[] args) {
		SingletonTestThread[] threads = new SingletonTestThread[1000];

		for (int i = 0; i < threads.length; i++) {
			threads[i] = new SingletonTestThread(String.format("Нишка %d", i));
		}

		for (SingletonTestThread thread : threads) {
			thread.start();
		}
	}
}
