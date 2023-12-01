package fmi.patterns.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * Наблюдател на промяна на името
 */
@SuppressWarnings("deprecation")
public class NameObserver implements Observer {

	private String name;

	public NameObserver() {
		name = null;
		System.out.println("NameObserver created: Name is " + name);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	@Override
	public void update(Observable obj, Object arg) {
		if (arg instanceof String) {
			name = (String) arg;
			System.out.println("NameObserver: Name changed to " + name);
		} else {
			System.out.println("NameObserver: Some other change to subject!");
		}
	}
}

