package fmi.patterns.visitor.visitor;

import fmi.patterns.visitor.component.Bottle;
import fmi.patterns.visitor.component.Pack;

public abstract class Visitor {
	public abstract void visit(Bottle bottle);
	public abstract void visit(Pack pack);
}
