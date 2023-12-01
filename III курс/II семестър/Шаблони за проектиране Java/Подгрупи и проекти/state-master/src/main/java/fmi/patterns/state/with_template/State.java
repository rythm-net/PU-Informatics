package fmi.patterns.state.with_template;

import java.awt.Color;

/**
 * Абстрактен клас, който дефинира интерфейса за поведението на 
 * конкретно състояние на Context.
 */
public abstract class State {
	public abstract void handlePush(Context c);

	public abstract void handlePull(Context c);

	public abstract Color getColor();
}
