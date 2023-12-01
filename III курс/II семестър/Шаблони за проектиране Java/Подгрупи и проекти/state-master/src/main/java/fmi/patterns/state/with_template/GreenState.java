package fmi.patterns.state.with_template;

import java.awt.Color;

public class GreenState extends State {
	// Следващо състояние за Green състоянието:
	// При push(), преминава в "black"
	// При pull(), преминава в "blue"

	@Override
	public void handlePush(Context c) {
		c.setState(new BlackState());
	}

	@Override
	public void handlePull(Context c) {
		c.setState(new BlueState());
	}

	@Override
	public Color getColor() {
		return (Color.green);
	}
}
