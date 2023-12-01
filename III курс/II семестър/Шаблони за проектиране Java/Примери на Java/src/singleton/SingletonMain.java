package singleton;

public class SingletonMain {

    public static void main(String[] args) {

        Connection connection = Connection.getInstance();
        connection.connect("123a124asd45323452");

    }
}
