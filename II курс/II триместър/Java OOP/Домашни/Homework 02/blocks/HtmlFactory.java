package blocks;
import java.util.ArrayList;

public class HtmlFactory extends ElementFactory {

    @Override
    public Element createNewElement(String name) {
        return null;
    }

    @Override
    public Element createNewElement(String name, String content) {
        return null;
    }

    @Override
    public Element createNewElement(String name, ElementAttribute attribute) {
        return null;
    }

    //--------------------------------------------------------------------------------------------------

    @Override
    public Table createTable(String tableName, int row, int col) {
        return null;
    }

    @Override
    public Table createTable(int row, int col) {
        return null;
    }

    //--------------------------------------------------------------------------------------------------

    @Override
    public ElementText createTextElement(String content) {
        return null;
    }

    //--------------------------------------------------------------------------------------------------

    @Override
    public ElementList createList() {
        return null;
    }

    @Override
    public ElementList createList(ElementListEnum listType) {
        return null;
    }

    @Override
    public ElementList createList(ElementListEnum listType, ArrayList<Element> collection) {
        return null;
    }

    //--------------------------------------------------------------------------------------------------

    @Override
    public ElementAttribute createAttribute(String name, String value) {
        return null;
    }
}