package fmi.patterns.visitor.visitor;

import fmi.patterns.visitor.component.Bottle;
import fmi.patterns.visitor.component.Pack;

public class SimpleVisitor extends Visitor {
	@Override
	public void visit(Bottle bottle) {
		System.out.printf("Visit bottle %s with price %.2f. %n", bottle.getName(), bottle.getPrice());
	}

	@Override
	public void visit(Pack pack) {
		System.out.printf("Visit Pack %s with total price %.2f. %n", pack.getName(), pack.getPrice());
	}
}
