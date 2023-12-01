package fmi.patterns.visitor.component;

import fmi.patterns.visitor.visitor.Visitor;

public class Bottle extends Component {
	private final double price;

	public Bottle(String name, double price) {
		super(name);

		this.price = price;
	}

	@Override
	public double getPrice() {
		return price;
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}
