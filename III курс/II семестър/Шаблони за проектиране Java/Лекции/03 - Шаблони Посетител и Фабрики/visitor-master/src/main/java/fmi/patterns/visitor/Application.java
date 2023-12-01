package fmi.patterns.visitor;


import fmi.patterns.visitor.component.Bottle;
import fmi.patterns.visitor.component.Component;
import fmi.patterns.visitor.component.Pack;
import fmi.patterns.visitor.visitor.BuyVisitor;
import fmi.patterns.visitor.visitor.SimpleVisitor;

import java.util.ArrayList;
import java.util.List;

public class Application {
	public static void main(String[] args) {
		List<Component> products = new ArrayList<>();

		products.add(new Bottle("Becks", 1.20));
		products.add(new Bottle("Каменица", 2.30));
		products.add(new Bottle("Шуменско", 1.30));

		Pack pack = new Pack("Каса бира");
		pack.addBottle(new Bottle("Stella Arthois", 2.10));
		pack.addBottle(new Bottle("Stella Arthois", 2.10));
		pack.addBottle(new Bottle("Stella Arthois", 2.10));

		products.add(pack);

		System.out.println();
		System.out.println("=== Let's check the store ===");

		SimpleVisitor simpleVisitor = new SimpleVisitor();

		for (Component product: products) {
			product.accept(simpleVisitor);
		}

		System.out.println();
		System.out.println("=== Let's buy some beer ===");

		BuyVisitor buyVisitor = new BuyVisitor(2.20);

		for (Component product: products) {
			product.accept(buyVisitor);
		}
	}
}
