package util;

public class Collection {

    public static int[][] copy(int[][] collection) {

        int[][] newCollection = new int[collection.length][collection[0].length];
        for(int row = 0; row < collection.length; row++) {
            for(int col = 0; col < collection[row].length; col++ ) {
                newCollection[row][col] = collection[row][col];
            }
        }
        return newCollection;
    }
}