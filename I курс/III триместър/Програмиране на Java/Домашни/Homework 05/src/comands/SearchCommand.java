package comands;

public class SearchCommand {

    public static int findElementIndex(int[] collection, int element) {
        for(int i = 0; i < collection.length; i++) {
            if(collection[i] == element) {
                return i;
            }
        }
        return -1;
    }
}