package fmi.patterns.visitor.component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import fmi.patterns.visitor.visitor.Visitor;

@AllArgsConstructor
@Setter
@Getter
public abstract class Component {
	protected String name;

	public abstract double getPrice();
	public abstract void accept(Visitor visitor);
}
