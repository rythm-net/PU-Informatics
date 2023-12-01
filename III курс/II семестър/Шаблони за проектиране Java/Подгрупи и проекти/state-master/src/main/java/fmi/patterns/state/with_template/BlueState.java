package fmi.patterns.state.with_template;

import java.awt.Color;

public class BlueState extends State {
	// Следващо състояние за Blue състоянието:
	// При push(), преминава в "green"
	// При pull(), преминава в "red"

	@Override
	public void handlePush(Context c) {
		c.setState(new GreenState());
	}

	@Override
	public void handlePull(Context c) {
		c.setState(new RedState());
	}

	@Override
	public Color getColor() {
		return (Color.blue);
	}
}
