package fmi.patterns.composite.step2;

public class Menu extends Component {
    @Override
    public void update() {
        System.out.printf("Show Menu: %d\n", componentId);
    }
}
