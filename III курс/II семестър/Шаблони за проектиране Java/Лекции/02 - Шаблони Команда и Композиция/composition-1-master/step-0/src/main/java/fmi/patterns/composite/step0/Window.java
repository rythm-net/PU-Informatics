package fmi.patterns.composite.step0;

/**
 * Клас, за хипотетичен визуален компонент - прозорец, който съдържа и други визуални компоненти
 */
public class Window {
    private final Button[] buttons = {new Button(), new Button()};
    private final Menu[] menus = {new Menu()};
    private final TextArea[] textAreas = {new TextArea(), new TextArea(), new TextArea()};
    private final Panel[] panels = {new Panel()};

    /**
     * Специфичен метод за визуализиране на прозорец и останалите компоненти, които се съдържат в него
     */
    public void display() {
        System.out.println("Display Window");
        System.out.println("-----------------------");

        if (buttons != null) {
            for (Button button : buttons) {
                button.draw();
            }
        }

        if (menus != null) {
            for (Menu menu : menus) {
                menu.show();
            }
        }

        if (textAreas != null) {
            for (TextArea textArea : textAreas) {
                textArea.print();
            }
        }

        if (panels != null) {
            for (Panel panel: panels) {
                panel.updateComponents();
            }
        }
    }
}
