package fmi.patterns.singleton;

/**
 * Пример за шаблона Singleton към дисциплината "Проектиране на софтуер и архитектури"
 */
public class Singleton {

	// Референция към единствената инстанция с предварително (eager) създаване.
	private static final Singleton uniqueInstance = new Singleton();

	// Някакъв атрибут на инстанцията.
	private int data = 0;

	/**
	 * Връща референция към единствената инстанция.
	 */
	public static Singleton getInstance() {
		return uniqueInstance;
	}

	/**
	 * Singleton констурктора. Забележете, че е private! Външен клас не може да
	 * създаде инстанция.
	 */
	private Singleton() {

	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}
}
