package comands;

import util.Collection;
import util.Random;

public class ShufleCommand {

    public static int[] shuffle(int[] collection) {
        int[] newCollection = Collection.copy(collection);

        for(int i = 0; i < newCollection.length; i++) {
            int swapPosition            = Random.generate(newCollection.length);
            int currentValue            = newCollection[i];
            newCollection[i]            = newCollection[swapPosition];
            newCollection[swapPosition] = currentValue;
        }
        return newCollection;
    }
}