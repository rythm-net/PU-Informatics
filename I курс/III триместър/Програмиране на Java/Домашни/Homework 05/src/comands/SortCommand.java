package comands;

import util.Collection;

public class SortCommand {

    public static int[] sort(int[] inputCollection, boolean isAscending) {
        int[] newInputCollection = Collection.copy(inputCollection);

        for (int numberOfTrial = 0; numberOfTrial < newInputCollection.length; numberOfTrial++) {

            for(int weightPosition = 0; weightPosition < newInputCollection.length - 1 - numberOfTrial; weightPosition++) {

                int leftHandWeightPosition  = weightPosition;
                int leftHandWeight          = newInputCollection[weightPosition];

                int rightHandWeightPosition = weightPosition + 1;
                int rightHandWeight         = newInputCollection[weightPosition + 1];

                boolean isReadyToSwap = (isAscending)
                        ? rightHandWeight < leftHandWeight
                        : rightHandWeight > leftHandWeight;

                if(isReadyToSwap) {
                    newInputCollection[leftHandWeightPosition]     = rightHandWeight;
                    newInputCollection[rightHandWeightPosition]    = leftHandWeight;
                }
            }
        }
        return newInputCollection;
    }
}