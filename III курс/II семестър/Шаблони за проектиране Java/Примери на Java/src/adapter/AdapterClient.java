package adapter;

public class AdapterClient {

    public static void main(String[] args) {
        ExternalDataProvider externalDataProvider = new ExternalSource();
        DataProvider provider = new DataAdapter(externalDataProvider);
        provider.getData("test.png");
    }
}
