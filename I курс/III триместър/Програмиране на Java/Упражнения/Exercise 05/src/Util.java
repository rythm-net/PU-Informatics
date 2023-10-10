public class Util {

    public static void loop(int[] collection) {
        for(int i = 0; i < collection.length; i++) {
            System.out.print(collection[i] + ", ");
        }
    }

    public static int[] copyArray(int[] collection) {
        // нов масив който е празен
        int[] newCollection = new int[collection.length];

        for(int i = 0; i < collection.length; i++) {
            newCollection[i] = collection[i];
        }
        return newCollection;
    }
}