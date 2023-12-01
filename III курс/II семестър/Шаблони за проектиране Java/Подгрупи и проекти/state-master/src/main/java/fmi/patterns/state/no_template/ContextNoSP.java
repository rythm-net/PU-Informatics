package fmi.patterns.state.no_template;

import java.awt.Color;

/**
 * Класа ContextNoSP има поведение, което зависи от състоянието му. 
 * Методите push() и pull() извършват различни неща в зависимост от състоянието на обекта.
 * Този клас НЕ използва шаблона Състояние.
 */
public class ContextNoSP {
	// Състоянието!
	private Color state;

	// Създава нов ContextNoSP със зададеното състояние (color).
	public ContextNoSP(Color color) {
		state = color;
	}

	// Създава нов ContextNoSP със сътояние по подразбиране
	public ContextNoSP() {
		this(Color.red);
	}

	// Връща състоянието.
	public Color getState() {
		return state;
	}

	// Задава състояние.
	public void setState(Color state) {
		this.state = state;
	}

	/**
	 * Методът push() извършва различни дейности в зависимост от състоянието на обекта.
	 * Реално единственото нещо, което прави е смяна на състоянието.
	 */
	public void push() {
		if (state == Color.red)
			state = Color.blue;
		else if (state == Color.green)
			state = Color.black;
		else if (state == Color.black)
			state = Color.red;
		else if (state == Color.blue)
			state = Color.green;
	}

	/**
	 * Методът pull() извършва различни дейности в зависимост от състоянието на обекта.
	 * Реално единственото нещо, което прави е смяна на състоянието.
	 */
	public void pull() {
		if (state == Color.red)
			state = Color.black;
		else if (state == Color.green)
			state = Color.blue;
		else if (state == Color.black)
			state = Color.green;
		else if (state == Color.blue)
			state = Color.red;
	}
}
