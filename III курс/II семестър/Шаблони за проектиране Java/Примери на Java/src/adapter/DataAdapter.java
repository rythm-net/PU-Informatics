package adapter;

public class DataAdapter implements DataProvider {

    private ExternalDataProvider externalDataProvider;

    public DataAdapter(ExternalDataProvider externalDataProvider) {
        this.externalDataProvider = externalDataProvider;
    }

    @Override
    public void getData(String source) {
        System.out.println("Getting data via adapter");
        this.externalDataProvider.loadRemoteData(source);
    }
}
