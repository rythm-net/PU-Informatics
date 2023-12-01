package fmi.patterns.singleton;

/**
 * Пример за шаблона Singleton към дисциплината "Проектиране на софтуер и архитектури"
 */
public class SingletonTestThread extends Thread {
	
	private final String name;
	
	public SingletonTestThread(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		while (true) {
			// Получаване на референция към единствената инстанция на Singleton.
			Singleton s = Singleton.getInstance();
			
			// Извеждане на адреса на единствената инстанция.
			System.out.println("[" + this.name + "]: " + s);
			
			try {
				sleep(Math.round(Math.random()*1000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
