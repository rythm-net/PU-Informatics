public class LinearSearch {

    public static boolean isAvailable(int[] collection, int element) {

        for(int i = 0; i < collection.length; i++) {
            if(collection[i] == element) return true;
        }
        return false;
    }
}