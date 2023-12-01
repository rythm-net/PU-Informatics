package fmi.patterns.state.with_template;

import java.awt.Color;

public class RedState extends State {
	// Следващо състояние за Red състоянието:
	// При push(), преминава в "blue"
	// При pull(), преминава в "green"

	@Override
	public void handlePush(Context c) {
		c.setState(new BlueState());
	}

	@Override
	public void handlePull(Context c) {
		c.setState(new BlackState());
	}

	@Override
	public Color getColor() {
		return (Color.red);
	}
}
