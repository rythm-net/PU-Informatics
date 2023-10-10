package comands;

public class MinMaxCommand {

    public static int findMin(int[] collection) {
        return find(collection, true);
    }

    public static int findMax(int[] collection) {
        return find(collection, false);
    }

    private static int find(int[] collection, boolean isMin) {
        int result = collection[0];
        for(int i = 1; i < collection.length; i++) {

            boolean isReadyForSwap = (isMin)
                    ? result > collection[i]
                    : result < collection[i];

            if(isReadyForSwap) {
                result = collection[i];
            }
        }
        return result;
    }

}