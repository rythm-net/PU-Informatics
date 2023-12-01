package fmi.patterns.state.with_template;

import java.awt.Color;

public class BlackState extends State {
	// Следващо състояние за Black състоянието:
	// При push(), преминава в "red"
	// При pull(), преминава в "green"

	@Override
	public void handlePush(Context c) {
		c.setState(new RedState());
	}

	@Override
	public void handlePull(Context c) {
		c.setState(new GreenState());
	}

	@Override
	public Color getColor() {
		return (Color.black);
	}
}
