package fmi.patterns.composite.step0;

/**
 * Клас, за хипотетичен визуален компонент - панел, който съдържа и други визуални компоненти
 */
public class Panel {
    private static int sequence = 1;
    private final int panelId;

    private final Button[] buttons = {new Button(), new Button(), new Button()};
    private final TextArea[] textAreas = {new TextArea(), new TextArea()};

    public Panel() {
        panelId = sequence++;
    }

    /**
     * Специфичен метод за визуализиране на панел и останалите компоненти, които се съдържат в него
     */
    public void updateComponents() {
        System.out.printf("\nUpdate Panel: %d\n", panelId);
        System.out.println("-----------------------");

        if (buttons != null) {
            for (Button button : buttons) {
                button.draw();
            }
        }

        if (textAreas != null) {
            for (TextArea textArea : textAreas) {
                textArea.print();
            }
        }
    }
}
