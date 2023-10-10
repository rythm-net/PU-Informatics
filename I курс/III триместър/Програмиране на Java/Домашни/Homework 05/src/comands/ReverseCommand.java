package comands;

import util.Collection;

public class ReverseCommand {

    public static int[] execute(int[] collection) {
        int[] newCollection = new int[collection.length];

        int newCollectionPointer = 0;
        for(int i = collection.length - 1; i >= 0; i--) {

            newCollection[newCollectionPointer] = collection[i];
            newCollectionPointer++;
        }
        return newCollection;
    }

}