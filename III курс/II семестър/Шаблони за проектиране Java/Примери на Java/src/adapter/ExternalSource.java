package adapter;

public class ExternalSource implements ExternalDataProvider {


    @Override
    public void loadRemoteData(String resource) {
        System.out.println("Load remote data: " + resource);
    }
}
