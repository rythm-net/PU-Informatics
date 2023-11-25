package tests;

import blocks.ElementFactory;
import blocks.ElementList;
import blocks.ElementListEnum;
import blocks.HtmlFactory;

public class CreateNewListTest {

    public static void test() {
        createNewEmptyList();
        createNewEmptyUnorderedList();
        createNewUnorderedListWithElements();
        createNewOrderedListWithElements();
    }

    private static void createNewEmptyList() {

        ElementFactory htmlFactory = new HtmlFactory();
        ElementList element = htmlFactory.createList();
        String htmlContent = element.render();

        TestRunner.check(
                htmlContent,
                "<ul></ul>"
        );
    }

    private static void createNewEmptyUnorderedList() {

        ElementFactory htmlFactory = new HtmlFactory();
        ElementList element = htmlFactory.createList(ElementListEnum.Unordered);
        String htmlContent = element.render();

        TestRunner.check(
                htmlContent,
                "<ul></ul>"
        );
    }

    private static void createNewUnorderedListWithElements() {

        ElementFactory htmlFactory = new HtmlFactory();
        ElementList element = htmlFactory.createList(ElementListEnum.Unordered);
        element.addElement(htmlFactory.createNewElement("div", "Element 1"));
        element.addElement(htmlFactory.createTextElement("Simple Text Element"));

        String htmlContent = element.render();

        // <ul>
        //  <li><div>Element 1</div><li>
        //  <li>Simple Text Element<li>
        // </ul>

        TestRunner.check(
                htmlContent,
                "<ul><li><div>Element 1</div></li><li>Simple Text Element</li></ul>"
        );
    }

    private static void createNewOrderedListWithElements() {

        ElementFactory htmlFactory = new HtmlFactory();
        ElementList element = htmlFactory.createList(ElementListEnum.Ordered);
        element.addElement(htmlFactory.createNewElement("div", "Element 1"));
        element.addElement(htmlFactory.createTextElement("Simple Text Element"));

        String htmlContent = element.render();

        // <ol>
        //  <li><div>Element 1</div><li>
        //  <li>Simple Text Element<li>
        // </ol>

        TestRunner.check(
                htmlContent,
                "<ol><li><div>Element 1</div><li><li>Simple Text Element</li></ol>"
        );
    }
}
