public class Application {

    public static void loop() {

        while(true) {
            System.out.println("This is message");
        }
    }

    public static void recursive() {
        //System.out.println("This is message");
        //recursive();
    }

    public static void main(String[] args) {
        // recursive();
        // loop();
        //System.out.println("End"); // ???
        // int[] collection = {1,5,8,12,99,150,165,200,240};
        // BSearch.search(collection, 200, 0, collection.length - 1);

        FileTraversal.traverse("C:\\Users\\Alex\\Desktop\\concepts");
    }
}