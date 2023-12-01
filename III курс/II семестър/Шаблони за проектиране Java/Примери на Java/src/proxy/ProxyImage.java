package proxy;

public class ProxyImage implements Image {

    private RealImage realImage;
    private String fileName;

    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void render() {
        // Can refuse access to RealImage here or perform additional logic before accessing it
        if(realImage == null) {
            realImage = new RealImage(fileName);
        }
        realImage.render();
        // Can execute additional logic after realImage.render() being called
    }
}
