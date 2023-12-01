package proxy;

public class ProxyMain {
    public static void main(String[] args) {

        Image image1 = new ProxyImage("hello_world.png");

        // Loaded once but rendered twice
        image1.render();
        image1.render();

    }
}
