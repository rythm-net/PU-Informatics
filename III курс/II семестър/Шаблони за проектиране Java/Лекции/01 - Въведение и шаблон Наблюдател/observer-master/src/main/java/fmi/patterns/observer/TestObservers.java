package fmi.patterns.observer;

/**
 * Тестова програма за ConcreteSubject, NameObserver и PriceObserver
 */
public class TestObservers {

	public static void main(String[] args) throws InterruptedException {
		// Създаване на Subject и Observers.
		ConcreteSubject s = new ConcreteSubject("Пуканки", 1.29f);
		NameObserver nameObs = new NameObserver();
		PriceObserver priceObs = new PriceObserver();
		
		// Добавяне на наблюдателите!
		s.addObserver(nameObs);
		s.addObserver(priceObs);
		
		// Промяна в subject през 3 секунди
		s.setName("Печени ядки");
		Thread.sleep(3000);

		s.setPrice(4.57f);
		Thread.sleep(3000);

		s.setPrice(9.22f);
		Thread.sleep(3000);

		s.setName("Тиквени семки");
	}
}

