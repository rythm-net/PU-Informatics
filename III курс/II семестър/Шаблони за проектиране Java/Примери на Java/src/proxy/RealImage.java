package proxy;

public class RealImage implements Image {

    private String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        loadImage(fileName);
    }

    @Override
    public void render() {
        System.out.println("Rendering: " + fileName);
    }
    private void loadImage(String fileName) {
        System.out.println("Loading: " + fileName);
    }
}
