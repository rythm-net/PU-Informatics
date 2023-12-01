package fmi.patterns.state.with_template;

/**
 * Класът Context има поведение, което зависи от неговото състояние. Този клас
 * използва шаблона Състояние. Сега когато имаме pull() или push() заявки делегираме
 * поведението на обекта, който съдържа състоянието.
 */
public class Context {
	// Вътрешното състояние.
	private State state; // атрибут за състоянието

	// Създава нов Context със зададеното състояние.
	public Context(State state) {
		this.state = state;
	}

	// Създава нов Context със състояние по подразбиране.
	public Context() {
		this(new RedState());
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	/**
	 * Методът push() извършва различни действия в зависимосто от състоянието
	 * на обекта. Като използваме шаблона Състояние делегираме поведението на този метод
	 * на обекта, който съдържа самото състояние.
	 */
	public void push() {
		state.handlePush(this);
	}

	/**
	 * Методът pull() извършва различни действия в зависимосто от състоянието
	 * на обекта. Като използваме шаблона Състояние делегираме поведението на този метод
	 * на обекта, който съдържа самото състояние.
	 */
	public void pull() {
		state.handlePull(this);
	}
}
