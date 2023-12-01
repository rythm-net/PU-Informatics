package fmi.patterns.visitor.component;

import fmi.patterns.visitor.visitor.Visitor;

import java.util.ArrayList;
import java.util.List;

public class Pack extends Component {

	private final List<Component> bottles = new ArrayList<>();

	public Pack(String name) {
		super(name);
	}

	public void addBottle(Bottle bottle) {
		bottles.add(bottle);
	}

	public int getBottleCount() {
		return bottles.size();
	}

	@Override
	public double getPrice() {
		double totalPrice = 0;

		for (Component component: bottles) {
			totalPrice += component.getPrice();
		}

		return totalPrice;
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}
