package util;

public class Collection {

    public static int[] copy(int[] collection) {
        int[] temporalCollection = new int[collection.length];
        for(int i = 0; i < collection.length; i++) {
            temporalCollection[i] = collection[i];
        }

        return temporalCollection;
    }

    public static void print(int[] collection) {
        Console.print("[ ");
        for(int i = 0; i < collection.length; i++) {
            String separator = (i < collection.length - 1) ? ", " : "";
            Console.print(collection[i] + separator);
        }
        Console.print(" ]");
    }
}