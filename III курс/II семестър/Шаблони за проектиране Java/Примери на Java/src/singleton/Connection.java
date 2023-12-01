package singleton;

public class Connection {

    private static Connection instance;

    //Block operator new with making the constructor private
    private Connection() {}

    //Expose getInstance to point always to the same instance
    public static Connection getInstance() {
        if(instance == null) {
            instance = new Connection();
        }
        return instance;
    }

    //Add dummy functionality
    public void connect(String token) {
        System.out.println("Connecting with: " + token);
    }

}
