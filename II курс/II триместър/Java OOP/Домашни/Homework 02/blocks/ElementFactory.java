package blocks;
import java.util.ArrayList;

public abstract class ElementFactory {

    public abstract Element createNewElement(String name);
    public abstract Element createNewElement(String name, String content);
    public abstract Element createNewElement(String name, ElementAttribute attribute);

    public abstract ElementList createList();
    public abstract ElementList createList(ElementListEnum listType);
    public abstract ElementList createList(ElementListEnum listType, ArrayList<Element> collection);

    public abstract ElementText createTextElement(String content);

    public abstract ElementAttribute createAttribute(String name, String value);

    public abstract Table createTable(String tableName, int row, int col);
    public abstract Table createTable(int row, int col);
}