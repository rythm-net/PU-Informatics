package facade;

public class FacadeMain {

    public static void main(String[] args) {
        ShapeFacade facade = new ShapeFacade();
        facade.drawCircle();
        facade.drawRectangle();
    }

}
