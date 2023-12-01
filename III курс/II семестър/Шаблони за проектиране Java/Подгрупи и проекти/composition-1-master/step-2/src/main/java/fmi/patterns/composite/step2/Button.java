package fmi.patterns.composite.step2;

public class Button extends Component {
    @Override
    public void update() {
        System.out.printf("Draw Button: %d\n", componentId);
    }
}
