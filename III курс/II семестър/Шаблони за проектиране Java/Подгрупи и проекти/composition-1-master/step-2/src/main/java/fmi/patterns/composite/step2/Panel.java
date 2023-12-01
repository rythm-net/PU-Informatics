package fmi.patterns.composite.step2;

public class Panel extends Component {
    private final Component[] components = {new Button(), new Button(), new Button(), new TextArea(), new TextArea()};

    @Override
    public void update() {
        System.out.printf("\nUpdate Panel: %d\n", componentId);
        System.out.println("-----------------------");

        if (components != null) {
            for (Component component : components) {
                component.update();
            }
        }
    }
}
