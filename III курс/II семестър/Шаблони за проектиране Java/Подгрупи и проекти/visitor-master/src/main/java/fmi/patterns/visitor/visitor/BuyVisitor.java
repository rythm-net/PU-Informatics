package fmi.patterns.visitor.visitor;

import fmi.patterns.visitor.component.Bottle;
import fmi.patterns.visitor.component.Pack;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BuyVisitor extends Visitor {
	private final double maxPrice;

	@Override
	public void visit(Bottle bottle) {
		if (bottle.getPrice() < maxPrice) {
			System.out.printf("Quick! Buy this bottle %s with amazing price %.2f. %n",
					bottle.getName(), bottle.getPrice());
		} else {
			System.out.printf("Skip this bottle %s with price %.2f. It is too expensive. %n",
					bottle.getName(), bottle.getPrice());
		}
	}

	@Override
	public void visit(Pack pack) {
		if (pack.getPrice() < maxPrice*pack.getBottleCount()) {
			System.out.printf("Quick! Buy this amazing pack %s with %d bottles and total price %.2f. %n",
					pack.getName(), pack.getBottleCount(), pack.getPrice());
		} else {
			System.out.printf("Skip this pack %s with %d bottles and total price %.2f.. It is too expensive. %n",
					pack.getName(), pack.getBottleCount(), pack.getPrice());
		}
	}
}
