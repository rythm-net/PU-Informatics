package fmi.patterns.singleton;

/**
 * Пример за шаблона Singleton към дисциплината "Проектиране на софтуер и архитектури"
 */
public class Demo {

	public static void main(String[] args) {
		// Получаване на референция към единствената инстанция на Singleton.
		Singleton s = Singleton.getInstance();
		
		// Някаква промяна на състоянието.
		s.setData(34);
		System.out.println("Първа референция: " + s);
		System.out.println("Стойността на Singleton data e: " + s.getData());
		
		// Взимане на втора референция към Singleton.
		// Същия обект ли е?
		Singleton s2 = Singleton.getInstance();
		System.out.println("\nВтора референция: " + s2);
		System.out.println("Стойността на Singleton data e: " + s2.getData());

		if (s == s2) {
			System.out.println("\nДвата обекта са еднакви");
		} else {
			System.err.println("\nДвата обекта са различни");
		}

	}

}
