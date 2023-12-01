package fmi.patterns.decorator;

public class LedLightsDecorator extends AbstractTreeDecorator {
    public LedLightsDecorator(ChristmasTree tree) {
        super(tree);
    }

    @Override
    public String build() {
        return super.build() + decorateWithLedLights();
    }

    private String decorateWithLedLights() {
        return " с LED лампички";
    }

}
