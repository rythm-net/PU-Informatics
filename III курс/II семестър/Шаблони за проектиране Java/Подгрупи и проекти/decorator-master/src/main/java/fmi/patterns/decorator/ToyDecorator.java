package fmi.patterns.decorator;

public class ToyDecorator extends AbstractTreeDecorator {
    private String toy;

    public ToyDecorator(ChristmasTree tree, String toy) {
        super(tree);
        this.toy = toy;
    }

    @Override
    public String build() {
        return super.build() + decorateWithToy();
    }

    private String decorateWithToy() {
        return " с " + toy;
    }
}
