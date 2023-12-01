package fmi.patterns.decorator;

public class TopDecorator extends AbstractTreeDecorator {
    public TopDecorator(ChristmasTree tree) {
        super(tree);
    }

    @Override
    public String build() {
        return super.build() + setTop();
    }

    private String setTop() {
        return " с поставено връхче";
    }
}
