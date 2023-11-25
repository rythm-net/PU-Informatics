package blocks;
import java.util.ArrayList;

public abstract class Element {

    ArrayList<Element> elementsList = new ArrayList<>();

    String name;
    String textContent;


    public  void addElement(Element element) {
        // може би for...
    }

    public String render() {
        // може би for...
        return null;
    }

    public String renderAsTSV() {
        // може би for...
        return null;
    }

    public String getName() {
        return this.name;
    }

    public String getTextContent() {
        return this.textContent;
    }
}