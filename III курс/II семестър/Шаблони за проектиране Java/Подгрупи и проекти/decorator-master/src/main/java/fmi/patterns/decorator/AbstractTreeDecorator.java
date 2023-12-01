package fmi.patterns.decorator;

public abstract class AbstractTreeDecorator implements ChristmasTree {
    private ChristmasTree tree;

    public AbstractTreeDecorator(ChristmasTree tree) {
        this.tree = tree;
    }

    @Override
    public String build() {
        return tree.build();
    }
}
