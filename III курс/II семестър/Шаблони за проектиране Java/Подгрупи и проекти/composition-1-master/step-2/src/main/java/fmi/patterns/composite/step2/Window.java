package fmi.patterns.composite.step2;

public class Window extends Component {
    private final Component[] components = {
            new Button(), new Button(),
            new Menu(),
            new TextArea(), new TextArea(), new TextArea(),
            new Panel()
    };

    @Override
    public void update() {
        System.out.println("Display Window");
        System.out.println("-----------------------");

        if (components != null) {
            for (Component component : components) {
                component.update();
            }
        }
    }
}
