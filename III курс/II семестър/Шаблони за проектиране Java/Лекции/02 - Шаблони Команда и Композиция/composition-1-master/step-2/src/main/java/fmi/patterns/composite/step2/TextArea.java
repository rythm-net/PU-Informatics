package fmi.patterns.composite.step2;

public class TextArea extends Component {
    @Override
    public void update() {
        System.out.printf("Print TextArea: %d\n", componentId);
    }
}
