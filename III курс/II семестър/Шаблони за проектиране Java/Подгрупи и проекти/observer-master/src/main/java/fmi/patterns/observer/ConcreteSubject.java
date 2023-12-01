package fmi.patterns.observer;

import lombok.*;

import java.util.Observable;

/**
 * Някакъв subject за наблюдаване 
 */
@Getter
@Setter
@AllArgsConstructor
@SuppressWarnings("deprecation")
public class ConcreteSubject extends Observable {
	private String name;
	private float price;

	public void setName(String name) {
		this.name = name;
		setChanged();
		notifyObservers(name);
	}

	public void setPrice(float price) {
		this.price = price;
		setChanged();
		notifyObservers(price);
	}
}
